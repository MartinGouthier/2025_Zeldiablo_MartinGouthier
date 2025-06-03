package gameLaby.laby;

import javafx.scene.paint.Color;

public abstract class Element {
    private int x;
    private int y;

    public Element(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int[] getPosition(){
        return new int[]{x, y};
    }


    public void bougerX(int x){
        this.x += x;
    }

    public void bougerY(int y){
        this.y += y;
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

    public abstract Color getColor();
}
