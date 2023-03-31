package com.neoris.exception;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MascotaExceptionHandler implements ExceptionMapper<MascotaException> {

    @ConfigProperty(name = "mascota.exception.recordsnotfound")
    String recordsNotFound;

    @ConfigProperty(name = "mascota.exception.parametrorequerido")
    String paramRequired;

    @Override
    public Response toResponse(MascotaException e) {
        if (e.getMessage().equalsIgnoreCase(recordsNotFound)) {

            return Response.status(Response.Status.NOT_FOUND).
                    entity(new ErrorMessage(e.getMessage())).build();
        } if (e.getMessage().equalsIgnoreCase(paramRequired)) {

            return Response.status(Response.Status.BAD_REQUEST).
                    entity(new ErrorMessage(e.getMessage())).build();
        }else {

            return Response.status(Response.Status.SERVICE_UNAVAILABLE).
                    entity(new ErrorMessage(e.getMessage())).build();
        }
    }
}
