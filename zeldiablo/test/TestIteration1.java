import com.sun.javafx.scene.EnteredExitedHandler;
import gameLaby.laby.Entite;
import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Monstre;
import gameLaby.laby.Perso;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.io.IOException;
/**
 * Classe de tests unitaires pour vérifier les fonctionnalités de base du jeu
 * Labyrinthe, centrées sur l'initialisation et les interactions entre le personnage
 * (Perso) et les monstres (Entite).
 *
 * Les tests suivants sont couverts :
 * 
 *     Initialisation correcte du personnage (position et points de vie)
 *     Vérification de l'état vivant du personnage
 *     Modification des points de vie du personnage
 *     Initialisation correcte d’un monstre
 *     Vérification que le monstre n’est pas sur la même case que le personnage
 *     Vérification qu’un monstre empêche le déplacement du personnage
 *
 */
public class TestIteration1 {

    /**
     * Teste l'initialisation correcte du personnage à partir du fichier labyrinthe.
     * Vérifie sa position et ses points de vie.
     * @throws IOException si le fichier de labyrinthe est introuvable
     */
    @Test
    public void InitPerso() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso p = l.getPerso();
        assertEquals(5, p.getVie(), "La vie doit être à 5");
        assertEquals(5, p.getX(), "La position X doit être à 5");
        assertEquals(5, p.getY(), "La position Y doit être à 5");
    }

    /**
     * Vérifie que le personnage est vivant à l'initialisation.
     * @throws IOException si le fichier de labyrinthe est introuvable
     */
    @Test
    public void AttributEstVivant() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso p = l.getPerso();
        assertTrue(p.estVivant(), "Le personnage doit être vivant");
    }

    /**
     * Vérifie que la méthode de modification des points de vie fonctionne correctement.
     * @throws IOException si le fichier de labyrinthe est introuvable
     */
    @Test
    public void MethodeModifierVie() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso p = l.getPerso();
        p.modifierVie(-1);
        assertEquals(4, p.getVie(), "La vie du personnage doit être 4");
    }

    /**
     * Teste l'initialisation correcte d’un monstre (Entite) dans le labyrinthe.
     * @throws IOException si le fichier de labyrinthe est introuvable
     */
    @Test
    public void InitMonstre() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Entite m = l.getEntites().get(0);
        assertEquals(5, m.getVie(), "La vie doit être à 5");
        assertEquals(5, m.getX(), "La position X doit être à 5");
        assertEquals(4, m.getY(), "La position Y doit être à 5");
    }

    /**
     * Vérifie que le monstre n’est pas positionné sur la même case que le personnage.
     * @throws IOException si le fichier de labyrinthe est introuvable
     */
    @Test
    public void PositionMonstreDiffPerso() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso p = l.getPerso();
        Entite m = l.getEntites().get(0);
        assertTrue(!p.etrePresent(m.getX(), m.getY()), "Leurs positions doivent être différentes");
    }

    /**
     * Vérifie qu’un monstre constitue un obstacle pour le déplacement du personnage.
     * Le personnage ne doit pas pouvoir avancer sur la case du monstre.
     * @throws IOException si le fichier de labyrinthe est introuvable
     */
    @Test
    public void MonstreObstaclePourPerso() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso p = l.getPerso();
        Entite m = l.getEntites().get(0);
        l.deplacerEntite(Labyrinthe.HAUT, p);
        assertEquals(5, p.getX(), "La position X doit être à 5");
        assertEquals(5, p.getY(), "La position Y doit être à 5");
    }
}
