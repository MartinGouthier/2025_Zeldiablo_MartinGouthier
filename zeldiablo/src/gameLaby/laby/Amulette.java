package gameLaby.laby;

import javafx.scene.paint.Color;

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


    @Override
    public Color getColor() {
        return Color.YELLOW;
    }
}
