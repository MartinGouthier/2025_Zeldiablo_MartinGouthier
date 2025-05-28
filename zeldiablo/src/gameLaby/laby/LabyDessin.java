package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;


public class LabyDessin implements DessinJeu {
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {


        if (jeu.etreFini()) {this.ecranFin(jeu, canvas);}
        else {this.jeuFonctionnel(jeu, canvas);}

    }

    public void ecranFin(Jeu jeu, Canvas canvas) {
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        // Fond noir
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Texte à afficher
        String message = "Vous avez perdu !";
        javafx.scene.text.Font font = javafx.scene.text.Font.font("Arial", 40);
        gc.setFont(font);
        gc.setFill(Color.RED);

        // Utilisation de javafx.scene.text.Text pour mesurer le texte
        javafx.scene.text.Text text = new javafx.scene.text.Text(message);
        text.setFont(font);
        double textWidth = text.getLayoutBounds().getWidth();
        double textHeight = text.getLayoutBounds().getHeight();

        double x = (canvas.getWidth() - textWidth) / 2;
        double y = (canvas.getHeight() - textHeight) / 2 + textHeight;

        gc.fillText(message, x, y);
    }



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
                if (laby.getMur(i, j)) {
                    gc.setFill(Color.BLACK);
                } else {
                    gc.setFill(Color.WHITE);
                }
                gc.fillRect(i * largeur, j * hauteur, largeur, hauteur);
                if (laby.pj.etrePresent(i, j)) {
                    gc.setFill(Color.RED);
                    gc.fillOval(i * largeur, j * hauteur, largeur, hauteur);
                }

            }
        }
    }
}
