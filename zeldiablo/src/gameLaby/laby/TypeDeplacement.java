package gameLaby.laby;

/**
 * Interface des différents déplacements requis
 */
public interface TypeDeplacement {
    /**
     * Methode choisissant la direction du personnage
     * @param e entité déplacée
     * @param lab labyrinthe utilisé
     */
    void seDeplacer(Entite e, Labyrinthe lab);
}
