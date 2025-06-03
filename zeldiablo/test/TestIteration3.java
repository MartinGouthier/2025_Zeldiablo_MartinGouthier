import gameLaby.laby.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import gameLaby.laby.Entite;
import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Perso;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de tests unitaires pour vérifier les fonctionnalités de base du jeu
 * Labyrinthe, centrées sur le déplacement des monstres et l'intelligence de ceux-si.
 *
 * Les tests suivants sont couverts :
 *
 * Le chemin déterminé est le bon et le monstre se déplace effectivement sur ce chemin.
 * Des monstres avec une intelligence différente sont présents en même temps.
 * Les monstres d'intelligence moyenne construisent un chemin contenant les pièges (le déplacement ici est le même que le premier test).
 *
 */
public class TestIteration3 {

    /**
     * Teste si le chemin que le monstre choisi est bien le plus court en ne prenant pas en compte les pièges. Le monstre rreste coincé.
     * Vérifie le chemin et l'emplacement des pièges.
     * @throws IOException si le fichier de labyrinthe est introuvable
     */
    @Test
    public void test01_cheminLePlusCourtCoince() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby3.txt");
        Perso p = l.getPerso();
        Monstre mMoyen = (Monstre) l.getEntites().get(2);
        int xInit = mMoyen.getPosition()[0];
        int yInit = mMoyen.getPosition()[1];
        mMoyen.getDeplacement().seDeplacer(mMoyen,l);
        int xDeuxieme = mMoyen.getPosition()[0];
        int yDeuxieme = mMoyen.getPosition()[1];
        for(int i = 0; i <100; i++){
            mMoyen.getDeplacement().seDeplacer(mMoyen,l);
        }
        int xCoince = mMoyen.getPosition()[0];
        int yCoince = mMoyen.getPosition()[1];
        assertEquals(5, p.getVie(), "La vie doit être à 5");
        assertEquals(17, p.getPosition()[0], "La position X doit être à 17");
        assertEquals(14, p.getPosition()[1], "La position Y doit être à 14");
        assertEquals(20, xInit, "La position Y doit être à 20");
        assertEquals(7, yInit, "La position Y doit être à 7");
        assertEquals(20, xDeuxieme, "La position Y doit être à 20");
        assertEquals(8, yDeuxieme, "La position Y doit être à 8");
        assertEquals(20, xCoince, "La position Y doit être à 20");
        assertEquals(10, yCoince, "La position Y doit être à 10");
    }

    /**
     * Teste si le chemin que le monstre choisi est bien le plus court en ne prenant pas en compte les pièges. Le monstre rreste coincé.
     * Vérifie le chemin et l'emplacement des pièges.
     * @throws IOException si le fichier de labyrinthe est introuvable
     */
    @Test
    public void test02_cheminLePlusCourtCorrect() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby3.txt");
        Perso p = l.getPerso();
        Monstre mMoyen = (Monstre) l.getEntites().get(2);
        int xInit = mMoyen.getPosition()[0];
        int yInit = mMoyen.getPosition()[1];
        mMoyen.getDeplacement().seDeplacer(mMoyen,l);
        int xDeuxieme = mMoyen.getPosition()[0];
        int yDeuxieme = mMoyen.getPosition()[1];
        for(int i = 0; i <100;i++){
            mMoyen.getDeplacement().seDeplacer(mMoyen,l);
        }
        int xCoince = mMoyen.getPosition()[0];
        int yCoince = mMoyen.getPosition()[1];

        p.deplacer(Labyrinthe.GAUCHE);
        p.deplacer(Labyrinthe.GAUCHE);
        p.deplacer(Labyrinthe.GAUCHE);
        p.deplacer(Labyrinthe.GAUCHE);

        for(int i = 0; i <1000; i++){
            mMoyen.getDeplacement().seDeplacer(mMoyen,l);
        }

        int xFin = mMoyen.getPosition()[0];
        int yFin = mMoyen.getPosition()[1];

        assertEquals(5, p.getVie(), "La vie doit être à 5");
        assertEquals(13, p.getPosition()[0], "La position X doit être à 17");
        assertEquals(14, p.getPosition()[1], "La position Y doit être à 15");
        assertEquals(20, xInit, "La position Y doit être à 20");
        assertEquals(7, yInit, "La position Y doit être à 7");
        assertEquals(20, xDeuxieme, "La position Y doit être à 20");
        assertEquals(8, yDeuxieme, "La position Y doit être à 8");
        assertEquals(20, xCoince, "La position Y doit être à 20");
        assertEquals(10, yCoince, "La position Y doit être à 10");
        assertEquals(14, xFin, "La position Y doit être à 15");
        assertEquals(14, yFin, "La position Y doit être à 15");
    }


    /**
     * Vérifie que la méthode DeplacerImmobile fonctionne (le monstre ne se déplace pas).
     * @throws IOException si le fichier de labyrinthe est introuvable
     */
    @Test
    public void test03_deplacementIntelligenceNulle() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby3.txt");
        Perso p = l.getPerso();
        DeplacementNul dn = new DeplacementNul();
        dn.seDeplacer(p,l);
        assertEquals(17, p.getPosition()[0], "La position x du personnage doit être 5");
        assertEquals(14, p.getPosition()[1], "La position y du personnage doit être 5");
    }

    /**
     * Vérifie qu'il peut y avoir des monstres à intelligence différente en même temps sur le même jeu.
     * @throws IOException si le fichier de labyrinthe est introuvable
     */
    @Test
    public void test04_deplacementIntelligenceDifferente() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby3.txt");
        Perso p = l.getPerso();
        Monstre mNulle = (Monstre) l.getEntites().get(1);
        Monstre mFaible = (Monstre) l.getEntites().get(3);
        Monstre mMoyenne = (Monstre) l.getEntites().get(2);
        assertNotEquals(mNulle.getDeplacement(), mFaible.getDeplacement(),"Le moyen de déplacement doit être différent entre l'intelligence nulle et et faible");
        assertNotEquals(mFaible.getDeplacement(),mMoyenne.getDeplacement(), "Le moyen de déplacement doit être différent entre l'intelligence faible et et moyenne");
        assertNotEquals(mNulle.getDeplacement(),mMoyenne.getDeplacement(), "Le moyen de déplacement doit être différent entre l'intelligence nulle et et moyenne");
    }

    /**
     * Vérifie que la méthode DeplacerImmobile fonctionne (le monstre ne se déplace pas).
     * @throws IOException si le fichier de labyrinthe est introuvable
     */
    @Test
    public void test05_deplacementIntelligenceAleatoire() throws IOException {
        Labyrinthe l = new Labyrinthe("labySimple/laby3.txt");
        Perso p = l.getPerso();
        Monstre mFaible = (Monstre) l.getEntites().get(3);
        mFaible.getDeplacement().seDeplacer(mFaible,l);
        assertTrue(mFaible.etrePresent(4,13) || mFaible.etrePresent(4,11) || mFaible.etrePresent(3,12) || mFaible.etrePresent(5,12));

    }

}
