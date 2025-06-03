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

    @Test
    void AmuletteInitialisation() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        assertEquals(8, l.getAmulette().getPosition()[0],"la possition de l'amulette est 5");
        assertEquals(5, l.getAmulette().getPosition()[1],"la possition de l'amulette est 8");
    }

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

    @Test
    void AmuletteDisparaitPrit() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso perso = l.getPerso();
        perso.deplacer(Labyrinthe.DROITE);
        perso.deplacer(Labyrinthe.DROITE);
        perso.deplacer(Labyrinthe.DROITE);
        assertTrue(perso.aAmulette());
    }

    @Test
    void PersoPossedeAmulette() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");

    }

    @Test
    void MonstreNePossedePasAmulette() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");

    }
}
