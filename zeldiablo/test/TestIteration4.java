import gameLaby.laby.*;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;


import gameLaby.laby.Entite;
import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Perso;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestIteration4 {


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

    @Test
    void testPeutTraverser_HorsLimite() throws IOException {
        Fantome fantome = new Fantome(0, 0, 5, new DeplacementFaible());
        Labyrinthe laby = new Labyrinthe("labySimple/laby3.txt");

        String direction = Labyrinthe.HAUT;
        assertFalse(fantome.peutTraverser(direction, laby),
                "Le fantôme ne devrait pas pouvoir sortir des limites du labyrinthe");
    }

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

}
