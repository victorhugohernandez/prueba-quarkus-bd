package com.neoris.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Cuidador extends PanacheEntity {

    public String nombre;

    public String direccion;

    public String telefono;
}
