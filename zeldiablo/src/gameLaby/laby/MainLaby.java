package gameLaby.laby;
import moteurJeu.MoteurJeu;

import java.io.IOException;

/**
 * Main lançant l'application du labyrinthe
 */
public class MainLaby {

    /**
     * Methode main lançant l'application
     * @param args inutilisé
     * @throws IOException erreur I/O
     */
    public static void main(String[] args) throws IOException {
        int width = 800;
        int height = 600;
        int pFPS = 10;

        // creation des objets
        LabyJeu jeu_laby = new LabyJeu();
        LabyDessin laby_dessin = new LabyDessin();

        // parametrage du moteur de jeu
        MoteurJeu.setTaille(width,height);
        MoteurJeu.setFPS(pFPS);

        // lancement du jeu
        MoteurJeu.launch(jeu_laby, laby_dessin);
    }
}
