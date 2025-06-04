import gameLaby.laby.DeplacementFaible;
import gameLaby.laby.Fantome;
import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Perso;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestIteration5 {

    @Test
    void testPeutTraverser_HorsLimite() throws IOException {
        Fantome fantome = new Fantome(0, 0, 5, new DeplacementFaible());
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso perso = l.getPerso();
        perso.deplacer(Labyrinthe.DROITE);
        perso.deplacer(Labyrinthe.DROITE);
        perso.deplacer(Labyrinthe.DROITE);
        perso.deplacer(Labyrinthe.GAUCHE);
        perso.deplacer(Labyrinthe.GAUCHE);
        perso.deplacer(Labyrinthe.GAUCHE);
        assertTrue(l.victoire());

    }
}
