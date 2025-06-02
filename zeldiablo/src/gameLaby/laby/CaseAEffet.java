package gameLaby.laby;

public class CaseAEffet {
    int posx;
    int posy;
    String nomEffet = "Sans effet";

    void activation(){
        System.out.println("La case à la position : " + posx+","+posy + " a été activée");
    }

    int[] getPosition(){
        return new int[]{posx, posy};
    }
}
