package gameLaby.laby;


import javafx.scene.paint.Color;

/**
 * Classe représentant un personnage situe en x,y
 */
public class Perso extends Entite{

    private boolean possedeAmulette;

    /**
     * Consctructeur personnage
     * @param x Coordonnée x
     * @param y Coordonnée y
     */
    public Perso(int x, int y) {
        super(x, y, 5);
        possedeAmulette = false;
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

    public boolean aAmulette(){
        return this.possedeAmulette;
    }

    /**
     * Redéfinition de la méthode qui permet de déterminer si dans une direction la case est traversable. On vérifie maintenant qu'on récupère l'amulette.
     * @param dir la direction vers laquelle on va se déplacer
     * @param laby le labyrinthe dans lequel on interagit
     * @return un booléen true si la case suivante est traversable, false sinon
     */
    public boolean peutTraverser(String dir, Labyrinthe laby) {
        if (super.peutTraverser(dir, laby)) {
            int[] coord = Labyrinthe.getSuivant(this.getPosition()[0], this.getPosition()[1], dir);
            if (laby.getAmulette().getPosition()[0] == coord[0] && laby.getAmulette().getPosition()[1] == coord[1]) {
                this.possedeAmulette = true;
            }
            return true;
        }
        return false;
    }

}
