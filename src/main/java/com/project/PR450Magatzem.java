package com.project;

import java.util.ArrayList;

public class PR450Magatzem {
    private ArrayList<PR450Producte> productes = new ArrayList<PR450Producte>();
    public PR450Entregues entregues = PR450Entregues.getInstance();
    private int capacitat = 10;

    
    public int getCapacitat() {
        return capacitat;
    }
    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public ArrayList<PR450Producte> getProductes() {
        return productes;
    }
    public void addProducte(PR450Producte productes) {
        this.productes.add(productes);
        this.capacitat -= 1;
        notifyUpdate(productes.getId(), "a");
    }
    
    public void removeProducte(int id){
        PR450Producte pE;
        for (PR450Producte p : productes){
            if (p.getId() == id) {
                pE = p;
                entregues.addProducte(pE);
                this.productes.remove(pE);
                break;
            }
        }
        this.capacitat += 1;
        notifyUpdate(id,"r");
    }

    @Override
    public String toString() {
        String s = "Productes magatzem: [";
        for (PR450Producte p : productes) {
            s = s+Integer.toString(p.getId())+": "+p.getNom()+", ";
        }
        s = s+"]";
        return s;
    }

    public void notifyUpdate(int id, String mode) {
        if (mode.equals("a")) {
            System.out.println(String.format("S'ha afegit el producte amb el id '%s' al magatzem, capacitat '%s'", id, this.capacitat));
        } else if (mode.equals("r")) {
            System.out.println(String.format("S'ha esborrat el producte amb id '%s' del magatzem, capacitat '%s'", id, capacitat));
            System.out.println(String.format("S'ha mogut el producte amb id '%s' a la llista d'entreges", id));
        }
    }


}
