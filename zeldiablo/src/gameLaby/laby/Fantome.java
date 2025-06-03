package gameLaby.laby;

import javafx.scene.paint.Color;

public class Fantome extends Monstre{

    public Fantome(int x,int y,int v, TypeDeplacement td){
        super(x,y,v,td);
    }

    public Color getColor(){
        return Color.BEIGE;
    }

    public boolean peutTraverser(String dir,Labyrinthe laby){

        int [] coord = laby.getSuivant(this.getPosition()[0],this.getPosition()[1],dir);
        for(Entite e  : laby.getEntites()){
            if(e.etrePresent(coord[0],coord[1])){
                return e.getTraversable();
            }
        }
        return true;
    }

}
