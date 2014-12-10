package commandes;

import Memento.*;

/**
 * Created by Yoann on 15/11/2014.
 */
public class CommandeStart implements Commande {

    /**
     * L'enregistreur.
     * Référence vers l'enregistreur du memento (Caretaker).
     */
    private Enregistreur enregistreur;


    /**
     * Constructeur de <i>CommandeStart</i>
     *
     * @param enregistreur
     */
    public CommandeStart(Enregistreur enregistreur) {
        this.enregistreur = enregistreur;
    }

    /**
     * Appel de la méthode <i>rec()</i> sur l'enregistreur.
     *
     * @see EnregistreurImpl
     */
    @Override
    public void execute() {
        enregistreur.rec();
    }

    @Override
    public Memento getMemento() {
        return null;
    }

    @Override
    public void setMemento(Memento memento) {
    }
}

