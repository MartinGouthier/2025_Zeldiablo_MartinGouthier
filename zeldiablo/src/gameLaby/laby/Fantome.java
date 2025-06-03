package gameLaby.laby;

import javafx.scene.paint.Color;

public class Fantome extends Monstre{

    /**
     * Constructeur de la classe Fantome
     *
     * @param x position x
     * @param y position y
     * @param v vie du Fantome
     * @param td type de déplacement du fantome
     */

    public Fantome(int x,int y,int v, TypeDeplacement td){
        super(x,y,v,td);
    }

    /**
     * méthode getColor qui renvoie une couelur qu isera utilisée pour le fantome
     *
     * @return une couleur
     */

    public Color getColor(){
        return Color.BEIGE;
    }

    /**
     * méthode peutTraverser pour savoir si le fantome peut traverser ce qu'il y a dans la dirrection où il va.
     *
     * @param dir une direction
     * @param laby un labyrinthe
     *
     * @return un booléen qui indique si l'on peut traverser.
     */

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
