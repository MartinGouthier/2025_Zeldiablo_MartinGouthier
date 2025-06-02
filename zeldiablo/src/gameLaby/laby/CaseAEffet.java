package gameLaby.laby;

public class CaseAEffet {
    private int posx;
    private int posy;
    private String nomEffet = "Sans effet";

    public CaseAEffet(int x, int y) {
        this.posx = x;
        this.posy = y;
    }
    void activation(Entite e){
        System.out.println("La case à la position : " + posx+","+posy + " a été activée");
    }

    int[] getPosition(){
        return new int[]{posx, posy};
    }
}
