package com.neoris.service;

import com.neoris.entity.Cuidador;
import com.neoris.entity.Mascota;
import com.neoris.repository.CuidadorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CuidadorService {

    @Inject
    CuidadorRepository cuidadorRepository;

    public List<Cuidador> find() {
        return cuidadorRepository.find();
    }

    public Cuidador save(Cuidador m) {

        return cuidadorRepository.save(m);
    }

    public void borrar(Cuidador m) {
        cuidadorRepository.delete(m);
    }

    public Cuidador actualizar(Cuidador m) {
        return cuidadorRepository.actualizar(m);
    }
}
