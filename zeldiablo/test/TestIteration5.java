import gameLaby.laby.DeplacementFaible;
import gameLaby.laby.Fantome;
import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Perso;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestIteration5 {

    /**
     * Test permettant de verifier la fin du jeu
     * @throws IOException I/O Erreur
     */
    @Test
    void TestFinDuJeu() throws IOException {
        Fantome fantome = new Fantome(0, 0, 5, new DeplacementFaible());
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso perso = l.getPerso();
        l.deplacerManuel(Labyrinthe.DROITE, perso);
        l.deplacerManuel(Labyrinthe.DROITE, perso);
        l.deplacerManuel(Labyrinthe.DROITE, perso);
        l.deplacerManuel(Labyrinthe.GAUCHE, perso);
        l.deplacerManuel(Labyrinthe.GAUCHE, perso);
        l.deplacerManuel(Labyrinthe.GAUCHE, perso);
        assertTrue(l.victoire());

    }
}
