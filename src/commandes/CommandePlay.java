package commandes;

import Memento.*;

import Memento.Enregistreur;

/**
 * Created by Yoann on 15/11/2014.
 */
public class CommandePlay implements Commande {

    /**
     * L'enregistreur.
     * Référence vers l'enregistreur du memento (Caretaker).
     */
    private Enregistreur enregistreur;

    /**
     * Constructeur de <i>CommandePlay</i>
     *
     * @param enregistreur
     */
    public CommandePlay(Enregistreur enregistreur) {
        this.enregistreur = enregistreur;
    }

    /**
     * Appel de la méthode <i>play()</i> sur l'enregistreur.
     *
     * @see EnregistreurImpl
     */
    @Override
    public void execute() {
        enregistreur.play();
    }

    @Override
    public Memento getMemento() {
        return null;
    }

    @Override
    public void setMemento(Memento memento) {

    }
}
