package com.company;
import static java.lang.System.*;

public class Main {
//Est-ce qu'on peut avoir un noeud isolé ?
    public static void main(String[] args) {
        System.out.println("This is a test\n");
        Noeud a = new Noeud(1,-1,"a");
        Noeud b = new Noeud(2,-1,"b");
        Noeud c = new Noeud( 3, -1,"c");
        Noeud d= new Noeud(4,-1,"d");
        Noeud z= new Noeud(5,-1,"z");



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
        g.AfficherGraphe();
        out.print("\n\n");
        g.NoeudDePLusGrandDegres();
        out.print("\n\n");
        g.AfficheNoeudDegreInf(3);
        out.print("\n\n");
        g.RetirerNoeud(a);
        g.RetirerNoeud(a);
        g.RetirerNoeud(z);
        g.RetirerNoeud(b);

        out.print("J'affiche mon Graphe\n");

        g.AfficherGraphe();

        out.print("\n\n");
        g.NoeudDePLusGrandDegres();
        out.print("\n\n");
        g.AfficheNoeudDegreInf(3);
        //  g.AfficheNoeudDegreInf(5);
    }
}
