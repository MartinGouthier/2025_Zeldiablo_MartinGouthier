package gameLaby.laby;
import java.util.Random;

public class DeplacementFaible implements TypeDeplacement{

    public void seDeplacer(Entite e, Labyrinthe lab) {

        String[] tab = {Labyrinthe.HAUT, Labyrinthe.BAS, Labyrinthe.GAUCHE, Labyrinthe.DROITE};
        Random rand = new Random();
        int entier = rand.nextInt(4);
        String action = tab[entier];
        lab.deplacerManuel(action, e);
    }


    }

