package co.com.sofka.cine.domain.cartelera;

import co.com.sofka.cine.domain.cartelera.event.CarteleraCreada;
import co.com.sofka.cine.domain.cartelera.event.PeliculaAgregada;
import co.com.sofka.cine.domain.generic.AggregateRoot;
import co.com.sofka.cine.domain.generic.DomainEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cartelera extends AggregateRoot {
    protected String nombre;
    protected Map<String, Pelicula> peliculas;

    public Cartelera(String carteleraId, String nombre) {
        super(carteleraId);
        subscribe(new CarteleraEventChange(this));
        peliculas = new HashMap<>();
        appendChange(new CarteleraCreada(nombre)).apply();
    }

    private Cartelera(String id) {
        super(id);
        subscribe(new CarteleraEventChange(this));
    }

    public static Cartelera from(String id, List<DomainEvent> events) {
        var cartelera = new Cartelera(id);
        events.forEach(cartelera::applyEvent);

        return cartelera;
    }

    public void addPelicula(String peliculaId, String nombrePelicula, String categoria, String sipnosis, String urlImage, String urlVideo){
        appendChange(new PeliculaAgregada(peliculaId, nombrePelicula, categoria, sipnosis, urlImage, urlVideo)).apply();
    }

    public String nombre() {
        return nombre;
    }

    public Map<String, Pelicula> peliculas() {
        return peliculas;
    }
}
