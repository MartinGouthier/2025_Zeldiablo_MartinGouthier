package gameLaby.laby;

/**
 * Classe représentant une case à piège
 */
public class CasePiege extends CaseAEffet{
    /**
     * Etat de découverte du piège
     */
    private boolean decouvert;

    /**
     * Constructeur du pi-ège
     * @param x coordonnée x
     * @param y coordonnée y
     */
    public CasePiege(int x, int y){
        super(x,y);
        decouvert = false;
    }

    /**
     * Methode d'activation de l'effet du piège
     * @param e Entite affecté
     */
    @Override
    public void activation(Entite e){
        e.modifierVie(-1);
        decouvert = true;
        super.activation(e);
        System.out.println(e + " est tombé dans un piège, -1 point de vie");
    }


    /**
     * Renvoit l'état de découverte du piège
     * @return
     */
    @Override
    public boolean getDecouvert(){
        return decouvert;
    }
}
