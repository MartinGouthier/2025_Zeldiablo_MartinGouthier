package gameLaby.laby;
import java.util.Random;

/**
 * Classe de déplacement aléatoire
 */
public class DeplacementFaible implements TypeDeplacement{

    /**
     * Methode de déplacement
     * @param e Entité déplacée
     * @param lab Labyrinthe utilisé
     */
    public void seDeplacer(Entite e, Labyrinthe lab) {

        String[] tab = {Labyrinthe.HAUT, Labyrinthe.BAS, Labyrinthe.GAUCHE, Labyrinthe.DROITE};
        Random rand = new Random();
        int entier = rand.nextInt(4);
        String action = tab[entier];
        lab.deplacerManuel(action, e);
    }


    }

