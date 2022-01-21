package co.com.sofka.cine.infra.generic;

import co.com.sofka.cine.domain.generic.DomainEvent;
import co.com.sofka.cine.domain.generic.EventStoreRepository;
import co.com.sofka.cine.domain.generic.StoredEvent;
import co.com.sofka.cine.infra.message.BusService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

public abstract class UseCaseHandle {
    @Inject
    private EventStoreRepository repository;

    @Inject
    private BusService busService;;

    public void saveCartelera(String carteleraId, List<DomainEvent> events) {
        events.stream().map(event -> {
            String eventBody = EventSerializer.instance().serialize(event);
            return new StoredEvent(event.getClass().getTypeName(), new Date(), eventBody);
        }).forEach(storedEvent -> repository.saveEvent("cartelera", carteleraId, storedEvent));

        events.forEach(busService::send);
    }
}