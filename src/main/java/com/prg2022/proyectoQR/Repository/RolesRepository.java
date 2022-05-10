package com.prg2022.proyectoQR.Repository;

import java.util.List;

import com.prg2022.proyectoQR.modelos.Roles;

import org.springframework.data.jpa.repository.JpaRepository;



public interface RolesRepository extends JpaRepository<Roles, Integer>{
    List<Roles> findByTipo(String tipo);
}
