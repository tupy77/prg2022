package com.prg2022.proyectoQR.modelos;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity

@Table(name = "brigada")

public class Brigada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String descripcion;    

    public Brigada() {
    }

    public Brigada(String descripcion) {
        this.descripcion = descripcion;
      }

    public String getDescripcion() {
    return descripcion;
    }

    public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
    }      
    
}
