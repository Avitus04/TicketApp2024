package fr.isen.ticketApp.interfaces;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.isen.ticketApp.Data;
import fr.isen.ticketApp.impl.services.UserServiceImpl;
import fr.isen.ticketApp.interfaces.models.UserModel;
import fr.isen.ticketApp.interfaces.services.UsersService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.io.File;
import java.util.List;

@Path("/") // Chemin de base de la ressource REST
@Produces(MediaType.APPLICATION_JSON) // Les méthodes retourneront du JSON
@Consumes(MediaType.APPLICATION_JSON) // Les méthodes accepteront du JSON
public class UserResource {

    public UsersService usersService;

    public UserResource()
    {
        usersService= new UserServiceImpl();
    }

    // Méthode pour récupérer uniquement la liste des tickets
    @GET
    @Path("/users")
    public List<UserModel> getUsers() throws Exception {
        return this.usersService.getAllUsers();
    }


    // Méthode pour récupérer un ticket par son ID
    @GET
    @Path("/users/{id}")
    public UserModel getOneUser(@PathParam("id") int Id) throws Exception {
        return this.usersService.getUserById(Id);
    }

    // Ajouter un utilisateur
    @POST
    @Path("/users")
    public String createUser(UserModel user) throws Exception {
        int result = this.usersService.addUser(user);

        if (result == 1) {return "L'utilisateur a ete rajouté.";}
        else {return "Erreur lors de la creation du poste informatique.";}
    }

    // Mettre à jour un utilisateur
    @PUT
    @Path("/users/{id}")
    public String updateUser(@PathParam("id") int Id, UserModel updatedUser) throws Exception {
        int result = this.usersService.updateUser(Id, updatedUser);

        if (result == 1) {return "Changements bien effectués";}
        else {return "Erreur lors du changement d'informations";}
    }

    // Supprimer un utilisateur
    @DELETE
    @Path("/users/{id}")
    public String deleteUser(@PathParam("id") int Id) throws Exception {
        int result = this.usersService.removeUser(Id);

        if (result == 1) {return "L'utilisateur a ete supprime";}
        else if (result == -1) {return "Erreur lors de l'ouverture du fichier";}
        else {return "Utilisateur non trouvé pour l'ID :" + Id;}
    }

}
