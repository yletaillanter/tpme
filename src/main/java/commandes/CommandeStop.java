package commandes;

import Memento.*;

/**
 * Created by Yoann on 15/11/2014.
 */
public class CommandeStop implements Commande {

    private Enregistreur enregistreur;

    public CommandeStop(Enregistreur enregistreur) {
        this.enregistreur = enregistreur;
    }

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
