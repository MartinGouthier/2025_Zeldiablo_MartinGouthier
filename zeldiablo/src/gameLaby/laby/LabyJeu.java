package gameLaby.laby;

import gameArkanoid.Balle;
import gameArkanoid.Raquette;
import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

public class LabyJeu implements Jeu {

    private Labyrinthe laby;

    public LabyJeu() throws IOException {
        this.laby = new Labyrinthe("labySimple/laby1.txt");
    }

    public void update(double secondes, Clavier clavier) {

        // deplace le personnage en fonction de l'action

        if (clavier.droite) {
            this.laby.deplacerEntite(Labyrinthe.DROITE, laby.getPerso());
        }

        if (clavier.gauche) {
            this.laby.deplacerEntite(Labyrinthe.GAUCHE, laby.getPerso());
        }

        if (clavier.haut) {
            this.laby.deplacerEntite(Labyrinthe.HAUT, laby.getPerso());
        }

        if (clavier.bas) {
            this.laby.deplacerEntite(Labyrinthe.BAS, laby.getPerso());
        }

    }

    public void init() {
        // Pas d'initialisation particulière.
    }

    public boolean etreFini() {
        if (!this.laby.getPerso().estVivant()){
            System.out.println("Le jeu est fini car le personnage est mort");
            return true;
        }
        return false;
    }

    public Labyrinthe getLabyrinthe() {
        return this.laby;
    }
}
