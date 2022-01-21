package co.com.sofka.cine.domain.cartelera.command;

import co.com.sofka.cine.domain.generic.Command;

public class AgregarPelicula extends Command {

    private String carteleraId;
    private String peliculaId;
    private String nombrePelicula;
    private String categoria;
    private String sipnosis;
    private String urlImage;
    private String urlVideo;

    public AgregarPelicula() {
    }

    public String getCarteleraId() {
        return carteleraId;
    }

    public void setCarteleraId(String carteleraId) {
        this.carteleraId = carteleraId;
    }

    public String getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(String peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSipnosis() {
        return sipnosis;
    }

    public void setSipnosis(String sipnosis) {
        this.sipnosis = sipnosis;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }
}
