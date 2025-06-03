package gameLaby.laby;

public class DeplacementManhattan implements TypeDeplacement{

    public void seDeplacer(Monstre m, Labyrinthe laby) {
        if(m.getX()<laby.getPerso().getX()){laby.getPerso().deplacer("droite");}
        else{laby.getPerso().deplacer("gauche");}

        if(m.getY()>laby.getPerso().getY()){laby.getPerso().deplacer("bas");}
        else{laby.getPerso().deplacer("haut");}

    }
}

