package gameLaby.laby;

public class CasePiege extends CaseAEffet{

    private boolean decouvert;

    public CasePiege(int x, int y){
        super(x,y);
        decouvert = false;
    }

    public void activation(Entite e){
        e.modifierVie(-1);
        decouvert = true;
    }
}
