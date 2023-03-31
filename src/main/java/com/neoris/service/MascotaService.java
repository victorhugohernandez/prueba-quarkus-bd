package com.neoris.service;

import com.neoris.entity.Mascota;
import com.neoris.repository.MascotaRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class MascotaService {

    @Inject
    MascotaRepository mascotaRepository;

    public List<Mascota> find() {
        return mascotaRepository.find();
    }

    public Mascota save(Mascota m) {

        return mascotaRepository.save(m);
    }

    public void borrar(Mascota m) {
        mascotaRepository.delete(m);
    }

    public Mascota actualizar(Mascota m) {
        return mascotaRepository.actualizar(m);
    }
}
