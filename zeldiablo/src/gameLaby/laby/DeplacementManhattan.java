package gameLaby.laby;

public class DeplacementManhattan implements TypeDeplacement{

    public void seDeplacer(Entite e, Labyrinthe laby) {

        if(e.getPosition()[0]<laby.getPerso().getPosition()[1]){laby.deplacerManuel("droite",e);}
        else{ laby.deplacerManuel("gauche", e);}

        if(e.getPosition()[0]>laby.getPerso().getPosition()[1]){laby.deplacerManuel("haut", e);}
        else{laby.deplacerManuel("haut", e);}

    }
}

