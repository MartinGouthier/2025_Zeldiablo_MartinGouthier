package gameLaby.laby;

import gameArkanoid.Balle;
import gameArkanoid.Raquette;
import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

public class LabyJeu implements Jeu {

    private Labyrinthe laby;

    public LabyJeu() throws IOException {
        this.laby = new Labyrinthe("laby1.txt");
    }

    public void update(double secondes, Clavier clavier) {

        // deplace le personnage en fonction de l'action

        if (clavier.droite) {
            this.laby.deplacerPerso(Labyrinthe.DROITE);
        }

        if (clavier.gauche) {
            this.laby.deplacerPerso(Labyrinthe.GAUCHE);
        }

        if (clavier.haut) {
            this.laby.deplacerPerso(Labyrinthe.HAUT);
        }

        if (clavier.bas) {
            this.laby.deplacerPerso(Labyrinthe.BAS);
        }

    }

    public void init() {
        // Pas d'initialisation particulière.
    }

    public boolean etreFini() {
        // Pas de fin particulière.
        return false;
    }

    public Labyrinthe getLabyrinthe() {
        return this.laby;
    }
}
