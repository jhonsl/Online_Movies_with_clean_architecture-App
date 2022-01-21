package co.com.sofka.cine.infra.materialize;

import co.com.sofka.cine.domain.cartelera.event.CarteleraCreada;
import co.com.sofka.cine.domain.cartelera.event.PeliculaAgregada;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import io.quarkus.vertx.ConsumeEvent;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CarteleraHandle {
    private final MongoClient mongoClient;

    public CarteleraHandle(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @ConsumeEvent(value = "sofka.cine.carteleraCreada", blocking = true)
    void consumeCarteleraCreated(CarteleraCreada event) {
        Map<String, Object> document = new HashMap<>();
        document.put("_id", event.getAggregateId());
        document.put("nombre", event.getNombre());

        mongoClient.getDatabase("queries")
                .getCollection("cartelera")
                .insertOne(new Document(document));
    }

    @ConsumeEvent(value = "sofka.cine.peliculaAgregada", blocking = true)
    void consumePeliculaAgregada(PeliculaAgregada event) {
        BasicDBObject document = new BasicDBObject();
        document.put("peliculas."+event.getPeliculaId().strip()+".nombrePelicula",event.getNombrePelicula());
        document.put("peliculas."+event.getPeliculaId().strip()+".categoria",event.getCategoria());
        document.put("peliculas."+event.getPeliculaId().strip()+".sipnosis",event.getSipnosis());
        document.put("peliculas."+event.getPeliculaId().strip()+".urlImage",event.getUrlImage());
        document.put("peliculas."+event.getPeliculaId().strip()+".urlVideo",event.getUrlVideo());
        document.put("peliculas."+event.getPeliculaId().strip()+".urlImage",event.getUrlImage());

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", document);

        mongoClient.getDatabase("queries")
                .getCollection("cartelera")
                .updateOne( Filters.eq("_id", event.getAggregateId()), updateObject);
    }
}