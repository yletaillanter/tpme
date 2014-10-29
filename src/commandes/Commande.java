package commandes;

import java.util.logging.Logger;

/**
 * Created by Yoann Le Taillanter on 21/10/2014.
 */
public interface Commande {
    Logger logger = Logger.getLogger("tpme.commandes");
    public void execute();
}
