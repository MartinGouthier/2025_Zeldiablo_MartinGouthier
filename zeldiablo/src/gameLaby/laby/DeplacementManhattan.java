package gameLaby.laby;

public class DeplacementManhattan implements TypeDeplacement{

    public void seDeplacer(Entite e, Labyrinthe laby) {

        if(e.getPosition()[0]<laby.getPerso().getPosition()[1]){laby.getPerso().deplacer("droite");}
        else{laby.getPerso().deplacer("gauche");}

        if(e.getPosition()[0]>laby.getPerso().getPosition()[1]){laby.getPerso().deplacer("bas");}
        else{laby.getPerso().deplacer("haut");}

    }
}

