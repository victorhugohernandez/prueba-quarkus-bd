package com.neoris.service;

import com.neoris.entity.Cuidador;
import com.neoris.entity.Mascota;
import com.neoris.repository.CuidadorRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.smallrye.common.constraint.Assert;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.mockito.Mockito.when;

@QuarkusTest
public class CuidadorServiceTest {

    @InjectMock
    CuidadorRepository cuidadorRepository;

    @Inject
    CuidadorService cuidadorService;

    @Test
    public void testFind() {
        when(cuidadorRepository.find()).thenReturn(List.of(new Cuidador()));

        List<Cuidador> c = cuidadorService.find();

        Assert.assertTrue(c.size() > 0);
    }

    @Test
    public void testSave() {
        Cuidador c = new Cuidador();
        when(cuidadorRepository.save(c)).thenReturn(c);

        Cuidador cuidador = cuidadorService.save(c);

        Assert.assertTrue(cuidador != null);
    }

    @Test
    public void testBorrar() {
        cuidadorService.borrar(new Cuidador());

        Assert.assertTrue(true);
    }

    @Test
    public void testActualizar() {
        Cuidador c = new Cuidador();
        when(cuidadorRepository.actualizar(c)).thenReturn(c);

        Cuidador cuidador = cuidadorService.actualizar(c);

        Assert.assertTrue(cuidador != null);
    }
}
