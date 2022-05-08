package com.prg2022.proyectoQR.repositorios;

import java.util.Optional;

import com.prg2022.proyectoQR.modelos.Brigada;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BrigadaRepository extends JpaRepository<Brigada, Long>{
    Optional<Brigada> findByDescripcion(String descripcion);
}
