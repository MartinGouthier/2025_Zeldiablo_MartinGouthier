import gameLaby.laby.CaseAEffet;
import gameLaby.laby.Entite;
import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Perso;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIteration2 {

    @Test
    public void CaseAEffetTraversable() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso p = l.getPerso();
        CaseAEffet cas = l.getCaseEffet().get(1);
        l.deplacerEntite(Labyrinthe.DROITE, p);
        assertEquals(6, p.getX(), "La position X doit être à 5");
        assertEquals(5, p.getY(), "La position Y doit être à 5");
    }
    @Test
    public void CasePiegeTraversable() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso p = l.getPerso();
        CaseAEffet cas = l.getCaseEffet().get(1);
        l.deplacerEntite(Labyrinthe.DROITE, p);
        assertEquals(6, p.getX(), "La position X doit être à 5");
        assertEquals(5, p.getY(), "La position Y doit être à 5");
    }

}
