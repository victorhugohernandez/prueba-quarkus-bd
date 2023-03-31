package com.neoris.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class User extends PanacheMongoEntity {
    public String name;
}
