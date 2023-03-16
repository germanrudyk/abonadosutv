/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniontv.cuotas.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author German
 */

@Entity
public class Abonado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_abonado;
    private String nombre;
    private String dni;
    private String domicilio;
    @Temporal(TemporalType.DATE)
    private Date alta;

    public Abonado() {
    }

    public Integer getId() {
        return id_abonado;
    }

    public void setId(Integer id) {
        this.id_abonado = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Date getAlta() {
        return alta;
    }

    public void setAlta(Date alta) {
        this.alta = alta;
    }      
    
}
