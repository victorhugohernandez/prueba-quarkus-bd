package com.neoris.controller;

import com.neoris.entity.Mascota;
import com.neoris.entity.User;
import com.neoris.exception.MascotaException;
import com.neoris.service.MascotaService;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/mascota")
public class MascotaController {

    @Inject
    MascotaService mascotaService;

    @Inject
    Logger logger;

    @ConfigProperty(name = "mascota.exception.recordsnotfound")
    String recordsNotFound;

    @ConfigProperty(name = "mascota.exception.parametrorequerido")
    String paramRequired;

    @GET
    public Response get() throws MascotaException {
        logger.info("GET");
        List<Mascota> res = mascotaService.find();
        if(res.isEmpty()) {
            throw new MascotaException(recordsNotFound);
        }
        return Response.ok(res).status(200).build();
    }

    @POST
    public Response post(Mascota m) throws MascotaException {
        logger.info("POST");
        if(m.nombre == null || m.nombre.isEmpty()
            || m.raza == null || m.raza.isEmpty()
                || m.edad == null || m.edad.equals(0)) {
            throw new MascotaException(paramRequired);
        }
        Mascota mascota = mascotaService.save(m);
        return Response.ok(mascota).status(200).build();
    }

    @DELETE
    public Response delete(Mascota m) throws MascotaException {
        logger.info("DELETE");
        if(m.id == null) {
            throw new MascotaException(paramRequired);
        }
        mascotaService.borrar(m);
        return Response.ok("Registro eliminado exitosamente", MediaType.TEXT_PLAIN_TYPE).build();
    }

    @PUT
    public Response update(Mascota m) throws MascotaException {
        logger.info("PUT");
        if(m.nombre == null || m.nombre.isEmpty()
                || m.raza == null || m.raza.isEmpty()
                || m.edad == null || m.edad.equals(0)) {
            throw new MascotaException(paramRequired);
        }
        Mascota mascota = mascotaService.actualizar(m);
        return Response.ok(mascota).build();
    }
}
