package com.neoris.controller;

import com.neoris.entity.Mascota;
import com.neoris.exception.MascotaException;
import com.neoris.service.MascotaService;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MascotaConsumer {

    @Inject
    MascotaService mascotaService;

    @Inject
    Logger log;

    @ConfigProperty(name = "mascota.exception.parametrorequerido")
    String paramRequired;

    @Incoming("mascota")
    public void consume(Mascota m) throws MascotaException {
        log.info("Consume");
        if(m.nombre == null || m.nombre.isEmpty()
                || m.raza == null || m.raza.isEmpty()
                || m.edad == null || m.edad.equals(0)) {
            throw new MascotaException(paramRequired);
        }
        Mascota mascota = mascotaService.save(m);
    }
}
