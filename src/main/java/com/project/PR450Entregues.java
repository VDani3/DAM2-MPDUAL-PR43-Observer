package com.project;

import java.util.ArrayList;

public class PR450Entregues {
    private static PR450Entregues instance = null;
    private ArrayList<PR450Producte> productes = new ArrayList<PR450Producte>();

    private PR450Entregues() {}

    public static PR450Entregues getInstance() {
        if (instance == null) {
            instance = new PR450Entregues();
        }
        return instance;
    }

    public ArrayList<PR450Producte> getProductes() {
        return productes;
    }

    public void addProducte(PR450Producte producte) {
        this.productes.add(producte);
    }

    public void removeProducte(int id){
        PR450Producte pE;
        for (PR450Producte p : productes){
            if (p.getId() == id) {
                pE = p;
                this.productes.remove(pE);
                break;
            }
        }
    }

    @Override
    public String toString() {
        String s = "Productes per entregar: [";
        for (PR450Producte p : productes) {
            s = s+Integer.toString(p.getId())+": "+p.getNom()+", ";
        }
        s = s+"]";
        return s;
    }
}
