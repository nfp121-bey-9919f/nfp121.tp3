package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un num√©ro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    /**
     * Constructeur avec parametre nombre elements
     */
    public Pile(int taille) {
        // traiter le cas <=0
        // a completer
        if(taille <= 0) taille = CAPACITE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    /**
     * Constructeur par default
     */
    public Pile() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    /**
     * Ajouter un objet o
     */
    public void empiler(Object o) throws PilePleineException {
        // a completer
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    /**
     * Enlever le dernier objet ajouter
     */
    public Object depiler() throws PileVideException {
        // a completer
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return this.zone[ptr];
    }

    /**
     * return le dernier objet ajouter
     */
    public Object sommet() throws PileVideException {
        // a completer
        if(estVide())
            throw new PileVideException();
        return this.zone[ptr-1];
    }

    /**
     * return la taille maximale de la pile
     */
    public int capacite() {
        // a completer
        return this.zone.length;
    }

    /**
     * return la taille courante de la pile
     */
    public int taille() {
        // a completer
        if(estVide()){
            ptr = 0;
        }
        return this.ptr;
    }

    /**
     * return true si pile est vide
     */
    public boolean estVide() {
        // a completer
        return this.ptr == 0;
    }

    /**
     * return true si pile est pleine
     */
    public boolean estPleine() {
        // a completer
        return this.ptr == this.zone.length;
    }

    /**
     * Deux piles sont Ègales si elles ont la mÍme taille, mÍme capacitÈ,
     * et les ÈlÈments contenus identiques.
     */
    public boolean equals(Object o) {

        if( this == o ){
            return true;
        }      
        if(!(o instanceof Pile)){
            return false;
        }
        Pile p = (Pile)o;

        if (p.taille() == this.taille() && p.capacite() == this.capacite()){
            boolean egal1 = false;
            for(int i = zone.length - 1; i >= 0; i--){
                Object oo = zone[i];
                boolean egal2 = false;
                for(int j = zone.length -1; j>= 0; j--){
                    if(oo == p.zone[i]){
                        egal2 = true;
                    }       
                }
                if(egal2){
                    egal1 = true;
                }else{
                    return false;
                }
            }
            return true;
        }                
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

   public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}