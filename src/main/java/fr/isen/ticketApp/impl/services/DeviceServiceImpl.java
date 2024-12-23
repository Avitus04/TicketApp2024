package fr.isen.ticketApp.impl.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.isen.ticketApp.Data;
import fr.isen.ticketApp.interfaces.models.DevicesModel;
import fr.isen.ticketApp.interfaces.services.DeviceService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DeviceServiceImpl implements DeviceService {

    private static final String JSON_FILE_PATH = "src/main/resources/devices.JSON";

    private List<DevicesModel> devices = null;

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

        this.devices = data.getDevices();

        return  1;
    }

    @Produces(MediaType.APPLICATION_JSON) // Les méthodes retourneront du JSON
    @Override
    public List<DevicesModel> getAllDevices() {
        if (this.devices == null)
        {
            int result = readData();
            if (result == -1)
                throw new RuntimeException();
        }
        return devices;
    }

    @Produces(MediaType.APPLICATION_JSON) // Les méthodes retourneront du JSON
    @Override
    public DevicesModel getDeviceByID(int Id) {
        if (this.devices == null)
        {
            int result = readData();
            if (result == -1)
                throw new RuntimeException();
        }

        DevicesModel dm = this.devices.stream()
                .filter(ticket -> ticket.getId() == Id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Ticket non trouvé pour l'ID " + Id));

        return dm;
    }

    @Consumes(MediaType.APPLICATION_JSON) // Les méthodes accepteront du JSON

    @Override
    public int addDevice(DevicesModel Device) {
        if (this.devices == null)
        {
            int result = readData();
            if (result == -1)
                return -1;
        }

        Device.setId(this.devices.getLast().getId() + 1);
        this.devices.add(Device);

        return 1;
    }

    @Consumes(MediaType.APPLICATION_JSON) // Les méthodes accepteront du JSON
    @Override
    public int updateDevice(int Id, DevicesModel Device) {
        if (this.devices == null)
        {
            int result = readData();
            if (result == -1)
                return -1;
        }

        DevicesModel existingDevice = this.devices.stream()
                .filter(device -> device.getId() == Id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Appareil non trouvé pour l'ID " + Id));

        if (Device.getId() != 0 && Device.getId() != existingDevice.getId()) {existingDevice.setId(Device.getId());}
        if (Device.getUtilisateur_affecte() != 0 && Device.getUtilisateur_affecte() != existingDevice.getUtilisateur_affecte()) {existingDevice.setUtilisateur_affecte(Device.getUtilisateur_affecte());}
        if (Device.configuration != null) {existingDevice.configuration = Device.configuration;}
        if (Device.etat != null) {existingDevice.etat = Device.etat;}
        return 1;
    }

    @Override
    public int removeDevice(int Id) {
        if (this.devices == null)
        {
            int result = readData();
            if (result == -1)
                return -1;
        }

        boolean removed = this.devices.removeIf(device -> device.getId() == Id);
        if (!removed) {
            return -2;
        }

        return 1;
    }
}
