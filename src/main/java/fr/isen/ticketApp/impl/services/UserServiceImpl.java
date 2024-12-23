package fr.isen.ticketApp.impl.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.isen.ticketApp.Data;
import fr.isen.ticketApp.interfaces.models.UserModel;
import fr.isen.ticketApp.interfaces.services.UsersService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UsersService {

    private static final String JSON_FILE_PATH = "src/main/resources/users.JSON";

    private List<UserModel> users = null;

    // methode pour lire les donnees
    private int readData()
    {
        ObjectMapper mapper = new ObjectMapper();
        Data data = null;
        try {
            data = mapper.readValue(new File(JSON_FILE_PATH), Data.class);
        } catch (IOException e) {
            return -1;
        }

        this.users = data.getUserModel();

        return  1;
    }

    @Produces(MediaType.APPLICATION_JSON) // Les méthodes retourneront du JSON
    @Override
    public List<UserModel> getAllUsers() {
        if (this.users == null)
        {
            int result = readData();
            if (result == -1)
                throw new RuntimeException();
        }
        return this.users;
    }

    @Produces(MediaType.APPLICATION_JSON) // Les méthodes retourneront du JSON
    @Override
    public UserModel getUserById(int Id) {
        if (this.users == null)
        {
            int result = readData();
            if (result == -1)
                throw new RuntimeException();
        }

        UserModel u = this.users.stream()
                .filter(user -> user.getId() == Id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé pour l'ID " + Id));

        return u;
    }

    @Consumes(MediaType.APPLICATION_JSON) // Les méthodes accepteront du JSON
    @Override
    public int addUser(UserModel User) {
        if (this.users == null)
        {
            int result = readData();
            if (result == -1)
                return -1;
        }

        User.setId(this.users.getLast().getId() + 1);
        this.users.add(User);

        return 1;
    }

    @Consumes(MediaType.APPLICATION_JSON) // Les méthodes accepteront du JSON
    @Override
    public int updateUser(int Id, UserModel User) {
        if (this.users == null)
        {
            int result = readData();
            if (result == -1)
                return -1;
        }

        UserModel existingUser = this.users.stream()
                .filter(user -> user.getId() == Id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé pour l'ID " + Id));

        if (User.getId() != 0 && User.getId() != existingUser.getId()) {existingUser.setId(User.getId());}
        if (User.nom != null) {existingUser.nom = User.nom;}
        if (User.email != null) {existingUser.email = User.email;}
        if (User.mot_de_passe != null) {existingUser.mot_de_passe = User.mot_de_passe;}
        if (User.date_derniere_connexion != null) {existingUser.date_derniere_connexion = User.date_derniere_connexion;}
        if (User.statut != existingUser.statut) {existingUser.statut = User.statut;}
        if (User.role != null) {existingUser.role = User.role;}

        return 1;
    }

    @Override
    public int removeUser(int Id) {
        if (this.users == null)
        {
            int result = readData();
            if (result == -1)
                return -1;
        }

        boolean removed = this.users.removeIf(user -> user.getId() == Id);
        if (!removed) {
            return -2;
        }

        return 1;
    }

    @Override
    public UserModel connexionUsers(boolean statut) {
        return null;
    }
}
