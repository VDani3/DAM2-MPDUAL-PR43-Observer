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

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    
}
