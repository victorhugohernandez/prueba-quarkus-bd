package com.neoris.service;

import com.neoris.entity.Mascota;
import com.neoris.repository.MascotaRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.smallrye.common.constraint.Assert;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@QuarkusTest
public class MascotaServiceTest {

    @InjectMock
    MascotaRepository mascotaRepository;

    @Inject
    MascotaService mascotaService;

    @Test
    public void testFind() {
        when(mascotaRepository.find()).thenReturn(List.of(new Mascota()));

        List<Mascota> mascotas = mascotaService.find();

        Assert.assertTrue(mascotas.size() > 0);
    }

    @Test
    public void testSave() {
        Mascota m = new Mascota();
        when(mascotaRepository.save(m)).thenReturn(m);

        Mascota mascota = mascotaService.save(m);

        Assert.assertTrue(mascota != null);
    }

    @Test
    public void testBorrar() {
        mascotaService.borrar(new Mascota());

        Assert.assertTrue(true);
    }

    @Test
    public void testActualizar() {
        Mascota m = new Mascota();
        when(mascotaRepository.actualizar(m)).thenReturn(m);

        Mascota mascota = mascotaService.actualizar(m);

        Assert.assertTrue(mascota != null);
    }
}
