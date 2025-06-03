package gameLaby.laby;


/**
 * Classe représantant une entité du labyrinthe
 */
public abstract class Entite extends Element {

    /**
     * Vie de l'entité
     */
    private int vie;

    /**
     * Constructeur entité
     * @param x Position x
     * @param y Position y
     * @param v Vie
     */
    public Entite(int x, int y, int v) {
        super(x,y);
        this.vie = v;
    }
    // ############################################
    // GETTER
    // ############################################

    /**
     * @return vie de l'entité
     */
    public int getVie() {
        return this.vie;
    }

    /**
     * Methode indiquant si l'entité est en vie
     * @return boolean indiquant si le perso est en vie
     */
    public boolean estVivant(){
        return this.vie>0;
    }

    /**
     * Ajoute ou retire de la vie à l'entité
     * @param i va etre incrémenter a vie (peut etre négatif)
     */
    public void modifierVie(int i){
        this.vie+=i;
    }

    /**
     * Modifie les coordonnées en fonction de la direction dir
     * @param dir Direction
     */
    public void deplacer(String dir){
        switch (dir){
            case Labyrinthe.HAUT:
                this.bougerY(-1);
                break;
            case Labyrinthe.BAS:
                this.bougerY(1);
                break;
            case Labyrinthe.DROITE:
                this.bougerX(1);
                break;
            case Labyrinthe.GAUCHE:
                this.bougerX(-1);
                break;
        }
    }

    /**
     * Methode d'affichage du type d'entité
     * @return Type d'entité
     */
    public abstract String toString();
}
