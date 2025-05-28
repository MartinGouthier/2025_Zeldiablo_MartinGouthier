package gameLaby.laby;


/**
 * gere un personnage situe en x,y
 */
public class Perso {

    /**
     * position du personnage
     */
    int x, y;
    int vie;


    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Perso(int dx, int dy) {
        this.x = dx;
        this.y = dy;
        this.vie = 5;
    }

    public Perso(int dx, int dy, int v) {
        this.x = dx;
        this.y = dy;
        this.vie = v;
    }

    /**
     * permet de savoir si le personnage est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le personnage est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {

        return (this.x == dx && this.y == dy);
    }

    // ############################################
    // GETTER
    // ############################################

    /**
     * @return position x du personnage
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y du personnage
     */
    public int getY() {
        //getter
        return this.y;
    }
    /**
     * @return vie du perssonnage
     */
    public int getVie() {
        return this.vie;
    }

    /**
     *
     * @return boolean indiquant si le perso est en vie
     */
    public boolean estVivant(){
        return this.vie>0;
    }

    /**
     *
     * @param i va etre incérementer a vie (peut etre négatif)
     */
    public void modifierVie(int i){
        this.vie+=i;
    }
}
