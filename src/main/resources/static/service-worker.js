
/*
 * @license
 * PWA Codelab (https://g.co/codelabs/pwa)
 * Copyright 2019 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
'use strict';

const CACHE_NAME = 'static-cache-v1';

const FILES_TO_CACHE = [  '/sininternet.html',
];

self.addEventListener('install', (evt) => {
  console.log('[ServiceWorker] Install');
	evt.waitUntil(
		caches.open(CACHE_NAME).then((cache) => {
		  return cache.addAll(FILES_TO_CACHE);
		})
	);	

  self.skipWaiting();
});

self.addEventListener('activate', (evt) => {
		evt.waitUntil(
			caches.keys().then((keyList) => {
			  return Promise.all(keyList.map((key) => {
				if (key !== CACHE_NAME) {
				  return caches.delete(key);
				}
			  }));
			})
		);
  self.clients.claim();
});

self.addEventListener('fetch', (evt) => {
		if (evt.request.mode !== 'navigate') {
		  return;
		}
		evt.respondWith(
			fetch(evt.request)
				.catch(() => {
				  return caches.open(CACHE_NAME)
					  .then((cache) => {
						return cache.match('sininternet.html');
					  });
				})
		);	

});