package commandes;

import Moteur.MoteurEdition;
import IHM.*;

import java.util.logging.Level;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class CommandeSelectionnerTexte implements Commande {

    private MoteurEdition moteur;
    private IHM ihm;

    public CommandeSelectionnerTexte(MoteurEdition moteur,IHM ihm) {
        this.ihm = ihm;
        this.moteur = moteur;
    }

    public void execute() {
        moteur.selectionner(ihm.getDot(),ihm.getMark());
        //logger.log(Level.INFO,"CommandeSelectionnerTexte: Execute()");
    }
}
