package commandes;

import java.util.logging.Logger;

/**
 * Interface qui définnit la méthodes <i>execute()</i> que les commandes concrètes doivent intégrer.
 *
 *  @author Yoann Le Taillanter
 */
public interface Commande {
    public void execute();
}
