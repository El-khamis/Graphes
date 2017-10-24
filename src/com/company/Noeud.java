package com.company;


import java.lang.reflect.Array;
import java.util.ArrayList;
import static java.lang.System.*;


public class Noeud {
    public int getCouleur() {
        return couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }

    private int couleur=0;
    private int identifiant=0;

    public void setNom(String nom) {
        this.nom = nom;
    }

    private String nom;
    private ArrayList<Noeud> listeVoisins = new ArrayList<Noeud>();

    /**
     * Constructeurs et Accesseurs
     */
    public void SetListeVoisin(ArrayList<Noeud> liste){
    this.listeVoisins=liste;
    }
    public String getNom() {
        return nom;
    }
    public ArrayList<Noeud> GetListeVoisins() {
        return this.listeVoisins;
    }
    public Noeud(int id, int coul, String nom){
       identifiant=id;
       couleur=coul;
       this.nom=nom;
        }
    public Noeud(Noeud n){
        identifiant=n.identifiant;
        couleur=n.couleur;
        nom=n.nom;
        listeVoisins=n.GetListeVoisins();
    }


    /**
     *
     * @return Renvoie le degrés du noeud
     */
    public int NombreDeVoisins(Noeud n){
        return n.listeVoisins.size();
    }

    /**
     * Rajoute un voisin dans le noeud this et inversement
     * @param n Le noeud a ajouter
     */
    public void AjouterVoisins(Noeud n){
        if(!this.listeVoisins.contains(n)) {
            this.listeVoisins.add(n);
            n.listeVoisins.add(this);
        }

    }

    /**
     * Affiche tous mes voisins
     */
    public void AfficherMesVoisins(){
        if(this.listeVoisins.size()==0){
            out.print("Je n'ai aucun voisin");
        }
        for(int i=0;i<this.listeVoisins.size();i++){
            out.print(this.listeVoisins.get(i).getNom()+" ");
        }
    }

    /**
     * A.supprimervoisins(B) Supprime A de la liste desvoisins de B et inversement
     * @param n
     * @return Le noeud privé de son voisins
     */
    public Noeud SupprimerVoisins(Noeud n){
        this.listeVoisins.remove(n);
        n.listeVoisins.remove(this);
        return this;
    }

    /**
     * Il s'agit la d'une fonction intermediaire qui nous renvoie l'indice de l'element que l'on souhaite supprimer
     * @param nom Nom du noeud que l'on souhaite supprimer
     * @param Tab Liste de voisin ou ce trouve le noeud
     * @return Index où ce trouve ce noeud
     */
    public int IndexDuNoeudDeNom(String nom, ArrayList<Noeud> Tab){
        for(int i=0;i<Tab.size();i++){
            if(Tab.get(i).getNom().equals(nom) ){
                return i;
            }
        }
        return -1;

    }


    /**
     * Pareil que SupprimerViosins mais je le fais sur toute la liste de voisins
     * la boucle for visite tous mes voisins et me supprime chez eux
     * ensuite je supprime ma liste de voisins
     * @return Le noeud privé de ses voisins
     */

    public Noeud SupprimerTousLesVoisins(){
        int index;
        for(int i=0;i<this.listeVoisins.size();i++){
            index=IndexDuNoeudDeNom(this.getNom(),this.listeVoisins.get(i).listeVoisins);
            this.listeVoisins.get(i).GetListeVoisins().remove(index);
            out.print("\n");
        }
        this.GetListeVoisins().clear();
        return this;
    }


}
