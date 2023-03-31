package com.neoris.repository;

import com.neoris.entity.Cuidador;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CuidadorRepository implements PanacheRepository<Cuidador> {

    public List<Cuidador> find() {

        return listAll(Sort.by("nombre"));
    }

    public Cuidador save(Cuidador m) {
        persist(m);
        return m;
    }

    public void borrar(Cuidador m) {
        delete(m);
    }

    public Cuidador actualizar(Cuidador m) {
        update("nombre=?1, direccion=?2, telefono=?3 where id=?4", m.nombre, m.direccion, m.telefono, m.id);
        return m;
    }
}
