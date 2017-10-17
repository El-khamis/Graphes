package com.company;


import java.util.ArrayList;
import static java.lang.System.*;

public class Noeud {
    private int couleur=0;
    private int numero=0;
    private ArrayList<Noeud> listeVoisins = new ArrayList<Noeud>();

    public ArrayList<Noeud> GetListeVoisins() {
        return this.listeVoisins;
    }
    public int getNumero() {
        return numero;
    }

    public Noeud(int num, int coul){
       numero=num;
       couleur=coul;
        }


    public int NombreDeVoisins(){
        return this.listeVoisins.size();
    }


    public Noeud AjouterVoisins(Noeud n){
        this.listeVoisins.add(n);
        n.listeVoisins.add(this);
        return this;
    }

    public void AfficherMesVoisins(){
        for(int i=0;i<this.listeVoisins.size();i++){
            out.print(this.listeVoisins.get(i).getNumero()+" ");
        }
    }

    public Noeud SupprimerVoisins(Noeud n){ //A.supprimervoisins(B) Supprime A de la liste desvoisins de B et inversement
        this.listeVoisins.remove(n);
        n.listeVoisins.remove(this);
        return this;
    }
    public Noeud SupprimerVoisins2(Noeud n){ //A.Supprimervoisins2(B) Supprime A de la liste  des Voisins de B
        n.listeVoisins.remove(this);
        return this;
    }

    public Noeud SupprimerTousLesVoisins(){
        out.print("J'affiche la liste des voisins du sommet que je vais suppr :\n");
        out.print("\n\n"+this.listeVoisins.size()+"\n\n");
        this.AfficherMesVoisins();
        out.print("\n\n"+this.listeVoisins.size()+"\n\n");
        out.print("J'affiches tous ceux que je vais suppr : \n");
        int size=this.listeVoisins.size();

        for(int i=0;i<this.listeVoisins.size();i++){ //La taille change à chaque itération donc je la stock avant
            out.print("à lindice  " + i + " Il y a le voisin " + this.listeVoisins.get(i).getNumero() + "\n");
            this.SupprimerVoisins2((this.GetListeVoisins().get(i)));
        }
        this.GetListeVoisins().clear();
        return this;
    }



}
