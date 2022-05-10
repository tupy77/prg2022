package com.prg2022.proyectoQR.modelos;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity

@Table(name = "roles")

public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String tipo; 

    @OneToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Alumno> alumno;

    public Roles() {
    }

    public Roles(String tipo) {
        this.tipo = tipo;
      }

    public String getRol() { return tipo; }

    public void setRol(String tipo) { this.tipo = tipo; } 

}
