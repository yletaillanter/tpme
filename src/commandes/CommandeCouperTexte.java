package commandes;

import Moteur.MoteurEdition;

import java.util.logging.Level;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class CommandeCouperTexte implements Commande {

    private MoteurEdition moteur;

    public CommandeCouperTexte(MoteurEdition moteur) {

        this.moteur = moteur;
    }

    public void execute (){
        moteur.couper();
        //logger.log(Level.INFO,"CommandeCouperTexte: Execute()");
    }
}
