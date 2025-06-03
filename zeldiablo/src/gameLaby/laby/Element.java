package gameLaby.laby;

import javafx.scene.paint.Color;

/**
 * Classe Element representant un element quelconque du labyrinthe
 */
public abstract class Element {
    /**
     * Coordonnée x
     */
    private int x;
    /**
     * Coordonnée y
     */
    private int y;


    /**
     * Constructeur d'element
     * @param x Coordonnée x
     * @param y Coordonnée y
     */
    public Element(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Getter de coordonnées
     * @return Tableau de coordonnées
     */
    public int[] getPosition(){
        return new int[]{x, y};
    }

    /**
     * Methode pour déplacer de x case horizontalement
     * @param x valeur de déplacement
     */
    public void bougerX(int x){
        this.x += x;
    }

    /**
     * Methode pour déplacer de y case verticalement
     * @param y valeur de déplacement
     */
    public void bougerY(int y){
        this.y += y;
    }


    /**
     * permet de savoir si l'entité est en x,y
     *
     * @param x position testee
     * @param y position testee
     * @return true si le personnage est bien en (dx,dy)
     */
    public boolean etrePresent(int x, int y) {

        return (this.x == x && this.y == y);
    }

    /**
     * Methode indiquant si une case est traversable par une entité
     * @param x Coordonnée x
     * @param y Coordonnée y
     * @return Indication si traversable
     */

    /**
     * Getter de couleur associée à l'element
     * @return Couleur
     */
    public abstract Color getColor();

}

