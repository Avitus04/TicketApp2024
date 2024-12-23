package fr.isen.ticketApp.interfaces;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.isen.ticketApp.Data;
import fr.isen.ticketApp.impl.services.TicketServiceImpl;
import fr.isen.ticketApp.interfaces.models.TicketModel;
import fr.isen.ticketApp.interfaces.services.TicketService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.io.File;
import java.util.List;

@Path("/") // Chemin de base de la ressource REST
@Produces(MediaType.APPLICATION_JSON) // Les méthodes retourneront du JSON
@Consumes(MediaType.APPLICATION_JSON) // Les méthodes accepteront du JSON
public class TicketResource {

    private TicketService ticketService;

    public TicketResource()
    {
        this.ticketService = new TicketServiceImpl();
    }

    // Méthode pour récupérer la liste des tickets
    @GET
    @Path("/tickets")
    public List<TicketModel> getTickets(){
        return ticketService.getAllTickets();
    }

    // Méthode pour récupérer un ticket par son ID
    @GET
    @Path("/tickets/{id}")
    public TicketModel getTicketById(@PathParam("id") int id){
        return this.ticketService.getTicketById(id);
    }


    @POST
    @Path("/tickets")
    public String createTicket(TicketModel ticket) throws Exception {
        int result = this.ticketService.addTicket(ticket);

        if (result == 1) {return "Le ticket a ete cree.";}
        else {return "Erreur lors de la creation du ticket.";}
    }


    // Mettre à jour un ticket
    @PUT
    @Path("/tickets/{id}")
    public String updateTicket(@PathParam("id") int Id, TicketModel updatedTicket) throws Exception {
        int result = this.ticketService.updateTicket(Id, updatedTicket);

        if (result == 1) {return "Changements bien effectués";}
        else {return "Erreur lors du changement d'informations";}
    }


    // Supprimer un ticket
    @DELETE
    @Path("/tickets/{id}")
    public String deleteTicket(@PathParam("id") int id) throws Exception {
        int result = this.ticketService.removeTicket(id);

        if (result == 1) {return "Le ticket a ete supprime";}
        else if (result == -1) {return "Erreur lors de l'ouverture du fichier";}
        else {return "Ticket non trouvé pour l'ID :" + id;}
    }

}
