package gameLaby.laby;

/**
 * Classe représantant une entité du labyrinthe
 */
public abstract class Entite {

    /**
     * Position x de l'entité
     */
    private int x;
    /**
     * Position y de l'entité
     */
    private int y;
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
        this.x = x;
        this.y = y;
        this.vie = v;
    }

    /**
     * permet de savoir si l'entité est en x,y
     *
     * @param x position testee
     * @param y position testee
     * @return true si le personnage est bien en (dx,dy)
     */
    public boolean etrePresent(int x, int y) {

        return (this.x == x && this.y == y);
    }

    // ############################################
    // GETTER
    // ############################################

    /**
     * @return position x de l'entité
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y de l'entité
     */
    public int getY() {
        //getter
        return this.y;
    }
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
                this.y --;
                break;
            case Labyrinthe.BAS:
                this.y++;
                break;
            case Labyrinthe.DROITE:
                this.x++;
                break;
            case Labyrinthe.GAUCHE:
                this.x--;
                break;
        }
    }
}
