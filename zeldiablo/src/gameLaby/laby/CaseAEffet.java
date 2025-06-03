package gameLaby.laby;

import javafx.scene.paint.Color;

/**
 * Classe représentant les cases à effet
 */
public class CaseAEffet extends Element{

    /**
     * Constructeur de case à effet
     * @param x Coordonnée x
     * @param y Coordonnée y
     */
    public CaseAEffet(int x, int y) {
        super(x,y);
    }

    /**
     * Methode activant l'effet de la case sur l'entité
     * @param e Entité affectée
     */
    public void activation(Entite e){
        int[] coord = this.getPosition();
        System.out.println("La case à la position : " +coord[0] +","+coord[1] + " a été activée");
    }

    /**
     * Methode renvoyant la position de la case
     * @return Tableau de coordonnées
     */


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
