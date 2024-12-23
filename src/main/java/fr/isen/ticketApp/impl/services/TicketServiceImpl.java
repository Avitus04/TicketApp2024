package fr.isen.ticketApp.impl.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.isen.ticketApp.Data;
import fr.isen.ticketApp.MySQLCRUD;

import fr.isen.ticketApp.interfaces.models.DevicesModel;
import fr.isen.ticketApp.interfaces.models.TicketModel;
import fr.isen.ticketApp.interfaces.models.enums.ETAT_TICKET;
import fr.isen.ticketApp.interfaces.models.enums.IMPACT;
import fr.isen.ticketApp.interfaces.services.TicketService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TicketServiceImpl implements TicketService {

    private static final String JSON_FILE_PATH = "src/main/resources/tickets.JSON";

    private MySQLCRUD mySQLCRUD = new MySQLCRUD();

    private List<TicketModel> tickets = null;


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

        this.tickets = data.getTickets();

        return  1;
    }



    @Produces(MediaType.APPLICATION_JSON) // Les méthodes retourneront du JSON
    @Override
    public List<TicketModel> getAllTickets() {
        try
        {
            List<Map<String, Object>> data = mySQLCRUD.getAll("TicketModel");
            List<TicketModel> tickets = new ArrayList<>();

            for (Map<String, Object> row : data) {
                TicketModel ticket = new TicketModel();
                ticket.setId((int) row.get("id"));
                ticket.impact = IMPACT.valueOf((String) row.get("impact"));
                ticket.titre = (String) row.get("titre");
                ticket.description = (String) row.get("description");
                ticket.date_de_creation = (String) row.get("date_de_creation");
                ticket.date_mise_a_jour = (String) row.get("date_mise_a_jour");
                ticket.etat = ETAT_TICKET.valueOf((String) row.get("etat"));
                ticket.utilisateur_createur = (int) row.get("utilisateur_createur");
                ticket.poste_informatique = (int) row.get("poste_informatique");
                ticket.type_de_demande = (String) row.get("type_de_demande");
                tickets.add(ticket);
            }

            return tickets;

        }
        catch (Exception e)
        {
            if (this.tickets == null) {
                int result = readData();
                if (result == -1)
                    throw new RuntimeException();
            }
            return tickets;
        }
    }

    @Produces(MediaType.APPLICATION_JSON) // Les méthodes retourneront du JSON
    @Override
    public TicketModel getTicketById(int Id) {
        try
        {
            Map<String, Object> row = mySQLCRUD.getById("TicketModel", "id", Id);
            if (row.isEmpty()) {
                throw new NotFoundException("Ticket non trouvé pour l'ID " + Id);
            }

            TicketModel ticket = new TicketModel();
            ticket.setId((int) row.get("id"));
            ticket.impact = IMPACT.valueOf((String) row.get("impact"));
            ticket.titre = (String) row.get("titre");
            ticket.description = (String) row.get("description");
            ticket.date_de_creation = (String) row.get("date_de_creation");
            ticket.date_mise_a_jour = (String) row.get("date_mise_a_jour");
            ticket.etat = ETAT_TICKET.valueOf((String) row.get("etat"));
            ticket.utilisateur_createur = (int) row.get("utilisateur_createur");
            ticket.poste_informatique = (int) row.get("poste_informatique");
            ticket.type_de_demande = (String) row.get("type_de_demande");

            return ticket;

        }
        catch (Exception e)
        {
            if (this.tickets == null) {
                int result = readData();
                if (result == -1)
                    throw new RuntimeException();
            }

            TicketModel ticket = this.tickets.stream()
                    .filter(t -> t.getId() == Id)
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException("Ticket non trouvé pour l'ID " + Id));

            return ticket;
        }
    }

    @Consumes(MediaType.APPLICATION_JSON) // Les méthodes accepteront du JSON
    @Override
    public int addTicket(TicketModel Ticket) {
        try
        {
            Map<String, Object> data = new HashMap<>();
            data.put("impact", Ticket.impact.name());
            data.put("titre", Ticket.titre);
            data.put("description", Ticket.description);
            data.put("date_de_creation", Ticket.date_de_creation);
            data.put("date_mise_a_jour", Ticket.date_mise_a_jour);
            data.put("etat", Ticket.etat.name());
            data.put("utilisateur_createur", Ticket.utilisateur_createur);
            data.put("poste_informatique", Ticket.poste_informatique);
            data.put("type_de_demande", Ticket.type_de_demande);

            return mySQLCRUD.insert("TicketModel", data) ? 1 : -1;

        }
        catch (Exception e)
        {
            if (this.tickets == null) {
                int result = readData();
                if (result == -1)
                    return -1;
            }

            Ticket.setId(this.tickets.getLast().getId() + 1); // la definition de l'id a ete grandement simplifié par rapport a un cas reel
            this.tickets.add(Ticket);

            return 1;
        }
    }

    @Consumes(MediaType.APPLICATION_JSON) // Les méthodes accepteront du JSON
    @Override
    public int updateTicket(int Id, TicketModel Ticket) {
        try
        {
            Map<String, Object> data = new HashMap<>();
            data.put("impact", Ticket.impact.name());
            data.put("titre", Ticket.titre);
            data.put("description", Ticket.description);
            data.put("date_de_creation", Ticket.date_de_creation);
            data.put("date_mise_a_jour", Ticket.date_mise_a_jour);
            data.put("etat", Ticket.etat.name());
            data.put("utilisateur_createur", Ticket.utilisateur_createur);
            data.put("poste_informatique", Ticket.poste_informatique);
            data.put("type_de_demande", Ticket.type_de_demande);

            return mySQLCRUD.update("TicketModel", "id", Id, data) ? 1 : -1;

        }
        catch (Exception e)
        {
            if (this.tickets == null) {
                int result = readData();
                if (result == -1)
                    return -1;
            }

            TicketModel existingTicket = this.tickets.stream()
                    .filter(ticket -> ticket.getId() == Id)
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException("Ticket non trouvé pour l'ID " + Id));

            if (Ticket.getId() != 0 && Ticket.getId() != existingTicket.getId()) {
                existingTicket.setId(Ticket.getId());
            }
            if (Ticket.impact != null) {
                existingTicket.impact = Ticket.impact;
            }
            if (Ticket.titre != null) {
                existingTicket.titre = Ticket.titre;
            }
            if (Ticket.description != null) {
                existingTicket.description = Ticket.description;
            }
            if (Ticket.date_de_creation != null) {
                existingTicket.date_de_creation = Ticket.date_de_creation;
            }
            if (Ticket.date_mise_a_jour != null) {
                existingTicket.date_mise_a_jour = Ticket.date_mise_a_jour;
            }
            if (Ticket.etat != null) {
                existingTicket.etat = Ticket.etat;
            }
            if (Ticket.utilisateur_createur != 0 && Ticket.utilisateur_createur != existingTicket.utilisateur_createur) {
                existingTicket.utilisateur_createur = Ticket.utilisateur_createur;
            }
            if (Ticket.poste_informatique != 0 && Ticket.poste_informatique != existingTicket.poste_informatique) {
                existingTicket.poste_informatique = Ticket.poste_informatique;
            }
            if (Ticket.type_de_demande != null) {
                existingTicket.type_de_demande = Ticket.type_de_demande;
            }

            return 1;
        }
    }

    @Override
    public int removeTicket(int id) {
        try
        {
            return mySQLCRUD.delete("TicketModel", "id", id) ? 1 : -1;
        }
        catch (Exception e)
        {
            if (this.tickets == null) {
                int result = readData();
                if (result == -1)
                    return -1;
            }

            boolean removed = this.tickets.removeIf(ticket -> ticket.getId() == id);
            if (!removed) {
                return -2;
            }

            return 1;
        }
    }
}
