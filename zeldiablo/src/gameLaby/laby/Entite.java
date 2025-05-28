package gameLaby.laby;

public abstract class Entite {

    /**
     * position de l'entité
     */
    int x, y, vie;

    public Entite(int dx, int dy, int v) {
        this.x = dx;
        this.y = dy;
        this.vie = v;
    }

    /**
     * permet de savoir si l'entité est en x,y
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

    public void deplacer(String s){
        switch (s){
            case Labyrinthe.HAUT:
                this.x --;
                break;
            case Labyrinthe.BAS:
                this.x++;
                break;
            case Labyrinthe.DROITE:
                this.y++;
                break;
            case Labyrinthe.GAUCHE:
                this.y--;
                break;
        }
    }
}
