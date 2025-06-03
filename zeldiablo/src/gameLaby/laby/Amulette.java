package gameLaby.laby;

import javafx.scene.paint.Color;

/**
 * Classe créant une amulette
 */
public class Amulette extends Element{
    /**
     * Constructeur d'element
     *
     * @param x Coordonnée x
     * @param y Coordonnée y
     */
    public Amulette(int x, int y) {
        super(x, y);
    }


    /**
     * Getter de couleur
     * @return Couleur jaune
     */
    @Override
    public Color getColor() {
        return Color.YELLOW;
    }
}
