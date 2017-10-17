package com.company;

import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.System.*;

public class Graphe {
    private ArrayList<Noeud> graphe;

    public Graphe() {
        this.graphe = new ArrayList<Noeud>();
    }

    public void AjouterNoeudDansUnGraphe(Noeud n) {
        this.graphe.add(n);
        this.graphe.addAll(n.GetListeVoisins());
    }

    public void AfficherGraphe(Graphe g) {
        int size = g.graphe.size();
        boolean[] Vu = new boolean[size];

        for (int i = 0; i < size; i++) {
            Vu[i] = false;
        }

        for (int i = 0; i < size; i++)
            if (!Vu[g.graphe.get(i).getNumero()]) {
                out.printf("Le Noeud numero " + g.graphe.get(i).getNumero() + " a pour voisins : ");
                g.graphe.get(i).AfficherMesVoisins();
                out.printf("\n");
                Vu[g.graphe.get(i).getNumero()] = true;
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

    public void RetirerNoeud(Noeud n) {
        int o=0;
        boolean present=false;
        int size=this.graphe.size();
        for(int i=0;i<size;i++){
            if(n.getNumero()==this.graphe.get(i).getNumero()) present = true;
        }
        if(present) n.SupprimerTousLesVoisins();
        else out.print("Le noeud n'est pas présent\n");
        n.GetListeVoisins().clear();
        while(this.graphe.indexOf(n)!=-1){
            this.graphe.remove(this.graphe.indexOf(n)); //Pourquoi le remove ne fonctionne pas du premier coup 
            o++;
        }
        out.print("J'ai du le faire "+o+" fois\n");
        //this.graphe.remove(n);
    }
}