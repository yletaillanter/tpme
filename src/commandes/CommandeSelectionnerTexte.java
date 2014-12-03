package commandes;

import Memento.Enregistreur;
import Memento.Memento;
import Moteur.MoteurEdition;
import IHM.*;

import java.util.Optional;
import java.util.logging.Level;

/**
 * <b>CommandeSelectionnerTexte</b> est la classe qui définit la commande concrète <i>séléctionner</i>.
 *
 * @author Yoann Le Taillanter
 * @see commandes.Commande
 */
public class CommandeSelectionnerTexte implements Commande {

    /**
     * Le moteur d'édition.
     * Référence vers le moteur d'édition du mini-éditeur.
     *
     * @see Moteur.MoteurEdition
     */
    private MoteurEdition moteur;

    /**
     * l'ihm.
     * Référence vers l'IHM du mini-éditeur
     *
     * @see Moteur.MoteurEdition
     */
    private IHM ihm;

    /**
     * L'enregistreur.
     * Référence vers l'enregistreur du memento (Caretaker).
     */
    private Enregistreur enregistreur;

    int dot;

    int mark;


    /**
     * Constructeur de <i>CommandeSelectionnerTexte</i>
     *
     * @param moteur Le moteur du mini-éditeur
     * @param ihm    L'IHM du mini-éditeur
     */
    public CommandeSelectionnerTexte(MoteurEdition moteur, IHM ihm, Enregistreur enregistreur) {
        this.ihm = ihm;
        this.moteur = moteur;
        this.enregistreur = enregistreur;
    }



    public int getDot() {
        return dot;
    }

    public void setDot(int dot) {
        this.dot = dot;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    boolean test;



    /**
     * Appel de la méthode <i>selectionner</i> sur le moteur.
     * <p>
     * La commande insérer à besoin du début et de la fin de la séléction,
     * qui sont les méthodes getDot() et getMark() de l'IHM.
     * </p>
     *
     * @see Moteur.MoteurEditionImpl
     * @see Moteur.MoteurEditionImpl#selectionner(int, int)
     */
    public void execute() {
        if(!test){ // si mode memento
            dot = ihm.getDot();
            mark = ihm.getMark();
        }
        test=false;
        moteur.selectionner(dot,mark);
        enregistreur.save(this);
    }

    @Override
    public Memento getMemento() {
        return new MementoSelection(dot,mark);
    }

    @Override
    public void setMemento(Memento memento) {
        MementoSelection mementoSelection = (MementoSelection) memento;
        dot = mementoSelection.getDot();
        mark = mementoSelection.getMark();
        test = true;
    }

    private class MementoSelection implements Memento {

        private int dot;
        private int mark;

        public MementoSelection(int dot, int mark) {
            this.dot = dot;
            this.mark = mark;
        }

        public int getDot() {
            return dot;
        }

        public void setDot(int dot) {
            this.dot = dot;
        }

        public int getMark() {
            return mark;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }
    }
}
