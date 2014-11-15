package commandes;

import Memento.Memento;

import java.util.logging.Logger;

/**
 * Interface qui définnit la méthodes <i>execute()</i> que les commandes concrètes doivent intégrer.
 *
 *  @author Yoann Le Taillanter
 */
public interface Commande {
    public void execute();
    public Memento getMemento();
    public void setMemento(Memento memento);
}
