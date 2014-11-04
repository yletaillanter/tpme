package commandes;

import Moteur.MoteurEdition;

import java.util.logging.Level;

/**
 * Created by Baptiste on 04/11/2014.
 */
public class CommandeSupprimerTexteGauche implements Commande {

    private MoteurEdition moteur;

    public CommandeSupprimerTexteGauche(MoteurEdition moteur) {

        this.moteur = moteur;
    }

    public void execute (){
        moteur.supprimerGauche();
        logger.log(Level.INFO,"CommandeSupprimerTexteGauche: Execute()");
    }
}
