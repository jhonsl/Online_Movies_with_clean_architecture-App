package co.com.sofka.cine.infra.handle;

import co.com.sofka.cine.domain.cartelera.command.CrearCartelera;
import co.com.sofka.cine.infra.generic.UseCaseHandle;
import co.com.sofka.cine.useCases.CrearCarteleraUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CrearCarteleraHandle extends UseCaseHandle {

    private final CrearCarteleraUseCase useCase;

    public CrearCarteleraHandle(CrearCarteleraUseCase useCase){
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofka.cartelera.create")
    void consumeBlocking(CrearCartelera command) {
        var events = useCase.apply(command);
        saveCartelera(command.getCarteleraId(), events);
    }
}
