package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.System.*;

public class Graphe {
    private ArrayList<Noeud> graphe;

    public Graphe() {
        this.graphe = new ArrayList<Noeud>();
    }

    public void AjouterNoeudDansUnGraphe(Noeud n) { //Verifier que le noeud n'est pas dans le graphe avant de l'ajouter
        if(!this.graphe.contains(n)) {
            this.graphe.add(n);
            for (Noeud a:n.GetListeVoisins()) {
               this. AjouterNoeudDansUnGraphe(a);
            }
        }
    }

    public void AfficherGraphe() {

        int size= this.graphe.size();
        ArrayList<Noeud> Vu = new ArrayList<Noeud>();
        for(int i=0;i<size;i++){
            if(!Vu.contains(this.graphe.get(i))){
                out.printf("Le Noeud " + this.graphe.get(i).getNom() + " a pour voisins : ");
                this.graphe.get(i).AfficherMesVoisins();
                out.print("\n");
                Vu.add(this.graphe.get(i));
            }
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
        out.print("Le sommet ayant le plus grand degres est le sommet "+ this.graphe.get(indice).getNom()+" Il est de degres "+max+"\n");
        return this.graphe.get(indice);
    }

    public void AfficheNoeudDegreInf(int k) {
        out.print("Les Noeud ayant un degres inferieur strictement a " + k + " sont : \n");
        int cpt = 0;
        for (int i = 0; i < this.graphe.size(); i++) {
            if (k > this.graphe.get(i).NombreDeVoisins()) {
                out.printf("Le Noeud " + this.graphe.get(i).getNom() + " est de degres : " + this.graphe.get(i).NombreDeVoisins() + " \n");
                cpt++;
            }
        }
        if (cpt == 0) {
            out.print("Aucun Noeud disponible \n");
        }


    }

    public Noeud PlusGrandNoeudDeDegreInf(int k){
        int cpt = 0;
        int indice=-1;
        int max=0;
        for (int i = 0; i < this.graphe.size(); i++) {
            if (this.graphe.get(i).NombreDeVoisins()< k && this.graphe.get(i).NombreDeVoisins()>=max) {
                max=this.graphe.get(i).GetListeVoisins().size();
                indice=i;
            }
        }
        if (indice == -1) {
            out.print("Aucun Noeud disponible \n");
            return null;
        }
        return this.graphe.get(indice);
    }

    public void RetirerNoeud(Noeud n) {
        if(this.graphe.indexOf(n)!=-1){
            out.print("Je supprime le noeud "+n.getNom()+" du graphe\n");
            n.SupprimerTousLesVoisins();//Si mon sommet est bien présent dans mon graphe alors je supprime
            n.GetListeVoisins().clear();
            this.graphe.remove(this.graphe.indexOf(n));
        }
        else out.print("Le "+n.getNom()+"noeud n'est pas présent\n");

        this.graphe.remove(n);
    }

    public void ColoriageDeGraphe(int couleur){
         ArrayList<Noeud> copyOfGraphe= new ArrayList<Noeud>();
        ArrayList<Noeud> OrdreDenlevement = new ArrayList<Noeud>();
        Noeud temp= new Noeud(0,0,"osef");
         arraycopy(this.graphe,0,copyOfGraphe,0,this.graphe.size());

         while(copyOfGraphe.size()!=1){

             temp=PlusGrandNoeudDeDegreInf(couleur);
             if(temp==null){
                 out.print("Il faut spill je ne l'ai pas implémenter encore \n");
                 return ;
             }
             else{
                 //Retirer le noeud de mon vrai graphe
             }




         }

    }
}