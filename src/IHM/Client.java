package IHM;

import Memento.Enregistreur;
import Memento.EnregistreurImpl;
import commandes.*;
import Moteur.MoteurEdition;
import Moteur.MoteurEditionImpl;


/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
class Client{
    private IHM ihm;
    private MoteurEdition moteur;
    private Enregistreur enregistreur;

    public static void main(String[] Args) {
        Client client = new Client();
        client.run();

    }

    private void run() {
        moteur = new MoteurEditionImpl();
        ihm = new IHMImpl();
        moteur.getBuffer().register(ihm);
        enregistreur = new EnregistreurImpl();
        this.configureCommand();

        /*
        ihm = new IHMJavaFX();
        ihm.launch(ihm.getClass());
        */
    }
    private void configureCommand() {
        ihm.addCommand(new CommandeCopierTexte(moteur,enregistreur), "Copy");
        ihm.addCommand(new CommandeCollerTexte(moteur,enregistreur), "Paste");
        ihm.addCommand(new CommandeCouperTexte(moteur,enregistreur), "Cut");
        ihm.addCommand(new CommandeInsererTexte(moteur,ihm,enregistreur), "Insert");
        ihm.addCommand(new CommandeSelectionnerTexte(moteur,ihm,enregistreur), "Select");
        ihm.addCommand(new CommandeSupprimerTexteDroite(moteur,enregistreur), "DeleteRight");
        ihm.addCommand(new CommandeSupprimerTexteGauche(moteur,enregistreur), "DeleteLeft");
        ihm.addCommand(new CommandeStart(enregistreur), "Start");
        ihm.addCommand(new CommandeStop(enregistreur), "Stop");
        ihm.addCommand(new CommandePlay(enregistreur), "Play");

    }
}
