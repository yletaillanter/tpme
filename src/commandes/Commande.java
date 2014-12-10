package commandes;

import Memento.Memento;

import java.util.logging.Logger;

/**
 * Interface qui définnit la méthodes <i>execute()</i> que les commandes concrètes doivent intégrer.
 *
 * @author Yoann Le Taillanter
 */
public interface Commande {

    /**
     * execute l'action affecté à la commande
     */
    public void execute();

    /**
     * Permet d'obtenir le memento de la commande
     *
     * @return le memento correspondant à la commande
     */
    public Memento getMemento();

    /**
     * Restaure l'état du memento à la commande
     * @param memento : un memento correspondant au type de la commande
     */
    public void setMemento(Memento memento);
}
