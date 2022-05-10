package com.prg2022.proyectoQR.modelos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roles_id", nullable = false)
    private Roles roles;  
    
    @NotBlank
    @NotNull
    @Column(unique=true)
    private String dni;

    private String clave;

    public Alumno() {
    }

    public Alumno(String nombre, String dni, Brigada brigada, Roles roles) {
        this.nombre = nombre;
        this.dni = dni;
        this.brigada = brigada;
        this.roles=roles;
    }

    public String getClave() { return clave; }
    public String getDni() { return dni; }
    public Roles getRoles() { return roles; }
    public String getRol() { return roles.getRol(); }

	public void setClave(String clave) { this.clave = clave;}
    public void setDni(String dni) { this.dni = dni;}
    public void setRoles(Roles roles) { this.roles = roles;}



}
