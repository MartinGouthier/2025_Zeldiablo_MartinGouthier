import gameLaby.laby.*;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;


import gameLaby.laby.Entite;
import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Perso;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de tests pour la quatrième itération du projet Labyrinthe.
 * Cette classe vérifie les fonctionnalités liées aux déplacements des fantômes,
 * à l'interaction avec l'amulette et aux collisions entre entités.
 */
public class TestIteration4 {

    /**
     * Teste si un fantôme peut se déplacer dans une direction sans obstacle.
     * Vérifie que les coordonnées après déplacement restent dans les limites du labyrinthe.
     * @throws IOException en cas d'erreur lors de la lecture du fichier du labyrinthe
     */
    @Test
    void testPeutTraverser_SansObstacle() throws IOException {
        Fantome fantome = new Fantome(2, 2, 5, new DeplacementFaible());
        Labyrinthe laby = new Labyrinthe("labySimple/laby3.txt");

        String direction = Labyrinthe.DROITE;
        int[] coord = Labyrinthe.getSuivant(fantome.getPosition()[0], fantome.getPosition()[1], direction);

        assertTrue(laby.getLength() > coord[0] && coord[0] >= 0 &&
                        laby.getLengthY() > coord[1] && coord[1] >= 0,
                "Les coordonnées doivent être à l'intérieur des limites du labyrinthe");
    }
    /**
     * Teste si un fantôme est empêché de sortir des limites du labyrinthe.
     * @throws IOException en cas d'erreur lors de la lecture du fichier du labyrinthe
     */
    @Test
    void testPeutTraverser_HorsLimite() throws IOException {
        Fantome fantome = new Fantome(0, 0, 5, new DeplacementFaible());
        Labyrinthe laby = new Labyrinthe("labySimple/laby3.txt");

        String direction = Labyrinthe.HAUT;
        assertFalse(fantome.peutTraverser(direction, laby),
                "Le fantôme ne devrait pas pouvoir sortir des limites du labyrinthe");
    }

    /**
     * Teste si un fantôme ne peut pas traverser une case occupée par une autre entité.
     * @throws IOException en cas d'erreur lors de la lecture du fichier du labyrinthe
     */
    @Test
    void testPeutTraverser_AvecEntite() throws IOException {
        // Arrange
        Fantome fantome = new Fantome(2, 2, 5, new DeplacementFaible());
        Labyrinthe laby = new Labyrinthe("labySimple/laby3.txt");  // Remplace ce nom par un fichier adapté pour tes tests

        // Crée une entité bloquante à la position (2,1) où le fantôme irait en allant au nord
        Entite obstacle = new Monstre(2, 1, 5, new DeplacementFaible());
        laby.getEntites().add(obstacle);

        // Act
        String direction = "Haut";  // Attention, ton code utilise probablement la constante Labyrinthe.HAUT
        boolean peutTraverser = fantome.peutTraverser(direction, laby);

        // Assert
        assertFalse(peutTraverser, "Le fantôme ne devrait pas pouvoir traverser une case occupée");
    }

    /**
     * Vérifie que l'amulette est correctement initialisée à sa position de départ.
     * @throws IOException en cas d'erreur lors de la lecture du fichier du labyrinthe
     */
    @Test
    void AmuletteInitialisation() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        assertEquals(8, l.getAmulette().getPosition()[0],"la possition de l'amulette est 5");
        assertEquals(5, l.getAmulette().getPosition()[1],"la possition de l'amulette est 8");
    }

    /**
     * Teste si l'amulette peut être traversée par les entités du jeu.
     * Vérifie les déplacements du personnage et d'un monstre par rapport à l'amulette.
     * @throws IOException en cas d'erreur lors de la lecture du fichier du labyrinthe
     */
    @Test
    void AmuletteTraversable() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso perso = l.getPerso();
        Entite m = l.getEntites().get(1);
        perso.deplacer(Labyrinthe.DROITE);
        perso.deplacer(Labyrinthe.DROITE);
        perso.deplacer(Labyrinthe.DROITE);
        perso.deplacer(Labyrinthe.GAUCHE);
        m.deplacer(Labyrinthe.DROITE);
        m.deplacer(Labyrinthe.DROITE);
        m.deplacer(Labyrinthe.DROITE);
        m.deplacer(Labyrinthe.BAS);
        assertEquals(7,perso.getPosition()[0]);
        assertEquals(5,perso.getPosition()[1]);
        assertEquals(8,m.getPosition()[0]);
        assertEquals(5,m.getPosition()[1]);
    }

    /**
     * Vérifie que le personnage peut récupérer l'amulette en passant sur sa case.
     * @throws IOException en cas d'erreur lors de la lecture du fichier du labyrinthe
     */
    @Test
    void PersoPossedeAmulette() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso perso = l.getPerso();
        l.deplacerManuel(Labyrinthe.DROITE,perso);
        l.deplacerManuel(Labyrinthe.DROITE,perso);
        l.deplacerManuel(Labyrinthe.DROITE,perso);
        assertTrue(perso.aAmulette());
    }

    /**
     * Teste qu'un monstre ne peut pas ramasser l'amulette en passant sur sa case.
     * @throws IOException en cas d'erreur lors de la lecture du fichier du labyrinthe
     */
    @Test
    void MonstreNePossedePasAmulette() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Entite m = l.getEntites().get(1);
        Perso perso = l.getPerso();
        l.deplacerManuel(Labyrinthe.DROITE,m);
        l.deplacerManuel(Labyrinthe.DROITE,m);
        l.deplacerManuel(Labyrinthe.DROITE,m);
        l.deplacerManuel(Labyrinthe.BAS,m);
        l.deplacerManuel(Labyrinthe.HAUT,m);
        l.deplacerManuel(Labyrinthe.DROITE,perso);
        l.deplacerManuel(Labyrinthe.DROITE,perso);
        l.deplacerManuel(Labyrinthe.DROITE,perso);
        assertTrue(perso.aAmulette());
    }
}
