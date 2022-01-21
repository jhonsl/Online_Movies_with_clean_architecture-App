package co.com.sofka.cine.infra.handle;

import co.com.sofka.cine.domain.cartelera.command.AgregarPelicula;
import co.com.sofka.cine.infra.generic.UseCaseHandle;
import co.com.sofka.cine.useCases.AgregarPeliculaUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AgregarPeliculaHandle extends UseCaseHandle {

    private final AgregarPeliculaUseCase useCase;

    public AgregarPeliculaHandle(AgregarPeliculaUseCase useCase) {
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofka.cartelera.addMovie")
    void consumeBlocking(AgregarPelicula command) {
        var events = useCase.apply(command);
        saveCartelera(command.getCarteleraId(), events);
    }
}
