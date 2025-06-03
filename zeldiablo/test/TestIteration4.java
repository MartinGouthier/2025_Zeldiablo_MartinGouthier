import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Perso;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestIteration4 {

    @Test
    public void FantomeTraverseMur() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby3.txt");
        Perso p = l.getPerso();
    }
}
