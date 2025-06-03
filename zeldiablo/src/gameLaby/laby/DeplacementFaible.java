package gameLaby.laby;
import java.util.Random;

public class DeplacementFaible implements TypeDeplacement{

    public void seDeplacer(Entite e, Labyrinthe lab) {

        String[] tab = {"Haut", "Bas", "Gauche", "Droite"};
        Random rand = new Random();
        int entier = rand.nextInt(4);
        String action = tab[entier];
        lab.deplacerManuel(action, e);
    }


    }

