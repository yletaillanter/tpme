package commandes;

import Moteur.MoteurEdition;

import java.util.logging.Level;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class CommandeCollerTexte implements Commande {

    private MoteurEdition moteur;

    public CommandeCollerTexte(MoteurEdition moteur) {

        this.moteur = moteur;
    }

    public void execute() {
        moteur.coller();
        logger.log(Level.INFO,"CommandeCollerTexte: Execute()");
    }
}
