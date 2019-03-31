package question1;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer par votre classe Pile .
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile {
    public final static int TAILLE_PAR_DEFAUT = 5;

    private Object[] zone;
    private int ptr;

    /**
     * à compléter
     * Constructeur avec parametre nombre elements
     */
    public Pile(int taille) {
        if (taille < 0)
            taille = TAILLE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    /**
     * Constructeur par default
     */
    public Pile() {
        this(TAILLE_PAR_DEFAUT);
    }

    /**
     * Ajouter un objet o
     */
    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    /**
     * Enlever le dernier objet ajouter
     */
    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    /**
     * return true si pile est vide
     */
    public boolean estVide() {
        return ptr == 0;
    }

    /**
     * return true si pile est pleine
     */
    public boolean estPleine() {
        return ptr == zone.length;
    }

    /**
     * Afficher le contenue de la pile
     */
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