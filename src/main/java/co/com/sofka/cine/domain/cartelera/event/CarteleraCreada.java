package co.com.sofka.cine.domain.cartelera.event;

import co.com.sofka.cine.domain.generic.DomainEvent;

public class CarteleraCreada extends DomainEvent {
    protected final String nombre;

    public CarteleraCreada(String nombre) {
        super("sofka.cine.carteleraCreada");
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
