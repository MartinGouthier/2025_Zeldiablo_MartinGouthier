import com.sun.javafx.scene.EnteredExitedHandler;
import gameLaby.laby.Entite;
import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Monstre;
import gameLaby.laby.Perso;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestIteration1 {

    @Test
    public void InitPerso() throws IOException {
        //init des valeurs
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso p = l.getPerso();
        //Validation des résultats
        assertEquals(5,p.getVie(),"La vie dois être à 5");
        assertEquals(5,p.getX(),"La position X dois être à 5");
        assertEquals(5,p.getY(), "La position Y dois être à 5");
    }

    @Test
    public void AttributEstVivant() throws IOException {
        //init des valeurs
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso p = l.getPerso();
        //Validation des résultats
        assertTrue(p.estVivant(), "Le personnage dois être vivant");
    }

    @Test
    public void MethodeModifierVie() throws IOException {
        //init des valeurs
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso p = l.getPerso();
        //modification des valeurs
        p.modifierVie(-1);
        //Validation des résultats
        assertEquals(4, p.getVie(),"La vie du personnage dois être 4");
    }

    @Test
    public void InitMonstre() throws IOException {
        //init des valeurs
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Entite m = l.getEntites().get(0);
        //Validation des résultats
        assertEquals(5,m.getVie(),"La vie dois être à 5");
        assertEquals(5,m.getX(),"La position X dois être à 5");
        assertEquals(4,m.getY(), "La position Y dois être à 5");

    }

    @Test
    public void PositionMonstreDiffPerso() throws IOException {
        //init des valeurs
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso p = l.getPerso();
        Entite m = l.getEntites().get(0);
        //Validation des résultats
        assertTrue(!p.etrePresent(m.getX(),m.getY()),"leurs positions doivent être différentes");
    }

    @Test
    public void MonstreObstaclePourPerso() throws IOException {
        //init des valeurs
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso p = l.getPerso();
        Entite m = l.getEntites().get(0);
        //modification des valeurs
        l.deplacerEntite(Labyrinthe.HAUT, p);
        //Validation des résultats
        assertEquals(5,p.getX(),"La position X dois être à 5");
        assertEquals(5,p.getY(), "La position Y dois être à 5");
    }
}
