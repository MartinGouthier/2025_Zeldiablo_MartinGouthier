package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;


public class LabyDessin implements DessinJeu {
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu lj = (LabyJeu) jeu;
        Labyrinthe laby = lj.getLabyrinthe();

        final GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int nbrColonne = laby.getLength();
        int nbrLigne = laby.getLengthY();
        int largeur = (int) (canvas.getWidth()/nbrColonne);
        int hauteur = (int) (canvas.getHeight()/nbrLigne);

        for (int i=0;i<nbrColonne;i++){

            for (int j = 0;j<nbrLigne;j++){
                if (laby.getMur(i,j)){
                    gc.setFill(Color.BLACK);
                } else{
                    gc.setFill(Color.WHITE);
                }
                gc.fillRect(i*largeur,j*hauteur,largeur,hauteur);
                if (laby.pj.etrePresent(i,j)){
                    gc.setFill(Color.RED);
                    gc.fillOval(i*largeur,j*hauteur,largeur,hauteur);
                }

            }

        }
    }
}
