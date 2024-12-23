package fr.isen.ticketApp.interfaces.services;

import java.util.List;
import fr.isen.ticketApp.interfaces.models.DevicesModel;

//begin of modifiable zone(Javadoc).......C/ff28ee26-ce9d-4d6d-8cb7-e5958ed4d6de

//end of modifiable zone(Javadoc).........E/ff28ee26-ce9d-4d6d-8cb7-e5958ed4d6de
public interface DeviceService {
//begin of modifiable zone(Javadoc).......C/8c8779d3-4249-482f-b074-9ef9c22f9f9c

//end of modifiable zone(Javadoc).........E/8c8779d3-4249-482f-b074-9ef9c22f9f9c
    int addDevice(final DevicesModel Device);

//begin of modifiable zone(Javadoc).......C/9cb535cf-ede2-43eb-bfba-0ff081c994a9

//end of modifiable zone(Javadoc).........E/9cb535cf-ede2-43eb-bfba-0ff081c994a9
    int removeDevice(final int Id);

//begin of modifiable zone(Javadoc).......C/5cb6a38c-f75f-4070-8d35-69b456919cb9

//end of modifiable zone(Javadoc).........E/5cb6a38c-f75f-4070-8d35-69b456919cb9
    int updateDevice(final int Id, final DevicesModel Device);

//begin of modifiable zone(Javadoc).......C/952a9bcf-c9f0-410c-ae56-b3682c45f2bb

//end of modifiable zone(Javadoc).........E/952a9bcf-c9f0-410c-ae56-b3682c45f2bb
    DevicesModel getDeviceByID(final int Id);

//begin of modifiable zone(Javadoc).......C/b7acb0f7-dbd2-4017-9a6b-059fc35937ef

//end of modifiable zone(Javadoc).........E/b7acb0f7-dbd2-4017-9a6b-059fc35937ef
    List<DevicesModel> getAllDevices();

}
