package fr.isen.ticketApp.impl.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.isen.ticketApp.Data;
import fr.isen.ticketApp.MySQLCRUD;
import fr.isen.ticketApp.interfaces.models.DevicesModel;
import fr.isen.ticketApp.interfaces.models.enums.ETAT_POST;
import fr.isen.ticketApp.interfaces.services.DeviceService;
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

public class DeviceServiceImpl implements DeviceService {

    private static final String JSON_FILE_PATH = "src/main/resources/devices.JSON";

    // pour utiliser la Base de Donnees
    private MySQLCRUD mySQLCRUD = new MySQLCRUD();

    private List<DevicesModel> devices = null;

    // methode pour lire les donnees des les fichiers JSON
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

        try {
            List<Map<String, Object>> data = mySQLCRUD.getAll("DevicesModel");
            List<DevicesModel> devices = new ArrayList<>();


            for (Map<String, Object> row : data) {
                DevicesModel device = new DevicesModel();
                device.setId((int) row.get("id"));
                device.setUtilisateur_affecte((int) row.get("utilisateur_affecte"));
                device.configuration = (String) row.get("configuration");
                device.etat = ETAT_POST.valueOf((String) row.get("etat"));
                devices.add(device);
            }

            return devices;
        }
        catch (Exception e)
        {
            if (this.devices == null)
            {
                int result = readData();
                if (result == -1)
                    throw new RuntimeException();
            }
            return devices;
        }

    }

    @Produces(MediaType.APPLICATION_JSON) // Les méthodes retourneront du JSON
    @Override
    public DevicesModel getDeviceByID(int Id) {
        try
        {
            Map<String, Object> row = mySQLCRUD.getById("DevicesModel", "id", Id);
            if (row.isEmpty()) {
                throw new NotFoundException("Device non trouvé pour l'ID " + Id);
            }

            DevicesModel device = new DevicesModel();
            device.setId((int) row.get("id"));
            device.setUtilisateur_affecte((int) row.get("utilisateur_affecte"));
            device.configuration = (String) row.get("configuration");
            device.etat = ETAT_POST.valueOf((String) row.get("etat"));

            return device;

        }
        catch (Exception e)
        {
            if (this.devices == null) {
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
    }

    @Consumes(MediaType.APPLICATION_JSON) // Les méthodes accepteront du JSON

    @Override
    public int addDevice(DevicesModel Device) {
        try
        {
            Map<String, Object> data = new HashMap<>();
            data.put("utilisateur_affecte", Device.getUtilisateur_affecte());
            data.put("configuration", Device.configuration);
            data.put("etat", Device.etat.name());

            return mySQLCRUD.insert("DevicesModel", data) ? 1 : -1;

        }
        catch (Exception e)
        {
            if (this.devices == null) {
                int result = readData();
                if (result == -1)
                    return -1;
            }

            Device.setId(this.devices.getLast().getId() + 1);
            this.devices.add(Device);

            return 1;
        }
    }

    @Consumes(MediaType.APPLICATION_JSON) // Les méthodes accepteront du JSON
    @Override
    public int updateDevice(int Id, DevicesModel Device) {
        try
        {
            Map<String, Object> data = new HashMap<>();
            data.put("utilisateur_affecte", Device.getUtilisateur_affecte());
            data.put("configuration", Device.configuration);
            data.put("etat", Device.etat.name());

            return mySQLCRUD.update("DevicesModel", "id", Id, data) ? 1 : -1;
        }
        catch (Exception e)
        {
            if (this.devices == null) {
                int result = readData();
                if (result == -1)
                    return -1;
            }

            DevicesModel existingDevice = this.devices.stream()
                    .filter(device -> device.getId() == Id)
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException("Appareil non trouvé pour l'ID " + Id));

            if (Device.getId() != 0 && Device.getId() != existingDevice.getId()) {
                existingDevice.setId(Device.getId());
            }
            if (Device.getUtilisateur_affecte() != 0 && Device.getUtilisateur_affecte() != existingDevice.getUtilisateur_affecte()) {
                existingDevice.setUtilisateur_affecte(Device.getUtilisateur_affecte());
            }
            if (Device.configuration != null) {
                existingDevice.configuration = Device.configuration;
            }
            if (Device.etat != null) {
                existingDevice.etat = Device.etat;
            }
            return 1;
        }
    }

    @Override
    public int removeDevice(int Id) {
        try
        {
            return mySQLCRUD.delete("DevicesModel", "id", Id) ? 1 : -1;
        }
        catch (Exception e)
        {
            if (this.devices == null) {
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
}
