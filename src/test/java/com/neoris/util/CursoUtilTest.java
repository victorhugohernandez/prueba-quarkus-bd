package com.neoris.util;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.common.constraint.Assert;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@QuarkusTest
public class CursoUtilTest {

    @Test
    public void unoTest() {
        CursoUtil cursos = new CursoUtil();

        List<Curso> mayorCinco = cursos.findCursos().stream()
                .filter(c -> c.getDuracion() > 5.0f).collect(Collectors.toList());

        Assert.assertTrue(mayorCinco.size() == 3);
    }

    @Test
    public void dosTest() {
        CursoUtil cursos = new CursoUtil();

        List<Curso> menorDos = cursos.findCursos().stream()
                .filter(c -> c.getDuracion() < 2.0f).collect(Collectors.toList());

        Assert.assertTrue(menorDos.size() == 1);
    }

    @Test
    public void tresTest() {
        CursoUtil cursos = new CursoUtil();

        List<String> response = cursos.findCursos().stream()
                .filter(c -> c.getVideos() > 50).map(c -> {return c.getTitulo();}).collect(Collectors.toList());

        Assert.assertTrue(response.size() == 2);
    }

    @Test
    public void cuatroTest() {
        CursoUtil cursos = new CursoUtil();

        List<String> tresMasDuracion = cursos.findCursos().stream().sorted(Comparator.comparing(Curso::getDuracion).reversed()).limit(3)
                .map(c -> {return c.getTitulo();}).collect(Collectors.toList());

        Assert.assertTrue(tresMasDuracion.size() == 3);
    }

    @Test
    public void cincoTest() {
        CursoUtil cursos = new CursoUtil();

        Double duracionTotal = cursos.findCursos().stream().mapToDouble(Curso::getDuracion).sum();

        Assert.assertTrue(duracionTotal.equals(28.5));
    }

    @Test
    public void seisTest() {
        CursoUtil cursos = new CursoUtil();

        Double duracionTotal = cursos.findCursos().stream().mapToDouble(Curso::getDuracion).sum();
        Double promedio = duracionTotal / cursos.findCursos().size();

        List<Curso> mayorPromedio = cursos.findCursos().stream().filter(c -> c.getDuracion() > promedio).collect(Collectors.toList());

        Assert.assertTrue(promedio.equals(5.7));
        Assert.assertTrue(mayorPromedio.size() == 3);
    }

    @Test
    public void sieteTest() {
        CursoUtil cursos = new CursoUtil();

        List<Float> response = cursos.findCursos().stream()
                .filter(c -> c.getAlumnos() < 500).map(c -> {return c.getDuracion();}).collect(Collectors.toList());

        Assert.assertTrue(response.size() == 3);
    }

    @Test
    public void ochoTest() {
        CursoUtil cursos = new CursoUtil();

        List<Curso> mayorDuracion = cursos.findCursos().stream().sorted(Comparator.comparing(Curso::getDuracion).reversed()).limit(1)
                .collect(Collectors.toList());

        Assert.assertTrue(mayorDuracion.get(0).getDuracion() == 8.5f);
    }

    @Test
    public void nueveTest() {
        CursoUtil cursos = new CursoUtil();

        List<String> response = cursos.findCursos().stream()
                .map(c -> {return c.getTitulo();}).collect(Collectors.toList());

        Assert.assertTrue(response.size() == 5);
    }
}
