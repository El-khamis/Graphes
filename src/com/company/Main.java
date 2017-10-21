package com.company;
import static java.lang.System.*;

public class Main {
//Est-ce qu'on peut avoir un noeud isolé ?
    public static void main(String[] args) {
        System.out.println("This is a test\n");
        Noeud u = new Noeud(1,-1,"u");
        Noeud v = new Noeud(2,-1,"v");
        Noeud x = new Noeud( 3, -1,"x");
        Noeud y= new Noeud(4,-1,"y");
        Noeud t= new Noeud(6, -1,"t");
        Noeud z= new Noeud(5,-1,"z");



        Graphe g= new Graphe();

        u.AjouterVoisins(x);
        u.AjouterVoisins(y);

        v.AjouterVoisins(z);
        v.AjouterVoisins(x);
        v.AjouterVoisins(t);

        x.AjouterVoisins(v);
        x.AjouterVoisins(y);
        x.AjouterVoisins(u);

        y.AjouterVoisins(u);
        y.AjouterVoisins(x);
        y.AjouterVoisins(t);

        t.AjouterVoisins(v);
        t.AjouterVoisins(y);

        z.AjouterVoisins(v);

        g.AjouterNoeudDansUnGraphe(u);
        g.AjouterNoeudDansUnGraphe(v);
        g.AjouterNoeudDansUnGraphe(x);
        g.AjouterNoeudDansUnGraphe(y);
        g.AjouterNoeudDansUnGraphe(t);
        g.AjouterNoeudDansUnGraphe(z);

        out.print("J'affiche mon Graphe\n");
        g.AfficherGraphe();
        out.print("\n\n");
        g.NoeudDePLusGrandDegres();
        out.print("\n\n");
        g.AfficheNoeudDegreInf(3);
        out.print("\n\n");
        g.ColoriageDeGraphe(3);


        g.RetirerNoeud(z);
        /*g.RetirerNoeud(z);
        g.RetirerNoeud(b); */

        //out.print("J'affiche mon Graphe\n");

       /* g.AfficherGraphe();

        out.print("\n\n");
        g.NoeudDePLusGrandDegres();
        out.print("\n\n");
        g.AfficheNoeudDegreInf(3);
        //  g.AfficheNoeudDegreInf(5); */
    }
}
