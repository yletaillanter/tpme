package commandes;

import Moteur.MoteurEdition;

/**
 * Created by 14007427 on 22/10/2014.
 */
public class CommandeCopierTexte implements Commande {

    private MoteurEdition moteur;

    public CommandeCopierTexte(MoteurEdition m) {

        this.moteur = m;
    }

    public void execute (){

        moteur.copier();
    }
}
