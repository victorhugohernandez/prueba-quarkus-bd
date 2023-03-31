package com.neoris.controller;

import com.neoris.entity.Cuidador;
import com.neoris.entity.Mascota;
import com.neoris.exception.MascotaException;
import com.neoris.service.CuidadorService;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/cuidador")
@Transactional
public class CuidadorController {

    @Inject
    CuidadorService cuidadorService;

    @Inject
    Logger logger;

    @ConfigProperty(name = "cuidador.exception.recordsnotfound")
    String recordsNotFound;

    @ConfigProperty(name = "cuidador.exception.parametrorequerido")
    String paramRequired;

    @GET
    public Response get() throws MascotaException {
        logger.info("GET");
        List<Cuidador> res = cuidadorService.find();
        if(res.isEmpty()) {
            throw new MascotaException(recordsNotFound);
        }
        return Response.ok(res).status(200).build();
    }

    @POST
    public Response post(Cuidador m) throws MascotaException {
        logger.info("POST");
        if(m.nombre == null || m.nombre.isEmpty()
                || m.direccion == null || m.direccion.isEmpty()
                || m.telefono == null || m.telefono.isEmpty()) {
            throw new MascotaException(paramRequired);
        }
        Cuidador cuidador = cuidadorService.save(m);
        return Response.ok(cuidador).status(200).build();
    }

    @DELETE
    public Response delete(Cuidador m) throws MascotaException {
        logger.info("DELETE");
        if(m.id == null) {
            throw new MascotaException(paramRequired);
        }
        cuidadorService.borrar(m);
        return Response.ok("Registro eliminado exitosamente", MediaType.TEXT_PLAIN_TYPE).build();
    }

    @PUT
    public Response update(Cuidador m) throws MascotaException {
        logger.info("PUT");
        if(m.nombre == null || m.nombre.isEmpty()
                || m.direccion == null || m.direccion.isEmpty()
                || m.telefono == null || m.telefono.isEmpty()) {
            throw new MascotaException(paramRequired);
        }
        Cuidador cuidador = cuidadorService.actualizar(m);
        return Response.ok(cuidador).build();
    }
}
