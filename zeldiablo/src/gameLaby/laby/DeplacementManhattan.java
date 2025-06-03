package gameLaby.laby;

public class DeplacementManhattan implements TypeDeplacement{

    public void seDeplacer(Entite e, Labyrinthe laby) {

        if (e.getPosition()[0]<laby.getPerso().getPosition()[0]){
            laby.deplacerManuel(Labyrinthe.DROITE,e);
        }
        else if(e.getPosition()[0]>laby.getPerso().getPosition()[0]){
            laby.deplacerManuel(Labyrinthe.GAUCHE, e);
        }
        else if(e.getPosition()[1]<laby.getPerso().getPosition()[1]){
            laby.deplacerManuel(Labyrinthe.BAS, e);
        }
        else if(e.getPosition()[1]>laby.getPerso().getPosition()[1]){
            laby.deplacerManuel(Labyrinthe.HAUT, e);
        }
    }
}

