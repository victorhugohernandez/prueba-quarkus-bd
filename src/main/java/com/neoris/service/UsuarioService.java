package com.neoris.service;

import com.neoris.entity.User;
import com.neoris.entity.Usuario;
import com.neoris.repository.UsuarioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    public List<Usuario> findAllUser() {
        return usuarioRepository.findAllUser();
    }
}
