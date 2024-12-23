package fr.isen.ticketApp.interfaces.models;

import fr.isen.ticketApp.interfaces.models.enums.ROLE;

//begin of modifiable zone(Javadoc).......C/6c0bdd99-b7a6-4b84-9429-ecd059ec6788

//end of modifiable zone(Javadoc).........E/6c0bdd99-b7a6-4b84-9429-ecd059ec6788
public class UserModel {
//begin of modifiable zone(Javadoc).......C/85915025-bcfd-41e1-9cb7-b452f41363d8

//end of modifiable zone(Javadoc).........E/85915025-bcfd-41e1-9cb7-b452f41363d8
    private int id;

    public int getId() {
        // Automatically generated method. Please do not modify this code.
        return this.id;
    }

    public void setId(final int value) {
        // Automatically generated method. Please do not modify this code.
        this.id = value;
    }

//begin of modifiable zone(Javadoc).......C/e39fe038-8130-42d4-a2f9-48a31a7391c3

//end of modifiable zone(Javadoc).........E/e39fe038-8130-42d4-a2f9-48a31a7391c3
    public String nom;

//begin of modifiable zone(Javadoc).......C/8e8f8ed9-e717-42ba-909e-ec1b5dc4ba5e

//end of modifiable zone(Javadoc).........E/8e8f8ed9-e717-42ba-909e-ec1b5dc4ba5e
    public String email;

//begin of modifiable zone(Javadoc).......C/e6f9d172-c99c-4ba2-a86c-810c545d5de9

//end of modifiable zone(Javadoc).........E/e6f9d172-c99c-4ba2-a86c-810c545d5de9
    public String mot_de_passe;

//begin of modifiable zone(Javadoc).......C/e7d2e1bc-1112-4213-b4ba-e133b48040b1

//end of modifiable zone(Javadoc).........E/e7d2e1bc-1112-4213-b4ba-e133b48040b1
    public String date_derniere_connexion;

//begin of modifiable zone(Javadoc).......C/1953c419-b7c6-4dd9-86b4-ee9b3f7bb8ff

//end of modifiable zone(Javadoc).........E/1953c419-b7c6-4dd9-86b4-ee9b3f7bb8ff
    public boolean statut;

//begin of modifiable zone(Javadoc).......C/edaeeb00-6d8f-4daa-b6e1-5da127d61d85

//end of modifiable zone(Javadoc).........E/edaeeb00-6d8f-4daa-b6e1-5da127d61d85
    public ROLE role;

}
