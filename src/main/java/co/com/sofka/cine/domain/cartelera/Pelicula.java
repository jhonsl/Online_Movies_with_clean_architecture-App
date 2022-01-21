package co.com.sofka.cine.domain.cartelera;

import java.util.Objects;

public final class Pelicula {
    private final String id;
    private final String nombrePelicula;
    private final String categoria;
    private final String sipnosis;
    private final String urlImage;
    private final String urlVideo;

    public Pelicula(String id, String nombrePelicula,String categoria, String sipnosis, String urlImage, String urlVideo) {
        this.id = Objects.requireNonNull(id);
        this.nombrePelicula = Objects.requireNonNull(nombrePelicula);
        this.categoria = Objects.requireNonNull(categoria);
        this.sipnosis = Objects.requireNonNull(sipnosis);
        this.urlImage = Objects.requireNonNull(urlImage);
        this.urlVideo = Objects.requireNonNull(urlVideo);
    }

    public String id() {
        return id;
    }

    public String nombrePelicula() {
        return nombrePelicula;
    }

    public String categoria() {
        return categoria;
    }

    public String sipnosis() {
        return sipnosis;
    }

    public String urlImage() {
        return urlImage;
    }

    public String urlVideo() {
        return urlVideo;
    }
}
