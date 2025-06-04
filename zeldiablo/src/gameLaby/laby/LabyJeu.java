package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;
import java.util.Random;

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
     * Booleen indiquant si le jeu est fini
     */
    private boolean estFini;

    /**
     * Constructeur de la classe {@code LabyJeu}.
     * Initialise le labyrinthe à partir d'un fichier texte.
     *
     * @throws IOException si le fichier du labyrinthe ne peut être lu.
     */
    public LabyJeu() throws IOException {
        this.laby = new Labyrinthe("labySimple/labyITERATION5.txt");
        estFini = false;
    }

    /**
     * Met à jour l'état du jeu en fonction du temps écoulé et des entrées clavier.
     *
     * @param secondes Temps écoulé depuis la dernière mise à jour (non utilisé ici).
     * @param clavier Entrées clavier permettant de déplacer le personnage.
     */
    public void update(double secondes, Clavier clavier) {

        if (!etreFini()) {
            // déplace le personnage en fonction des actions clavier
            if (clavier.droite) {
                this.laby.deplacerManuel(Labyrinthe.DROITE, laby.getPerso());
            }

            if (clavier.gauche) {
                this.laby.deplacerManuel(Labyrinthe.GAUCHE, laby.getPerso());
            }

            if (clavier.haut) {
                this.laby.deplacerManuel(Labyrinthe.HAUT, laby.getPerso());
            }

            if (clavier.bas) {
                this.laby.deplacerManuel(Labyrinthe.BAS, laby.getPerso());
            }

            // Actions des entités
            for (int i = 0; i < laby.getEntites().size(); i++) {
                Entite entite = laby.getEntites().get(i);
                if (laby.getEntites().indexOf(entite) != 0) { // Si ce n'est pas le joueur
                    Random rand = new Random();
                    int n = rand.nextInt(5); // Une chance sur 5 pour faire une action
                    if (n == 0) {
                        Monstre m = (Monstre) entite;
                        m.getDeplacement().seDeplacer(m, laby);
                        if (!m.estVivant()) {
                            this.laby.getEntites().remove(m);
                        }
                    }
                }
            }
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
        if (!estFini) {
            if (!this.laby.getPerso().estVivant()) {
                System.out.println("Le jeu est fini car le personnage est mort");
                estFini = true;
                return true;
            } else if (this.laby.victoire()) {
                System.out.println("Le jeu est fini car vous avez placé l'amulette");
                estFini = true;
                return true;
            }
            return false;
        }
        return true;

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
