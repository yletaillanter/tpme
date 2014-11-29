package commandes;

import Memento.*;

/**
 * Created by Yoann on 15/11/2014.
 */
public class CommandePlay implements Commande {


    private Enregistreur enregistreur;

    public CommandePlay(Enregistreur enregistreur) {
        this.enregistreur = enregistreur;
    }

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
