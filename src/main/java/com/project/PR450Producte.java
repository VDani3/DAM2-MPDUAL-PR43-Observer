package com.project;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PR450Producte {
    private int id;
    private String nom;

    PR450Producte(int i, String n) {
        this.id = i;
        this.nom = n;
    }

    public void setNom(String n) {
        String oldName = ""+this.nom;
        this.nom = n;
        notifyUpdateNom(oldName, n);
    }
    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }

    public void setId(int t){
        int oldId = this.id;
        this.id = t;
        notifyUpdateId(oldId, t);
    }

    //notifiers
     public void notifyUpdateId(int oldValue, int newValue) {
        System.out.println(String.format("Producte ha canviat de id '%s' a '%s'", oldValue, newValue));
    }

     public void notifyUpdateNom(String oldValue, String newValue) {
        System.out.println(String.format("Producte ha canviat el nom de '%s' a '%s'", oldValue, newValue));
    }
    
}
