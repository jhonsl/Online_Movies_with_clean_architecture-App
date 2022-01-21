package co.com.sofka.cine.useCases;

import co.com.sofka.cine.domain.cartelera.Cartelera;
import co.com.sofka.cine.domain.cartelera.command.AgregarPelicula;
import co.com.sofka.cine.domain.generic.DomainEvent;
import co.com.sofka.cine.domain.generic.EventStoreRepository;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class AgregarPeliculaUseCase implements Function<AgregarPelicula, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public AgregarPeliculaUseCase(EventStoreRepository repository){
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(AgregarPelicula command) {
        var events = repository.getEventsBy("cartelera", command.getCarteleraId());
        var cartelera = Cartelera.from(command.getCarteleraId(), events);

        cartelera.addPelicula(command.getPeliculaId(),
                command.getNombrePelicula(),
                command.getCategoria(),
                command.getSipnosis(),
                command.getUrlImage(),
                command.getUrlVideo());
        return cartelera.getUncommittedChanges();
    }
}
