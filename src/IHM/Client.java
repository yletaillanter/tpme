package IHM;

import commandes.*;
import Moteur.MoteurEdition;
import Moteur.MoteurEditionImpl;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
class Client{
    public IHMImpl ihm;
    MoteurEdition moteur;

    public static void main(String[] Args) {
        Client client = new Client();
        client.run();

    }

    private void run() {
        moteur = new MoteurEditionImpl();
        ihm = new IHMImpl();
        moteur.getBuffer().register(ihm);
        this.configureCommand();

        /*
        ihm = new IHMJavaFX();
        ihm.launch(ihm.getClass());
        */
    }
    private void configureCommand() {
        ihm.addCommand(new CommandeCopierTexte(moteur), "Copy");
        ihm.addCommand(new CommandeCollerTexte(moteur), "Paste");
        ihm.addCommand(new CommandeCouperTexte(moteur), "Cut");
        ihm.addCommand(new CommandeInsererTexte(moteur,ihm), "Insert");
        ihm.addCommand(new CommandeSelectionnerTexte(moteur,ihm), "Select");
    }
}
