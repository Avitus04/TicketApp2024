package fr.isen.ticketApp.interfaces.models;

import fr.isen.ticketApp.interfaces.models.enums.ETAT_TICKET;
import fr.isen.ticketApp.interfaces.models.enums.IMPACT;

//begin of modifiable zone(Javadoc).......C/e3a5178c-6cd3-488e-a524-5397bc0450f4

//end of modifiable zone(Javadoc).........E/e3a5178c-6cd3-488e-a524-5397bc0450f4
public class TicketModel {
//begin of modifiable zone(Javadoc).......C/cf6ea308-4e1c-420a-a170-5f3ca46245d5

//end of modifiable zone(Javadoc).........E/cf6ea308-4e1c-420a-a170-5f3ca46245d5
    private int id;

    public int getId() {
        // Automatically generated method. Please do not modify this code.
        return this.id;
    }

    public void setId(final int value) {
        // Automatically generated method. Please do not modify this code.
        this.id = value;
    }

//begin of modifiable zone(Javadoc).......C/67fbe8a3-e14a-4276-aec5-3c383623c6ff

//end of modifiable zone(Javadoc).........E/67fbe8a3-e14a-4276-aec5-3c383623c6ff
    public IMPACT impact;

//begin of modifiable zone(Javadoc).......C/49ddff4a-b5df-44f4-9e0f-504ab3b67887

//end of modifiable zone(Javadoc).........E/49ddff4a-b5df-44f4-9e0f-504ab3b67887
    public String titre;

//begin of modifiable zone(Javadoc).......C/3fc9bba8-1b5b-4e75-8bbd-19dd192f6567

//end of modifiable zone(Javadoc).........E/3fc9bba8-1b5b-4e75-8bbd-19dd192f6567
    public String description;

//begin of modifiable zone(Javadoc).......C/7358059c-ba54-4488-8472-d805cf7b9e0c

//end of modifiable zone(Javadoc).........E/7358059c-ba54-4488-8472-d805cf7b9e0c
    public String date_de_creation;

//begin of modifiable zone(Javadoc).......C/301b5a9a-8eb8-4602-90fb-521515f580d8

//end of modifiable zone(Javadoc).........E/301b5a9a-8eb8-4602-90fb-521515f580d8
    public String date_mise_a_jour;

//begin of modifiable zone(Javadoc).......C/e24275f6-ea58-474f-9b59-b4bb2218025b

//end of modifiable zone(Javadoc).........E/e24275f6-ea58-474f-9b59-b4bb2218025b
    public ETAT_TICKET etat;

//begin of modifiable zone(Javadoc).......C/e18422a5-cd06-4b9a-9dfc-6d99a6de4215

//end of modifiable zone(Javadoc).........E/e18422a5-cd06-4b9a-9dfc-6d99a6de4215
    public int utilisateur_createur;

//begin of modifiable zone(Javadoc).......C/af0f07ec-2756-48e7-a4bb-4654da2a3315

//end of modifiable zone(Javadoc).........E/af0f07ec-2756-48e7-a4bb-4654da2a3315
    public int poste_informatique;

//begin of modifiable zone(Javadoc).......C/ced9eaef-cff6-4e5a-864a-e0188914f94c

//end of modifiable zone(Javadoc).........E/ced9eaef-cff6-4e5a-864a-e0188914f94c
    public String type_de_demande;

}
