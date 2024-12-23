package fr.isen.ticketApp.interfaces.models;

import fr.isen.ticketApp.interfaces.models.enums.ETAT_POST;

//begin of modifiable zone(Javadoc).......C/7877924d-ad85-455a-82d9-7074c866a328

//end of modifiable zone(Javadoc).........E/7877924d-ad85-455a-82d9-7074c866a328
public class DevicesModel {
//begin of modifiable zone(Javadoc).......C/8a0d257e-ffef-48bf-9834-7e11208726ff

//end of modifiable zone(Javadoc).........E/8a0d257e-ffef-48bf-9834-7e11208726ff
    private int id;

    public int getId() {
        // Automatically generated method. Please do not modify this code.
        return this.id;
    }

    public void setId(final int value) {
        // Automatically generated method. Please do not modify this code.
        this.id = value;
    }

//begin of modifiable zone(Javadoc).......C/bfa0fe11-e565-4f8c-bed7-ce55220db8f3

//end of modifiable zone(Javadoc).........E/bfa0fe11-e565-4f8c-bed7-ce55220db8f3
    private int utilisateur_affecte;

    public int getUtilisateur_affecte() {
        // Automatically generated method. Please do not modify this code.
        return this.utilisateur_affecte;
    }

    public void setUtilisateur_affecte(final int value) {
        // Automatically generated method. Please do not modify this code.
        this.utilisateur_affecte = value;
    }

//begin of modifiable zone(Javadoc).......C/e9d6cee0-6604-4042-b042-f7acfd167062

//end of modifiable zone(Javadoc).........E/e9d6cee0-6604-4042-b042-f7acfd167062
    public String configuration;

//begin of modifiable zone(Javadoc).......C/b9852346-6b5f-43bb-818f-4aaa90b00fb4

//end of modifiable zone(Javadoc).........E/b9852346-6b5f-43bb-818f-4aaa90b00fb4
    public ETAT_POST etat;

}
