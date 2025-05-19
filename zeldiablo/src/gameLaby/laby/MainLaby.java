package gameLaby.laby;
import moteurJeu.MoteurJeu;

public class MainLaby {
    public static void main(String[] args) {
        public LabyJeu jeu_laby = new LabyJeu();
        public LabyDessin laby_dessin = new LabyDessin();

        // lancement du jeu
        MoteurJeu.launch(jeu_laby, laby_dessin);
    }
}