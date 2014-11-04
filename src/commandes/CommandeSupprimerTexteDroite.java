package commandes;

import Moteur.MoteurEdition;

import java.util.logging.Level;

/**
 * Created by Baptiste on 04/11/2014.
 */
public class CommandeSupprimerTexteDroite implements Commande {

    private MoteurEdition moteur;

    public CommandeSupprimerTexteDroite(MoteurEdition moteur) {

        this.moteur = moteur;
    }

    public void execute (){
        moteur.supprimerDroite();
        logger.log(Level.INFO,"CommandeSupprimerTexteDroite: Execute()");
    }
}
