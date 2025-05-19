package gameLaby.laby;
import moteurJeu.MoteurJeu;

public class MainLaby {
    public static void main(String[] args) {
        int width = 800;
        int height = 600;
        int pFPS = 100;

        // creation des objets
        public LabyJeu jeu_laby = new LabyJeu();
        public LabyDessin laby_dessin = new LabyDessin();

        // parametrage du moteur de jeu
        MoteurJeu.setTaille(width,height);
        MoteurJeu.setFPS(pFPS);

        // lancement du jeu
        MoteurJeu.launch(jeu_laby, laby_dessin);
    }
}
