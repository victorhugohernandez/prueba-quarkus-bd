package com.neoris;

import com.neoris.entity.User;
import com.neoris.entity.Usuario;
import com.neoris.service.UserService;
import com.neoris.service.UsuarioService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/test")
public class Application {

    @Inject
    UserService userService;

    @Inject
    UsuarioService usuarioService;
    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }


    @GET
    @Path("/save")
    public String save() {
        User user = new User();
        user.name = "Juan";
        user.persist();

        return "Operacion Exitosa";
    }

    @GET
    @Path("/save-postgres")
    @Transactional
    public String savePostgres() {
        Usuario user = new Usuario();
        user.name = "Juan";
        user.persist();

        return "Operacion Exitosa";
    }

    @GET
    @Path("/mongo")
    public List<User> getMongo() {
        logger.info("Mongo");
        return userService.findAllUser();
    }

    @GET
    @Path("/postgres")
    public List<Usuario> getPostgres() {
        logger.info("Postgres");
        return usuarioService.findAllUser();
    }
}