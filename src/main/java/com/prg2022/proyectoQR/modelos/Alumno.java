package com.prg2022.proyectoQR.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "alumno")

public class Alumno implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String nombre;     

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brigada_id", nullable = false)
    private Brigada brigada;    

    public Alumno() {
    }

    public Alumno(String nombre, Brigada brigada) {
        this.nombre = nombre;
        this.brigada = brigada;
    }



}
