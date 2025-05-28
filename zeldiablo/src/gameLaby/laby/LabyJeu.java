package gameLaby.laby;

import gameArkanoid.Balle;
import gameArkanoid.Raquette;
import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

/**
 * Classe représentant un jeu de labyrinthe implémentant l'interface {@link Jeu}.
 * Ce jeu gère un personnage se déplaçant dans un labyrinthe en fonction des entrées clavier.
 */
public class LabyJeu implements Jeu {

    /**
     * Labyrinthe dans lequel se déroule le jeu.
     */
    private Labyrinthe laby;

    /**
     * Constructeur de la classe {@code LabyJeu}.
     * Initialise le labyrinthe à partir d'un fichier texte.
     *
     * @throws IOException si le fichier du labyrinthe ne peut être lu.
     */
    public LabyJeu() throws IOException {
        this.laby = new Labyrinthe("labySimple/laby1.txt");
    }

    /**
     * Met à jour l'état du jeu en fonction du temps écoulé et des entrées clavier.
     *
     * @param secondes Temps écoulé depuis la dernière mise à jour (non utilisé ici).
     * @param clavier Entrées clavier permettant de déplacer le personnage.
     */
    public void update(double secondes, Clavier clavier) {

        // déplace le personnage en fonction des actions clavier
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

    /**
     * Initialise les éléments du jeu.
     * Ici, aucune initialisation particulière n'est requise.
     */
    public void init() {
        // Pas d'initialisation particulière.
    }

    /**
     * Détermine si le jeu est terminé.
     * Le jeu se termine si le personnage n'est plus vivant.
     *
     * @return {@code true} si le jeu est fini, {@code false} sinon.
     */
    public boolean etreFini() {
        if (!this.laby.getPerso().estVivant()){
            System.out.println("Le jeu est fini car le personnage est mort");
            return true;
        }
        return false;
    }

    /**
     * Accesseur au labyrinthe du jeu.
     *
     * @return le labyrinthe utilisé dans ce jeu.
     */
    public Labyrinthe getLabyrinthe() {
        return this.laby;
    }
}
