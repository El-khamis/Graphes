package com.company;
import static java.lang.System.*;

public class Main {
//Est-ce qu'on peut avoir un noeud isolé ?
    public static void main(String[] args) {
        System.out.println("This is a test\n");
        Noeud a = new Noeud(1,0);
        Noeud b = new Noeud(2,1);
        Noeud c = new Noeud( 3, 2);
        Noeud d= new Noeud(4,3);
        Noeud z= new Noeud(5,4);
        Graphe g= new Graphe();
        a.AjouterVoisins(b);
        a.AjouterVoisins(c);
        a.AjouterVoisins(d);
        c.AjouterVoisins(b);
        c.AjouterVoisins(z);

        g.AjouterNoeudDansUnGraphe(a);
        g.AjouterNoeudDansUnGraphe(b);
        g.AjouterNoeudDansUnGraphe(c);
        g.AjouterNoeudDansUnGraphe(d);
        g.AjouterNoeudDansUnGraphe(z);

        out.print("J'affiche mon Graphe\n");
        g.AfficherGraphe(g);
        g.NoeudDePLusGrandDegres();

        g.RetirerNoeud(a);
        g.RetirerNoeud(a);
        g.RetirerNoeud(z);
        g.RetirerNoeud(b);

        out.print("Je supprime l'arrêt 1 5 et 2\n");
        out.print("J'affiche mon Graphe\n");

        g.AfficherGraphe(g);
        g.NoeudDePLusGrandDegres();
        //  g.AfficheNoeudDegreInf(5);
    }
}
