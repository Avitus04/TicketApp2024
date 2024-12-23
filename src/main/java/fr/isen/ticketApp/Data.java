package fr.isen.ticketApp;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.isen.ticketApp.interfaces.models.TicketModel;
import fr.isen.ticketApp.interfaces.models.DevicesModel;
import fr.isen.ticketApp.interfaces.models.UserModel;

import java.util.List;


// Classe principale pour contenir l'ensemble des données
public class Data {
    @JsonProperty("tickets")
    private List<TicketModel> tickets;

    @JsonProperty("utilisateur")
    private List<UserModel> users;

    @JsonProperty("poste_informatique")
    private List<DevicesModel> devicesModel;

    // Getters et setters
    public List<TicketModel> getTickets()
    {
        return tickets;
    }

    public void setTickets(List<TicketModel> tickets) {
        this.tickets = tickets;
    }

    public List<UserModel> getUserModel() {
        return users;
    }

    public void setUserModel(List<UserModel> utilisateurs) {
        this.users = utilisateurs;
    }

    public List<DevicesModel> getDevices() {
        return devicesModel;
    }

    public void setDevices(List<DevicesModel> postesInformatique) {
        this.devicesModel = postesInformatique;
    }
}
