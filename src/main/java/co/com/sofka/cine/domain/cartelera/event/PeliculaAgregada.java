package co.com.sofka.cine.domain.cartelera.event;

import co.com.sofka.cine.domain.generic.DomainEvent;

public class PeliculaAgregada extends DomainEvent {

    private final String peliculaId;
    private final String nombrePelicula;
    private final String categoria;
    private final String sipnosis;
    private final String urlImage;
    private final String urlVideo;

    public PeliculaAgregada(String peliculaId, String nombrePelicula, String categoria, String sipnosis, String urlImage, String urlVideo) {
        super("sofka.cine.peliculaAgregada");
        this.peliculaId = peliculaId;
        this.nombrePelicula = nombrePelicula;
        this.categoria = categoria;
        this.sipnosis = sipnosis;
        this.urlImage = urlImage;
        this.urlVideo = urlVideo;
    }

    public String getPeliculaId() {
        return peliculaId;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getSipnosis() {
        return sipnosis;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getUrlVideo() {
        return urlVideo;
    }
}
