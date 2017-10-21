package com.company;


import java.util.ArrayList;
import static java.lang.System.*;


public class Noeud {
    private int couleur=0;
    private int identifiant=0;
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
    }


    /**
     * Renvoie le degrès du noeud
     * @return
     */
    public int NombreDeVoisins(Noeud n){
        return n.listeVoisins.size();
    }

    /**
     * Rajoute un voisin dans le noeud this et inversement
     * @param n
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
     * @return
     */
    public Noeud SupprimerVoisins(Noeud n){
        this.listeVoisins.remove(n);
        n.listeVoisins.remove(this);
        return this;
    }

    /**
     * Pareil que SupprimerViosins mais je le fais sur toute la liste de voisins
     * la boucle for visite tous mes voisins et me supprime chez eux
     * ensuite je supprime ma liste de voisins
     * @return
     */

    public Noeud SupprimerTousLesVoisins(){
        for(int i=0;i<this.listeVoisins.size();i++){
            this.GetListeVoisins().get(i).listeVoisins.remove(this);
        }
        this.GetListeVoisins().clear();
        return this;
    }


}
