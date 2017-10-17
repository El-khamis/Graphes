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


    public Noeud SupprimerTousLesVoisins(){
        for(int i=0;i<this.listeVoisins.size();i++){
            //this.SupprimerVoisins2((this.GetListeVoisins().get(i)));
            this.GetListeVoisins().get(i).listeVoisins.remove(this);
        }
        this.GetListeVoisins().clear();
        return this;
    }

}
