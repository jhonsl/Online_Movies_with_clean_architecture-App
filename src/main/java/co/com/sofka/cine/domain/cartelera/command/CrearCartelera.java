package co.com.sofka.cine.domain.cartelera.command;

import co.com.sofka.cine.domain.generic.Command;

public class CrearCartelera extends Command {

    private String carteleraId;
    private String nombre;

    public CrearCartelera() {
    }

    public String getCarteleraId() {
        return carteleraId;
    }

    public void setCarteleraId(String carteleraId) {
        this.carteleraId = carteleraId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
