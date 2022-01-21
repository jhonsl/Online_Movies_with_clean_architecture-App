package co.com.sofka.cine.infra.entrypoint;


import co.com.sofka.cine.domain.cartelera.command.AgregarPelicula;
import co.com.sofka.cine.domain.cartelera.command.CrearCartelera;
import io.vertx.core.eventbus.EventBus;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/cartelera")
public class CommandController {
    private final EventBus bus;

    public CommandController(EventBus bus) {
        this.bus = bus;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response executor(CrearCartelera command) {
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addMovie")
    public Response executor(AgregarPelicula command) {
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }
}
