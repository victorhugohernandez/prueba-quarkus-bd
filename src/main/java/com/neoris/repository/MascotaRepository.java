package com.neoris.repository;

import com.neoris.entity.Mascota;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class MascotaRepository implements PanacheMongoRepository<Mascota> {

    public List<Mascota> find() {
        return listAll(Sort.by("nombre"));
    }

    public Mascota save(Mascota m) {
        persist(m);
        return m;
    }

    public void borrar(Mascota m) {
        delete(m);
    }

    public Mascota actualizar(Mascota m) {
        update(m);
        return m;
    }
}
