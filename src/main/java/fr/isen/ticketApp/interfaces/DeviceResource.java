package fr.isen.ticketApp.interfaces;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.isen.ticketApp.Data;
import fr.isen.ticketApp.impl.services.DeviceServiceImpl;
import fr.isen.ticketApp.impl.services.TicketServiceImpl;
import fr.isen.ticketApp.interfaces.models.DevicesModel;
import fr.isen.ticketApp.interfaces.services.DeviceService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.io.File;
import java.util.List;

@Path("/") // Chemin de base de la ressource REST
@Produces(MediaType.APPLICATION_JSON) // Les méthodes retourneront du JSON
@Consumes(MediaType.APPLICATION_JSON) // Les méthodes accepteront du JSON
public class DeviceResource {

    public DeviceService deviceService;

    public DeviceResource()
    {
        this.deviceService = new DeviceServiceImpl();
    }


    // Méthode pour récupérer  la liste des postes informatiques
    @GET
    @Path("/devices")
    public List<DevicesModel> getDevices() throws Exception {
        return this.deviceService.getAllDevices();
    }


    // Méthode pour récupérer un ticket par son ID
    @GET
    @Path("/devices/{id}")
    public DevicesModel getOneDevice(@PathParam("id") int Id) throws Exception {
        return this.deviceService.getDeviceByID(Id);
    }


    // Ajouter un appareil
    @POST
    @Path("/devices")
    public String createDevice(DevicesModel device) throws Exception {
        int result = this.deviceService.addDevice(device);

        if (result == 1) {return "Le poste informatique a ete cree.";}
        else {return "Erreur lors de la creation du poste informatique.";}
    }

    // Mettre à jour un appareil
    @PUT
    @Path("/devices/{id}")
    public String updateDevice(@PathParam("id") int Id, DevicesModel updatedDevice) throws Exception {
        int result = this.deviceService.updateDevice(Id, updatedDevice);

        if (result == 1) {return "Changements bien effectués";}
        else {return "Erreur lors du changement d'informations";}
    }

    // Supprimer un appareil
    @DELETE
    @Path("/devices/{id}")
    public String deleteDevice(@PathParam("id") int Id) throws Exception {
        int result = this.deviceService.removeDevice(Id);

        if (result == 1) {return "Le poste informatique a ete supprime";}
        else if (result == -1) {return "Erreur lors de l'ouverture du fichier";}
        else {return "Poste informatique non trouvé pour l'ID :" + Id;}
    }

}
