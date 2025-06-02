package gameLaby.laby;

import javafx.scene.paint.Color;

/**
 * Classe représentant un monstre
 */
public class Monstre extends Entite{

    /**
     * Constructeur de monstre
     * @param x Position x du monstre
     * @param y Position y du monstre
     * @param v Vie du monstre
     */
    public Monstre(int x, int y, int v) {
        super(x, y, v);
    }

    /**
     * Renvoie la couleur d'affichage d'un monstre
     * @return Couleur violette
     */
    @Override
    public Color getColor() {
        return Color.PURPLE;
    }
}
