package commandes;

import Memento.*;

/**
 * Created by Yoann on 15/11/2014.
 */
public class CommandeStart implements Commande {

    private Enregistreur enregistreur;

    public CommandeStart(Enregistreur enregistreur) {
        this.enregistreur = enregistreur;
    }

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

