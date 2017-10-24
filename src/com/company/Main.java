package com.company;
import static java.lang.System.*;

public class Main {
//Est-ce qu'on peut avoir un noeud isolé ?
    public static void main(String[] args) {
        /**
         * Les couleurs vont de 1 à 3
         * 0 Couleur de base
         * -1 est un spill
         */
        System.out.println("This is a test\n");
        Noeud u = new Noeud(1,0,"u");
        Noeud v = new Noeud(2,0,"v");
        Noeud x = new Noeud( 3, 0,"x");
        Noeud y= new Noeud(4,0,"y");
        Noeud t= new Noeud(6, 0,"t");
        Noeud z= new Noeud(5,0,"z");





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
        g.ColoriageDeGraphe(2);






        Noeud a= new Noeud(7,0,"a");
        Noeud b= new Noeud(8,0,"b");
        Noeud c= new Noeud(9,0,"c");
        Noeud d= new Noeud(10,0,"d");
        Noeud e= new Noeud(11,0,"e");

        /*
        Graphe NewGraphe= new Graphe();

        a.AjouterVoisins(b);
        a.AjouterVoisins(c);

        b.AjouterVoisins(d);
        b.AjouterVoisins(a);

        c.AjouterVoisins(e);
        c.AjouterVoisins(d);

        d.AjouterVoisins(e);
        d.AjouterVoisins(b);

        e.AjouterVoisins(a);
        e.AjouterVoisins(c);

        NewGraphe.AjouterNoeudDansUnGraphe(a);
        NewGraphe.AjouterNoeudDansUnGraphe(b);
        NewGraphe.AjouterNoeudDansUnGraphe(c);
        NewGraphe.AjouterNoeudDansUnGraphe(d);
        NewGraphe.AjouterNoeudDansUnGraphe(e);

        NewGraphe.ColoriageDeGraphe(3);
*/

    }
}
