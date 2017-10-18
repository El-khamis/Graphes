package com.company;


import java.util.ArrayList;
import static java.lang.System.*;

public class Noeud {
    private int couleur=0;
    private int identifiant=0;
    private String nom;
    private ArrayList<Noeud> listeVoisins = new ArrayList<Noeud>();


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Noeud> GetListeVoisins() {
        return this.listeVoisins;
    }
    public int getIdentifiant() {
        return identifiant;
    }

    public Noeud(int id, int coul, String nom){
       identifiant=id;
       couleur=coul;
       this.nom=nom;
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
            out.print(this.listeVoisins.get(i).getNom()+" ");
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
