package gameLaby.laby;

/**
 * Classe de déplacement manhattan
 */
public class DeplacementManhattan implements TypeDeplacement{

    /**
     * Methode de déplacement
     * @param e Entitée déplacée
     * @param laby Labyrinthe utilisé
     */
    public void seDeplacer(Entite e, Labyrinthe laby) {
        int[] positionEntite = e.getPosition();
        int[] positionJoueur = laby.getPerso().getPosition();

        int dx = Math.abs(positionEntite[0] - positionJoueur[0]);
        int dy = Math.abs(positionEntite[1] - positionJoueur[1]);

        if (dx > dy) {
            if (positionEntite[0] < positionJoueur[0]) {
                laby.deplacerManuel(Labyrinthe.DROITE, e);
            } else if (positionEntite[0] > positionJoueur[0]) {
                laby.deplacerManuel(Labyrinthe.GAUCHE, e);
            }
        }
        else {
            if (positionEntite[1] < positionJoueur[1]) {
                laby.deplacerManuel(Labyrinthe.BAS, e);
            } else if (positionEntite[1] > positionJoueur[1]) {
                laby.deplacerManuel(Labyrinthe.HAUT, e);
            }
        }
    }
}

