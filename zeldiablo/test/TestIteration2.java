import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Perso;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Cette classe de tests se concentre sur les Cases à effet et les cases pièges,
 * elle vérifie leur bon fonctionnement
 */
public class TestIteration2 {

    /**
     * Méthode test qui vérifie que la Case à effet est traversable par le joueur.
     * @throws IOException retourne une IOException si le fichier est illisible.
     */
    @Test
    public void CaseAEffetTraversable() throws IOException {
        //init des valeurs
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso p = l.getPerso();
        //modification des variables
        l.deplacerEntite(Labyrinthe.DROITE, p);
        //test des valeurs
        assertEquals(6, p.getX(), "La position X doit être à 6");
        assertEquals(5, p.getY(), "La position Y doit être à 5");
    }

    /**
     * Méthode test qui vérifie que la Case piège est traversable par le joueur.
     * @throws IOException retourne une IOException si le fichier est illisible.
     */
    @Test
    public void CasePiegeTraversable() throws IOException {
        //init des valeurs
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso p = l.getPerso();
        //modification des variables
        l.deplacerEntite(Labyrinthe.DROITE, p);
        l.deplacerEntite(Labyrinthe.DROITE, p);
        //test des valeurs
        assertEquals(7, p.getX(), "La position X doit être à 7");
        assertEquals(5, p.getY(), "La position Y doit être à 5");
    }

    /**
     * Méthode test qui vérifie que lorsque de l'activation d'une case piece le joueur
     * perd un point de vie.
     * @throws IOException retourne une IOException si le fichier est illisible.
     */
    @Test
    public void CasePiegePerteVie() throws IOException {
        //init des valeurs
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso p = l.getPerso();
        //modification des variables
        l.deplacerEntite(Labyrinthe.DROITE, p);
        l.deplacerEntite(Labyrinthe.DROITE, p);
        //test des valeurs
        assertEquals(4,p.getVie(),"La vie du personnage est de 4");
    }

    @Test
    public void CasePiegeReactivable() throws IOException {
        //init des valeurs
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");
        Perso p = l.getPerso();
        //modification des variables
        l.deplacerEntite(Labyrinthe.DROITE, p);
        l.deplacerEntite(Labyrinthe.DROITE, p);
        l.deplacerEntite(Labyrinthe.DROITE, p);
        l.deplacerEntite(Labyrinthe.GAUCHE, p);
        //test des valeurs
        assertEquals(3,p.getVie(),"La vie du personnage est de 3");
    }

}
