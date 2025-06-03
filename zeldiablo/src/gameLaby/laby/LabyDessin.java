package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

/**
 * Classe responsable de l'affichage graphique du jeu de labyrinthe.
 * Implémente l'interface {@link DessinJeu}.
 */
public class LabyDessin implements DessinJeu {

    /**
     * Dessine le jeu sur le canevas.
     * Affiche soit l'écran de fin, soit le jeu en cours selon l'état du jeu.
     *
     * @param jeu le jeu à dessiner (doit être une instance de {@link LabyJeu})
     * @param canvas le canevas sur lequel dessiner
     */
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        if (jeu.etreFini()) {
            this.ecranFin(jeu, canvas);
        } else {
            this.jeuFonctionnel(jeu, canvas);
        }
    }

    /**
     * Affiche l'écran de fin de partie.
     *
     * @param jeu le jeu terminé
     * @param canvas le canevas sur lequel afficher le message de fin
     */
    public void ecranFin(Jeu jeu, Canvas canvas) {
        LabyJeu lj = (LabyJeu) jeu;
        Labyrinthe laby = lj.getLabyrinthe();

        final GraphicsContext gc = canvas.getGraphicsContext2D();

        // Fond noir
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        String message;
        // Texte à afficher
        if(laby.victoire()){
            message = "Vous avez gagné !";
            gc.setFill(Color.GREEN);}
        else{
            message = "Vous avez perdu !";
            gc.setFill(Color.RED);
        }

        javafx.scene.text.Font font = javafx.scene.text.Font.font("Arial", 40);
        gc.setFont(font);

        // Mesure du texte pour le centrer
        javafx.scene.text.Text text = new javafx.scene.text.Text(message);
        text.setFont(font);
        double textWidth = text.getLayoutBounds().getWidth();
        double textHeight = text.getLayoutBounds().getHeight();

        double x = (canvas.getWidth() - textWidth) / 2;
        double y = (canvas.getHeight() - textHeight) / 2 + textHeight;

        gc.fillText(message, x, y);
    }

    /**
     * Affiche l'état actuel du labyrinthe : murs, cases vides, et entités (personnage ou ennemis).
     *
     * @param jeu le jeu en cours (doit être une instance de {@link LabyJeu})
     * @param canvas le canevas sur lequel dessiner
     */
    public void jeuFonctionnel(Jeu jeu, Canvas canvas) {

        LabyJeu lj = (LabyJeu) jeu;
        Labyrinthe laby = lj.getLabyrinthe();

        final GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        int nbrColonne = laby.getLength();
        int nbrLigne = laby.getLengthY();
        int largeur = (int) (canvas.getWidth() / nbrColonne);
        int hauteur = (int) (canvas.getHeight() / nbrLigne);

        for (int i = 0; i < nbrColonne; i++) {
            for (int j = 0; j < nbrLigne; j++) {
                // Dessine les murs et les cases vides
                if (laby.getMur(i, j)) {
                    gc.setFill(Color.BLACK);
                } else {
                    gc.setFill(Color.WHITE);
                }
                gc.fillRect(i * largeur, j * hauteur, largeur, hauteur);

            }
        }
        // Dessine les cases à effets
        for (CaseAEffet ca : laby.getCaseEffet()){
            int[] coords = ca.getPosition();

            if(ca.getDecouvert()){
                gc.setFill(ca.getColor());
            }
            else {
                gc.setFill(Color.WHITE);
            }
            gc.fillRect(coords[0] * largeur, coords[1] * hauteur, largeur, hauteur);

        }
        // Affichage amulette
        if (laby.getAmulette() != null){
            gc.setFill(Color.YELLOW);
            int[] coords = laby.getAmulette().getPosition();
            gc.fillOval(coords[0] * largeur, coords[1] * hauteur, largeur, hauteur);
        }

        if (laby.getPerso().aAmulette()){
            gc.setFill(Color.WHITE);
            int[] coords = laby.getAmulette().getPosition();
            gc.fillOval(coords[0] * largeur, coords[1] * hauteur, largeur, hauteur);
            gc.setFill(Color.YELLOW);
            gc.fillOval( 70,15  ,20,20);
        }

        // Dessine les entités présentes sur la case
        for (Entite entite : laby.getEntites()) {
            gc.setFill(entite.getColor());
            int[] coords = entite.getPosition();
            gc.setFill(entite.getColor());
            gc.fillOval(coords[0] * largeur, coords[1] * hauteur, largeur, hauteur);
        }

        gc.setFill(Color.WHITE);
        gc.fillText("Pv : " + laby.getPerso().getVie(),30,30);



    }
}
