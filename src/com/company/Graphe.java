package com.company;

import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.System.*;

public class Graphe {
    private ArrayList<Noeud> graphe;

    public Graphe() {
        this.graphe = new ArrayList<Noeud>();
    }

    public Graphe AjouterNoeudDansUnGraphe(Noeud n) {
        this.graphe.add(n);
        return this;
    }

    public void AfficherGraphe(Graphe g) {
        for (int i = 0; i < g.graphe.size(); i++) {
            out.printf("Le Noeud numero " + g.graphe.get(i).getNumero() + " a pour voisins : ");
            g.graphe.get(i).AfficherMesVoisins();
            out.printf("\n");
        }
    }


    public void AfficheNoeudDegreInf(int k) {
        out.print("Les Noeud ayant un degres inferieur strictement a " + k + " sont : \n");
        int cpt = 0;
        for (int i = 0; i < this.graphe.size(); i++) {
            if (k > this.graphe.get(i).NombreDeVoisins()) {
                out.printf("Le Noeud numero " + this.graphe.get(i).getNumero() + " qui a pour degres : " + this.graphe.get(i).NombreDeVoisins() + " \n");
                cpt++;
            }
        }
        if (cpt == 0) {
            out.print("Aucun Noeud disponible \n");
        }


    }

    //public Noeud NoeudPlusHautDegres(){};

    public Graphe RetirerNoeud(Noeud n) {
        boolean present=false;
        for(int i=0;i<this.graphe.size();i++){
            if(n.getNumero()==this.graphe.get(i).getNumero()){
                present =true;
            }
        }
        if(present) {
            n.SupprimerTousLesVoisins();
            this.graphe.remove(n);
        }
        else {
            out.print("Le noeud n'est pas présent\n");
        }
        return this;
    }
}