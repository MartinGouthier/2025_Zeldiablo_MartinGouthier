package gameLaby.laby;

import javafx.scene.paint.Color;

/**
 * Classe représentant les cases à effet
 */
public class CaseAEffet {
    /**
     * Coordonnée x
     */
    private int posx;
    /**
     * Coordonnée y
     */
    private int posy;


    /**
     * Constructeur de case à effet
     * @param x Coordonnée x
     * @param y Coordonnée y
     */
    public CaseAEffet(int x, int y) {
        this.posx = x;
        this.posy = y;
    }

    /**
     * Methode activant l'effet de la case sur l'entité
     * @param e Entité affectée
     */
    public void activation(Entite e){
        System.out.println("La case à la position : " + posx+","+posy + " a été activée");
    }

    /**
     * Methode renvoyant la position de la case
     * @return Tableau de coordonnées
     */
    public int[] getPosition(){
        return new int[]{posx, posy};
    }

    /**
     * Renvoit l'état de découverte de la case  effet
     * @return Etat
     */
    public boolean getDecouvert(){
        return true;
    }

    /**
     * Renvoit la couleur associée à une case à effet
     * @return Couleur bleue
     */
    public Color getColor(){
        return Color.BLUE;
    }
}
