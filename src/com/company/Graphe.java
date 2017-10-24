package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import static java.lang.System.*;


public class Graphe {
    private ArrayList<Noeud> graphe;

    /**
     * Constructeur par défaut
     */
    public Graphe() {
        this.graphe = new ArrayList<Noeud>();
    }

    public ArrayList<Noeud> getGraphe() {
        return graphe;
    }

    public void setGraphe(ArrayList<Noeud> graphe) {
        this.graphe = graphe;
    }

    /**
     * Constructeur paramétrer
     * @param g
     */
    public Graphe(Graphe g) {


        this.graphe = new ArrayList<Noeud>(g.graphe.size());
        int index;
        for (int i = 0; i < g.graphe.size(); i++) {
            this.graphe.add(new Noeud(g.graphe.get(i)));
            this.graphe.get(i).SetListeVoisin(new ArrayList<Noeud>());
        }
        for (int i = 0; i < g.graphe.size(); i++) {
            for (int j = 0; j < g.graphe.get(i).GetListeVoisins().size(); j++) {
                index = g.graphe.indexOf(g.graphe.get(i).GetListeVoisins().get(j));
                if(!this.graphe.get(i).GetListeVoisins().contains(this.graphe.get(index))) {
                    this.graphe.get(i).GetListeVoisins().add(new Noeud(this.graphe.get(index)));
                }

            }
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
                out.printf("Le Noeud " + this.graphe.get(i).getNom() + " de couleur "+this.graphe.get(i).getCouleur()+" a pour voisins : ");
                this.graphe.get(i).AfficherMesVoisins();
                out.print("\n");
                Vu.add(this.graphe.get(i));
            }
        }
    }

    /**
     *
     * @return Retourne le noeud de plus grand degrès de notre Graphe
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
        out.print("Les Noeuds ayant un degrès inferieur strictement à " + k + " sont : \n");
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
     * R
     * @param k le degrés
     * @return envoie le plus grand noeud ayant un degrès inférieur à k
     *         Si y'en a plusieurs de disponible il prend le dernier
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
        if (this.graphe.indexOf(n) != -1) {
            out.print("Je supprime le noeud " + n.getNom() + " du graphe\n");
            n.SupprimerTousLesVoisins();//Si mon sommet est bien présent dans mon graphe alors je supprime
            n.GetListeVoisins().clear();
            this.graphe.remove(this.graphe.indexOf(n));
        } else {
            out.print("Le noeud n'est pas présent\n");
        }
    }


    public int ApparaitDansUnVoisin(Noeud n){
       // Noeud l= new Noeud(5,5,"osef");
        for(int i=0;i<this.graphe.size();i++){
            if(n.IndexDuNoeudDeNom(n.getNom(),this.graphe.get(i).GetListeVoisins())!=-1){
                return n.IndexDuNoeudDeNom(n.getNom(),this.graphe.get(i).GetListeVoisins());
            }
        }
        return -1;
    }

    /**
     * Colorie le graphe en k couleur et renvoie un graphe colorié
     * Première étape ( marche pas ) je créer une copie de mon graphe et je travaille dessus; Le soucis c'est que j'ai l'impression de ne recopier que l'adresse
     *                                                                                        et pas les valeurs une à une
     * Ensuite je reconstruit mon graphe en lui attribuant des couleurs.
     * @param couleur
     */
    public void ColoriageDeGraphe(int couleur) {
        int ActionEffectuee = 0;
        int nmbrDeNoeudEnlever = 0;
        Noeud temp;
        ArrayList<Noeud> TabDeSpill = new ArrayList<Noeud>();
        Graphe OrdreDenlevement = new Graphe();
        Graphe CopyOfMyGraphe = new Graphe(this);
        CopyOfMyGraphe.AfficherGraphe();
        int size = CopyOfMyGraphe.graphe.size();
        while (size != ActionEffectuee) {
            int cpt=0;
            temp = CopyOfMyGraphe.PlusGrandNoeudDeDegreInf(couleur);
            if (temp == null) {
                while(temp==null){
                    temp=CopyOfMyGraphe.PlusGrandNoeudDeDegreInf(couleur+cpt);
                    cpt++;
                }
                out.print("Il faut spill je ne l'ai pas implémenter encore \n");
                ActionEffectuee++;
                nmbrDeNoeudEnlever++;
                OrdreDenlevement.AjouterNoeudDansUnGraphe(temp);
                CopyOfMyGraphe.RetirerNoeud(temp);
                TabDeSpill.add(temp);
            }

            else {
                ActionEffectuee++;
                nmbrDeNoeudEnlever++;
                OrdreDenlevement.AjouterNoeudDansUnGraphe(temp);
                CopyOfMyGraphe.RetirerNoeud(temp);
            }
        }
        int index;
        Noeud k = new Noeud(6, 5, "osef");

        for (int i = 0; i < OrdreDenlevement.graphe.size(); i++) {
            for (int j = OrdreDenlevement.graphe.size() - 1; j > -1; j--) {
                CopyOfMyGraphe.graphe.add(OrdreDenlevement.graphe.get(j));
                index = k.IndexDuNoeudDeNom(CopyOfMyGraphe.graphe.get(i).getNom(), this.graphe);
                CopyOfMyGraphe.graphe.get(i).SetListeVoisin(this.graphe.get(index).GetListeVoisins());

                for (int l = 0; l < CopyOfMyGraphe.graphe.get(i).GetListeVoisins().size(); l++) {
                    if (k.IndexDuNoeudDeNom(CopyOfMyGraphe.graphe.get(i).GetListeVoisins().get(l).getNom(), TabDeSpill) != -1) {
                        CopyOfMyGraphe.graphe.get(i).setCouleur(-1);

                    }
                    else {
                        if (-1 != k.IndexDuNoeudDeNom(CopyOfMyGraphe.graphe.get(i).GetListeVoisins().get(l).getNom(), CopyOfMyGraphe.graphe)) {//Si mon voisin se trouve dans mon graphe
                            index = k.IndexDuNoeudDeNom(CopyOfMyGraphe.graphe.get(i).GetListeVoisins().get(l).getNom(), CopyOfMyGraphe.graphe);
                            if (CopyOfMyGraphe.graphe.get(index).getCouleur() == CopyOfMyGraphe.graphe.get(i).getCouleur()) {//Ils ont pas la meme couleur
                                CopyOfMyGraphe.graphe.get(index).setCouleur(CopyOfMyGraphe.graphe.get(i).getCouleur() + 1);
                            }
                        } else {
                            CopyOfMyGraphe.graphe.get(i).setCouleur(1);
                        }
                    }
                }
            }
        }
//J'arrive pas a mettre une nouvelle couleur à spill si possible
        ArrayList<Integer> Couleur= new ArrayList<>();

      /*  for(int i=0;i<CopyOfMyGraphe.graphe.size();i++){
            if(CopyOfMyGraphe.graphe.get(i).getCouleur()==-1){//si je suis un spill
                for(int n=0;n<couleur;n++){
                    Couleur.add(n);
                }
                for(int j=0;j<CopyOfMyGraphe.graphe.get(i).GetListeVoisins().size();j++){
                    if(CopyOfMyGraphe.graphe.get(i).GetListeVoisins().get(j).getCouleur()!=-1) {//Si mon voisin n'est pas un spill
                        int eee = Couleur.indexOf(CopyOfMyGraphe.graphe.get(i).GetListeVoisins().get(j).getCouleur());
                        if(eee!=-1) {// Et que sa couleur n'a pas déjà été supprimer alors je supprime sa couleur de mon tableau de couleur
                            Couleur.remove(eee);
                        }
                    }
                    if(Couleur.size()!=0) {
                        out.println(CopyOfMyGraphe.graphe.get(i).getNom());
                        System.out.println(Couleur);
                        CopyOfMyGraphe.graphe.get(i).setCouleur(Couleur.get(0));
                        Couleur.clear();
                    }
                    else{
                        CopyOfMyGraphe.graphe.get(i).setCouleur(-1);
                        Couleur.clear();
                    }

                }
            }
        }*/


        out.print("J'ai enlever "+nmbrDeNoeudEnlever+ " noeuds\n");
        out.print("Le graphe this\n");
        this.AfficherGraphe();
        out.print("\n");
        out.print("Le graphe CopyOfMyGraphe\n");
        CopyOfMyGraphe.AfficherGraphe();
        out.print("\n");
        out.print("Le graphe OrdreDenlevement\n");
        OrdreDenlevement.AfficherGraphe();
    }

}