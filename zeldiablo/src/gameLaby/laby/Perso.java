package gameLaby.laby;


import javafx.scene.paint.Color;

/**
 * Classe représentant un personnage situe en x,y
 */
public class Perso extends Entite{

    /**
     * Consctructeur personnage
     * @param x Coordonnée x
     * @param y Coordonnée y
     */
    public Perso(int x, int y) {
        super(x, y, 5);
    }


    /**
     * Renvoie la couleur d'affichage d'un personnage
     * @return Couleur Rouge
     */
    @Override
    public Color getColor() {
        return Color.RED;
    }

    /**
     * Affichage du personnage console
     * @return Perso
     */
    @Override
    public String toString() {
        return "Perso";
    }
}
