package commandes;

import Moteur.*;
import IHM.*;

import java.util.logging.Level;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class CommandeInsererTexte implements Commande {

    private MoteurEdition moteur;
    private IHM ihm;

    public CommandeInsererTexte(MoteurEdition moteur, IHM ihm) {
        this.moteur = moteur;
        this.ihm = ihm;
    }

    public void execute(){
        moteur.inserer(ihm.getInputUser());
        logger.log(Level.INFO,"CommandeInsererTexte: Execute()");
    }
}
