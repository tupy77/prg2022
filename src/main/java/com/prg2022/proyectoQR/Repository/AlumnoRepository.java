package com.prg2022.proyectoQR.Repository;

import java.util.List;

import com.prg2022.proyectoQR.modelos.Alumno;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    List<Alumno> findByDni(String dni);
}
