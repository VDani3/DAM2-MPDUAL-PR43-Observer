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
        notifyUpdate(producte.getId(), "a");
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
        notifyUpdate(id, "r");
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

    public void notifyUpdate(int id, String mode) {
        if (mode.equals("a")) {
            System.out.println(String.format("S'ha afegit el producte amb el id '%s' a la llista d'entrega", id));
        } else if (mode.equals("r")) {
            System.out.println(String.format("S'ha entregat el producte amb id '%s'", id));
        }
    }
}
