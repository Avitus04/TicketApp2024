package fr.isen.ticketApp.interfaces.services;

import java.util.List;
import fr.isen.ticketApp.interfaces.models.TicketModel;

//begin of modifiable zone(Javadoc).......C/4d875528-71b8-4a7b-bf46-4c3d76d94ee9

//end of modifiable zone(Javadoc).........E/4d875528-71b8-4a7b-bf46-4c3d76d94ee9
public interface TicketService {
//begin of modifiable zone(Javadoc).......C/953dc630-a7af-4c20-8e92-9d472acc99d6

//end of modifiable zone(Javadoc).........E/953dc630-a7af-4c20-8e92-9d472acc99d6
    TicketModel getTicketById(final int Id);

//begin of modifiable zone(Javadoc).......C/299d8e8c-ca29-4ebd-bd3f-ff6594373838

//end of modifiable zone(Javadoc).........E/299d8e8c-ca29-4ebd-bd3f-ff6594373838
    List<TicketModel> getAllTickets();

//begin of modifiable zone(Javadoc).......C/b2478398-be83-41d6-bbbe-cebf72632314

//end of modifiable zone(Javadoc).........E/b2478398-be83-41d6-bbbe-cebf72632314
    int addTicket(final TicketModel Ticket);

//begin of modifiable zone(Javadoc).......C/3f85cbc1-6fca-48b7-bc4f-551380dab94a

//end of modifiable zone(Javadoc).........E/3f85cbc1-6fca-48b7-bc4f-551380dab94a
    int removeTicket(final int Id);

//begin of modifiable zone(Javadoc).......C/3370baa5-afa9-4ca5-91e1-97f4b80d7225

//end of modifiable zone(Javadoc).........E/3370baa5-afa9-4ca5-91e1-97f4b80d7225
    int updateTicket(final int Id, final TicketModel Ticket);

}
