package gameLaby.laby;

import javafx.scene.paint.Color;

/**
 * Classe représentant un monstre
 */
public class Monstre extends Entite{

    private TypeDeplacement deplacement;

    /**
     * Constructeur de monstre
     * @param x Position x du monstre
     * @param y Position y du monstre
     * @param v Vie du monstre
     */
    public Monstre(int x, int y, int v, TypeDeplacement t) {
        super(x, y, v);
        deplacement = t;
    }

    public TypeDeplacement getDeplacement(){
        return deplacement;
    }
    /**
     * Renvoie la couleur d'affichage d'un monstre
     * @return Couleur violette
     */
    @Override
    public Color getColor() {
        return Color.PURPLE;
    }

    /**
     * Methode d'affichage du type d'entité
     * @return Monstre
     */
    @Override
    public String toString() {
        return "Monstre";
    }
}
