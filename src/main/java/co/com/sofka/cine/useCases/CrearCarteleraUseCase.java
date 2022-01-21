package co.com.sofka.cine.useCases;

import co.com.sofka.cine.domain.cartelera.Cartelera;
import co.com.sofka.cine.domain.cartelera.command.CrearCartelera;
import co.com.sofka.cine.domain.generic.DomainEvent;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class CrearCarteleraUseCase implements Function<CrearCartelera, List<DomainEvent>> {

    @Override
    public List<DomainEvent> apply(CrearCartelera command) {
        var cartelera = new Cartelera(
                command.getCarteleraId(),
                command.getNombre());
        return cartelera.getUncommittedChanges();
    }
}