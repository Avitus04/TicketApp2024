package fr.isen.ticketApp.interfaces;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.InputStream;

@Path("/api")
public class GreetingResource {

    @GET
    @Path("/tickets")
    @Produces(MediaType.APPLICATION_JSON)

    public JsonObject readJsonFile() {
        // Obtenir le fichier JSON comme InputStream
        InputStream jsonFile = getClass().getResourceAsStream("src/test/resources/tickets.JSON.json");

        // Vérifier que le fichier existe
        if (jsonFile == null) {
            throw new IllegalArgumentException("Le fichier " + "src/test/resources/tickets.JSON" + " est introuvable.");
        }

        // Lire et retourner l'objet JSON
        try (var jsonReader = Json.createReader(jsonFile)) {
            return jsonReader.readObject();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la lecture du fichier JSON : " + e.getMessage(), e);
        }
    }
}