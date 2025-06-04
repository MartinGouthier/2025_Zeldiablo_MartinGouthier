package gameLaby.laby;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char VIDE = '.';
    public static final char MONSTRE_DEPLACEMENT_NUL = '1';
    public static final char MONSTRE_DEPLACEMENT_FAIBLE = '2';
    public static final char MONSTRE_DEPLACEMENT_MANHATTAN = '3';
    public static final char CASSEAEFFET = 'E';
    public static final char PIEGE = 'T';
    public static final char FANTOME_DEPLACEMENT_FAIBLE = 'f';
    public static final char FANTOME_DEPLACEMENT_MANHATTAN = 'F';
    public static final char AMULETTE = 'A';

    int[] positionDepart;
    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";
    private int nbColonnes, nbLignes;
    private Amulette amulette;


    /**
     * les murs du labyrinthe
     */
    public boolean[][] murs;

    /**
     * Liste des entités du labyrinthe
     */
    private ArrayList<Entite> entites;
    /**
     * Retourne la case suivante selon une action
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */

    /**
     * Liste des cases à effet
     */
    private ArrayList<CaseAEffet> caseEffets;

    /**
     * Methode renvoyant la case suivante à partir de coordonnées et de l'action souhaitée
     * @param x Coordonnée x
     * @param y Coordonnée y
     * @param action Deplacement souhaité
     * @return Tableau de coordonnée
     */
    public static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne
                y--;
                break;
            case BAS:
                // on descend une ligne
                y++;
                break;
            case DROITE:
                // on augmente colonne
                x++;
                break;
            case GAUCHE:
                // on augmente colonne
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        return new int[]{x, y};
    }

    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom) throws IOException {
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);
        // lecture nblignes
        this.nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        this.nbColonnes = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.murs = new boolean[nbColonnes][nbLignes];
        this.entites = new ArrayList<>();
        this.caseEffets = new ArrayList<>();

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.murs[colonne][numeroLigne] = true;
                        break;
                    case VIDE:
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case PJ:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute PJ
                        this.entites.addFirst(new Perso(colonne, numeroLigne));

                        positionDepart = new int[]{colonne, numeroLigne};
                        break;
                    case MONSTRE_DEPLACEMENT_NUL:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute entité
                        DeplacementNul dep = new DeplacementNul();
                        this.entites.add(new Monstre(colonne, numeroLigne, 5, dep));
                        break;
                    case MONSTRE_DEPLACEMENT_FAIBLE:
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute entité
                        DeplacementFaible depf = new DeplacementFaible();
                        this.entites.add(new Monstre(colonne, numeroLigne, 5, depf));
                        break;
                    case MONSTRE_DEPLACEMENT_MANHATTAN:
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute entité
                        DeplacementManhattan depm = new DeplacementManhattan();
                        this.entites.add(new Monstre(colonne, numeroLigne, 5, depm));
                        break;

                    case CASSEAEFFET:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute case
                        this.caseEffets.add(new CaseAEffet(colonne, numeroLigne));
                        break;
                    case FANTOME_DEPLACEMENT_FAIBLE:
                        DeplacementFaible depf2 = new DeplacementFaible();
                        this.entites.add(new Fantome(colonne, numeroLigne, 5, depf2));
                        break;
                    case FANTOME_DEPLACEMENT_MANHATTAN:
                        DeplacementManhattan depm2 = new DeplacementManhattan();
                        this.entites.add(new Fantome(colonne, numeroLigne, 5, depm2));

                    case PIEGE:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute case
                        this.caseEffets.add(new CasePiege(colonne, numeroLigne));
                        break;
                    case AMULETTE:
                        this.murs[colonne][numeroLigne] = false;
                        this.amulette = new Amulette(colonne,numeroLigne);
                        break;
                    default:
                        throw new Error("caractere inconnu " + c);
                }
            }

            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }

        // ferme fichier
        bfRead.close();
    }


    /**
     * deplace l'entité en fonction de l'action.
     * gere la collision avec les murs et les autres entités
     *
     * @param action une des actions possibles
     * @param e      Entite qui se déplace
     */
    public void deplacerManuel(String action, Entite e) {
        // case courante
        int[] courante = e.getPosition();

        // calcule case suivante
        int[] suivante = getSuivant(courante[0], courante[1], action);


        if (e.peutTraverser(action, this)) {
            e.deplacer(action);
            for (CaseAEffet casee : caseEffets) {
                if (casee.etrePresent(suivante[0], suivante[1])) {
                    casee.activation(e);
                }
            }
        }

    }


    // ##################################
    // GETTER
    // ##################################

    /**
     * return taille selon Y
     *
     * @return nombre ligne
     */
    public int getLengthY() {
        return murs[0].length;
    }

    /**
     * return taille selon X
     *
     * @return nombre colonne
     */
    public int getLength() {
        return murs.length;
    }

    /**
     * return mur en (i,j)
     *
     * @param x coordonnée x
     * @param y coordonnée y
     * @return Présence d'un mur
     */
    public boolean getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }

    /**
     * Getter Perso
     *
     * @return le personnage
     */
    public Perso getPerso() {
        return (Perso) this.entites.getFirst();
    }

    /**
     * Getter Amulette
     *
     * @return l'Amulette
     */
    public Amulette getAmulette() {
        return this.amulette;
    }

    /**
     * Getter Liste d'entité
     *
     * @return Liste d'entité
     */
    public ArrayList<Entite> getEntites() {
        return this.entites;
    }

    /**
     * Getter Liste de cases à effet
     *
     * @return Liste de cases à effets
     */
    public ArrayList<CaseAEffet> getCaseEffet() {
        return this.caseEffets;
    }

    /**
     * Methode contenant la condition de victoire
     * @return Victoire ou non
     */
    public boolean victoire() {
        return (this.getPerso().aAmulette() &&
                this.getPerso().etrePresent(positionDepart[0],positionDepart[1]));
    }

    public void enleverAmulette(){
        this.amulette = null;
    }
}