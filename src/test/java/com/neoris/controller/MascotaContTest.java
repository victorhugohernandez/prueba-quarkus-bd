package com.neoris.controller;

import com.neoris.entity.Mascota;
import com.neoris.service.MascotaService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.http.ContentType;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@QuarkusTest
public class MascotaContTest {

    @InjectMock
    MascotaService mascotaService;
    @Test
    public void testGet() {
        when(mascotaService.find()).thenReturn(List.of(new Mascota()));

        given().when().get("/api/mascota")
                .then()
                .statusCode(200)
                .body("size()", is(1));
    }

    @Test
    public void testPost() {
        Mascota m = new Mascota();
        m.nombre = "Firulais";
        m.raza = "Pastor Aleman";
        m.edad = 3;
        when(mascotaService.save(m)).thenReturn(m);

        given().body(m)
                .header("Content-Type", "application/json")
                .when().post("/api/mascota")
                .then()
                .statusCode(200);
    }

    @Test
    public void testDelete() {

        given().body("{\"id\": \"64249afd18afee2845004c59\"}")
                .header("Content-Type", "application/json")
                .when().delete("/api/mascota")
                .then()
                .statusCode(200);
    }

    @Test
    public void testPut() {
        Mascota m = new Mascota();
        m.nombre = "Firulais";
        m.raza = "Pastor Aleman";
        m.edad = 3;

        when(mascotaService.actualizar(m)).thenReturn(m);

        given().body(m)
                .header("Content-Type", "application/json")
                .when().put("/api/mascota")
                .then()
                .statusCode(200);
    }
}
