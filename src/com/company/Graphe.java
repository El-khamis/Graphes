package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import com.company.Noeud;

import static java.lang.System.*;


public class Graphe {
    private ArrayList<Noeud> graphe;

    /**
     * Constructeur par défaut
     */
    public Graphe() {
        this.graphe = new ArrayList<Noeud>();
    }

    /**
     * Constructeur paramétrer
     * @param g
     */
    public Graphe(Graphe g) {
        this.graphe= new ArrayList<Noeud>();
        for(int i=0;i<g.graphe.size();i++) {
            this.graphe.add(g.graphe.get(i));
        }
    }

    /**
     * Ajouter un noeud dans un graphe, Verifie si ce noeud n'est pas déjà dans le graphe et ajoute tous ses voisins
     * qui ne sont pas dans le graphe
     * @param n
     */
    public void AjouterNoeudDansUnGraphe(Noeud n) { //Verifier que le noeud n'est pas dans le graphe avant de l'ajouter
        if(!this.graphe.contains(n)) {
            this.graphe.add(n);
            for (Noeud a:n.GetListeVoisins()) {
               this.AjouterNoeudDansUnGraphe(a);
            }
        }
    }

    /**
     * Affiche le graphe ainsi que tous ses voisins
     */
    public void AfficherGraphe() {

        int size= this.graphe.size();
        if (size==0){
            out.print("Le graphe est vide\n");
        }
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

    /**
     * Retourne le noeud de plus grand degrès de notre Graphe
     * @return
     */
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

    /**
     * Affiche à l'écran tous les noeuds de degrès strictement inférieur à k
     * @param k
     */
    public void AfficheNoeudDegreInf(int k) {
        Noeud n;
        out.print("Les Noeud ayant un degres inferieur strictement a " + k + " sont : \n");
        int cpt = 0;
        for (int i = 0; i < this.graphe.size(); i++) {
            if (k > this.graphe.get(i).NombreDeVoisins(this.graphe.get(i))) { //Je suis obligé de lui dire que c un noeud sinon ça marche pas pk ?
                out.printf("Le Noeud " + this.graphe.get(i).getNom() + " est de degres : " + this.graphe.get(i).NombreDeVoisins(this.graphe.get(i)) + " \n");
                cpt++;
            }
        }
        if (cpt == 0) {
            out.print("Aucun Noeud disponible \n");
        }


    }

    /**
     * Renvoie le plus grand noeud ayant un degrès inférieur à k
     * Si y'en a plusieurs de disponible il prend le dernier
     * @param k
     * @return
     */
    public Noeud PlusGrandNoeudDeDegreInf(int k){
        int cpt = 0;
        int indice=-1;
        int max=0;
        for (int i = 0; i < this.graphe.size(); i++) {
            if (this.graphe.get(i).NombreDeVoisins(this.graphe.get(i))< k && this.graphe.get(i).NombreDeVoisins(this.graphe.get(i))>=max) {
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

    /**
     * Retire le noeud n du graphe
     * Pour chaque voisin de n on retire n de sa liste de voisin
     * on vide la liste de voisin
     * @param n
     */
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

    /**
     * Colorie le graphe en k couleur et renvoie un graphe colorié
     * Première étape ( marche pas ) je créer une copie de mon graphe et je travaille dessus; Le soucis c'est que j'ai l'impression de ne recopier que l'adresse
     *                                                                                        et pas les valeurs une à une
     * Ensuite je reconstruit mon graphe en lui attribuant des couleurs.
     * @param couleur
     */
    public void ColoriageDeGraphe(int couleur) {
        int ActionEffectuee=0;
        int nmbrDeNoeudEnlever=0;
        Noeud temp;
        Graphe OrdreDenlevement = new Graphe();
        Graphe CopyOfMyGraphe = new Graphe(this);
        //Je cherche a copier mon graphe this

        for(int i=0;i<this.graphe.size();i++) {
            CopyOfMyGraphe.AjouterNoeudDansUnGraphe(this.graphe.get(i));
        }
        if(CopyOfMyGraphe.graphe==this.graphe) { //Pour être sur que j'ai bien copier mon graphe et que je n'ai pas juste copier l'adresse
            out.print("Il s'agit du même objet\n");
            return;
        }
        else{
            out.print("Les deux objets sont différents \n\n\n");
        }

        //Pourquoi quand je supprime v du graphe "this" le graphe "CopyOfGraphe" perd aussi v
        out.print("\n\n\nJe fais des test \n\n\n");
        this.RetirerNoeud(this.graphe.get(2));//Affecte les deux graphes mais ne devrait pas
        this.AfficherGraphe();

        out.print("\nAffichage de mon second graphe\n");
        CopyOfMyGraphe.AfficherGraphe();
        out.print("\n\n\nFin des test \n\n\n");


        int size =CopyOfMyGraphe.graphe.size();
        while(size!=ActionEffectuee) {
            temp = CopyOfMyGraphe.PlusGrandNoeudDeDegreInf(couleur);
            if (temp == null) {
                out.print("Il faut spill je ne l'ai pas implémenter encore \n");
                ActionEffectuee++;
            } else {
                nmbrDeNoeudEnlever++;
                ActionEffectuee++;
                OrdreDenlevement.AjouterNoeudDansUnGraphe(temp);
                CopyOfMyGraphe.RetirerNoeud(temp);
                out.print("J'ai choisi le noeud " + temp.getNom() + " \n");
            }
        }
        //je n'arrive pas à copier mon graphe this
        //A partir d'ici j'ai un l'ordre d'enlevement de mes noeud je dois maintenant remettre mes noeuds dans le graphe et leur attribué une couleur a chacun
        /*for(int i=OrdreDenlevement.graphe.size()-1;i>-1;i--){
            this.AjouterNoeudDansUnGraphe(OrdreDenlevement.graphe.get(i));
        }*/
        out.print("J'ai enlever "+nmbrDeNoeudEnlever+ " noeuds\n");
        this.AfficherGraphe();
        CopyOfMyGraphe.AfficherGraphe();
        OrdreDenlevement.AfficherGraphe();
    }

}