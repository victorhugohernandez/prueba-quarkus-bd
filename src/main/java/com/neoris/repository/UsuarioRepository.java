package com.neoris.repository;

import com.neoris.entity.User;
import com.neoris.entity.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public List<Usuario> findAllUser() {
        return listAll(Sort.by("name"));
    }
}
