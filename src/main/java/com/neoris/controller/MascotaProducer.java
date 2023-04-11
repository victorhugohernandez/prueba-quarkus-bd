package com.neoris.controller;

import com.neoris.entity.Mascota;
import com.neoris.exception.MascotaException;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletionStage;

@Path("/api/kafka")
public class MascotaProducer {

    @Inject
    Logger log;

    @Inject
    @Channel("mascota-out")
    Emitter<Mascota> priceEmitter;

    @ConfigProperty(name = "mascota.exception.parametrorequerido")
    String paramRequired;

    @POST
    public Response sendKafka(Mascota m) throws MascotaException {
        log.info("Parametro recibido: " +m.nombre);
        if(m.nombre == null || m.nombre.isEmpty()
                || m.raza == null || m.raza.isEmpty()
                || m.edad == null || m.edad.equals(0)) {
            throw new MascotaException(paramRequired);
        }
        CompletionStage<Void> ack = priceEmitter.send(m);
        return Response.ok("Registro almacenado exitosamente", MediaType.TEXT_PLAIN_TYPE).build();
    }
}
