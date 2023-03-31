package com.neoris.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Usuario extends PanacheEntity {

    public String name;
}
