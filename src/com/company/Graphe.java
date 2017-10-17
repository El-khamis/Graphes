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
        out.print("Le graphe est maintenant de taille "+this.graphe.size()+" \n");

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

    public Noeud NoeudDePLusGrandDegres(){
        int max=0;
        int indice=0;
        for(int i=0; i<this.graphe.size();i++){
            if(this.graphe.get(i).GetListeVoisins().size()>max){
                max=this.graphe.get(i).GetListeVoisins().size();
                indice=i;
            }
        }
        out.print("Le sommet ayant le plus grand degres est le sommet "+ this.graphe.get(indice).getNumero()+" Il est de degres "+max+"\n");
        return this.graphe.get(indice);
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

    public void RetirerNoeud(Noeud n) {
        int o=0;
        boolean present=false;
        if(this.graphe.indexOf(n)!=-1){
            n.SupprimerTousLesVoisins();//Si mon sommet est bien présent dans mon graphe alors je supprime
            n.GetListeVoisins().clear();
        }
        else out.print("Le noeud n'est pas présent\n");

        while(this.graphe.indexOf(n)!=-1){
            out.print("hehehe je suis a l'indice "+this.graphe.indexOf(n)+"\n");
            this.graphe.remove(this.graphe.indexOf(n)); //Pourquoi le remove ne fonctionne pas du premier coup
            o++;
        }
        out.print("J'ai du le faire "+o+" fois\n\n");
        out.print("Le graphe est maintenant de taille "+this.graphe.size()+" \n");
    }
}