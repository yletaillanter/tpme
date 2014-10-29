package commandes;

import Moteur.MoteurEdition;

import java.util.logging.Level;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class CommandeCopierTexte implements Commande {

    private MoteurEdition moteur;

    public CommandeCopierTexte(MoteurEdition moteur) {

        this.moteur = moteur;
    }

    public void execute (){
        moteur.copier();
        logger.log(Level.INFO,"CommandeCopierTexte: Execute()");
    }
}
