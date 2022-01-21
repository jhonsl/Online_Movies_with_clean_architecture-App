package co.com.sofka.cine.domain.cartelera;

import co.com.sofka.cine.domain.cartelera.event.CarteleraCreada;
import co.com.sofka.cine.domain.cartelera.event.PeliculaAgregada;
import co.com.sofka.cine.domain.generic.EventChange;

import java.util.HashMap;
import java.util.Objects;

public class CarteleraEventChange implements EventChange {

    protected CarteleraEventChange(Cartelera cartelera){
        listener((CarteleraCreada event) -> {
            cartelera.nombre = event.getNombre();
            cartelera.peliculas = new HashMap<>();
        });

        listener((PeliculaAgregada event) -> {
            var pelicula = new Pelicula(
                    event.getPeliculaId(),
                    event.getNombrePelicula(),
                    event.getCategoria(),
                    event.getSipnosis(),
                    event.getUrlImage(),
                    event.getUrlVideo());
            cartelera.peliculas.put(event.getPeliculaId(), pelicula);
        });
    }
}
