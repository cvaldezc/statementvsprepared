/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.valdezchavez.eje02.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Christian
 */
public class Empleado implements Serializable, Comparable<Empleado> {
    
    private static final long serialVersionUID = 1496202564977879961L;
    
    private Integer id;
    private String nombres;
    private String apellidos;
    private Double remuneracion;
    private Integer edad;
    
    private transient Double bruto;

    public Empleado() {}
    
    public Empleado(Integer id, String nombres, String apellidos, Double remuneracion, Integer edad, Double bruto) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.remuneracion = remuneracion;
        this.edad = edad;
        this.bruto = bruto;
    }
  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Double getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(Double remuneracion) {
        this.remuneracion = remuneracion;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    
    public Double getBruto() {
        return bruto;
    }

    public void setBruto(Double bruto) {
        this.bruto = bruto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", remuneracion=" + remuneracion + ", edad=" + edad + ", Bruto=" + bruto + '}';
    }

    @Override
    public int compareTo(Empleado o) {
        return this.id.compareTo(o.id);
    }
    
    public Object[] toParams(){
        return new Object[] { this.getNombres(), this.getApellidos(), this.getRemuneracion(), this.getEdad() };
    }

    
}
