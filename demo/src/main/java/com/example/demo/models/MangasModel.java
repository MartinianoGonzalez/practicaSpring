package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Table(name = "mangas")
@Entity
@ToString
@EqualsAndHashCode
public class MangasModel {

    @Id
    @Column(name="id")
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="tomo")
    private int tomo;
    @Column(name="precio")
    private float precio;

    public MangasModel() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTomo() {
        return tomo;
    }

    public void setTomo(int tomo) {
        this.tomo = tomo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
