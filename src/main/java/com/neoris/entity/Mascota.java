package com.neoris.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Mascota extends PanacheMongoEntity {

    public String nombre;
    public String raza;
    public Integer edad;
    public String talla;
}
