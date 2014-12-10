package commandes;

import Memento.*;

/**
 * Created by Yoann on 15/11/2014.
 */
public class CommandeStop implements Commande {

    /**
     * L'enregistreur.
     * Référence vers l'enregistreur du memento (Caretaker).
     */
    private Enregistreur enregistreur;

    /**
     * Constructeur de <i>CommandeStop</i>
     *
     * @param enregistreur
     */
    public CommandeStop(Enregistreur enregistreur) {
        this.enregistreur = enregistreur;
    }

    /**
     * Appel de la méthode <i>stop()</i> sur l'enregistreur.
     *
     * @see EnregistreurImpl
     */
    @Override
    public void execute() {
        enregistreur.stop();
    }

    @Override
    public Memento getMemento() {
        return null;
    }

    @Override
    public void setMemento(Memento memento) {

    }
}
