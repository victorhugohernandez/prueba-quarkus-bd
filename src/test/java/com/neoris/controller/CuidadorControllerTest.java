package com.neoris.controller;

import com.neoris.entity.Cuidador;
import com.neoris.entity.Mascota;
import com.neoris.service.CuidadorService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@QuarkusTest
public class CuidadorControllerTest {

    @InjectMock
    CuidadorService cuidadorService;

    @Test
    public void testGet() {
        when(cuidadorService.find()).thenReturn(List.of(new Cuidador()));

        given().when().get("/api/cuidador")
                .then()
                .statusCode(200)
                .body("size()", is(1));
    }

    @Test
    public void testPost() {
        Cuidador c = new Cuidador();
        c.nombre = "Manuel Alvarado";
        c.direccion = "Manzana 40";
        c.telefono = "77744229944";

        when(cuidadorService.save(c)).thenReturn(c);

        given().body(c)
                .header("Content-Type", "application/json")
                .when().post("/api/cuidador")
                .then()
                .statusCode(200);
    }

    @Test
    public void testDelete() {

        given().body("{\"id\": \"1\"}")
                .header("Content-Type", "application/json")
                .when().delete("/api/cuidador")
                .then()
                .statusCode(200);

    }

    @Test
    public void testPut() {
        Cuidador c = new Cuidador();
        c.nombre = "Manuel Alvarado";
        c.direccion = "Manzana 40";
        c.telefono = "77744229944";

        when(cuidadorService.actualizar(c)).thenReturn(c);

        given().body(c)
                .header("Content-Type", "application/json")
                .when().put("/api/cuidador")
                .then()
                .statusCode(200);
    }
}
