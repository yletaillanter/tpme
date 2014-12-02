package UndoRedo;

import Memento.*;
import Moteur.MoteurEdition;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by yoannlt on 29/11/14.
 */
public class UndoRedoManagerImpl implements UndoRedoManager {

    //private Stack<MoteurEditionMemento> pileDeMemento;
    //private Stack<MoteurEditionMemento> pileDeMementoRedo;

    Logger logger = Logger.getLogger("UndoRedo.UndoRedoManagerImpl");
    private LinkedList<Memento> listeCommande;
    private MoteurEdition moteur;
    int indiceListe;

    /**
     *  Compteur d'action pour l'Undo/Redo
     */
    private int counter;

    public UndoRedoManagerImpl(MoteurEdition moteur){
        this.moteur = moteur;
        //pileDeMemento = new Stack<MoteurEditionMemento>();
        //pileDeMementoRedo = new Stack<MoteurEditionMemento>();
        listeCommande = new LinkedList<Memento>();
        //listeCommande.add(moteur.getInitialMemento());
        counter = -1;
    }

    @Override
    public void save(MoteurEdition moteur, Memento memento) {
        counter++;
        if(counter%5 == 0 ){
            listeCommande.add(moteur.getMemento());
            logger.log(Level.INFO, "Ajout d'un memento Moteur dans la liste");
        }
        else{
            listeCommande.add(memento);
            logger.log(Level.INFO, "Ajout d'un memento commande dans la liste");
        }
        indiceListe = listeCommande.size();


        /*
        counter++;
        if(counter%5 == 0 ) { // sauvegarde du moteur complet
            if(listeCommande.size()==0){
                listeCommande.add(moteurEdition.getInitialMemento());
                logger.log(Level.INFO, "Ajout d'un memento Moteur initial dans la liste");
            }
            else {
                listeCommande.add(moteurEdition.getMemento());
                logger.log(Level.INFO, "Ajout d'un memento Moteur dans la pile");
            }
        }
        else{ // sauvegarde de l'action
            listeCommande.add(memento);
            logger.log(Level.INFO, "Ajout d'un memento Commande dans la liste");

        }
*/
    }

    @Override
    public void undo() {

        //logger.log(Level.INFO, ""+ listeCommande.);
        if(indiceListe < listeCommande.size())
            if(listeCommande.size() % 5 == 0){
                indiceListe = (Math.abs(listeCommande.size() / 5)*5)-5; // -5 sinon dernier état identique
            }
            else
                indiceListe = (Math.abs(listeCommande.size() / 5)*5);

            try {
                moteur.setMemento((MoteurEditionMemento)listeCommande.get(indiceListe));
            } catch (Exception e) {
                e.printStackTrace();
            }

        /*
        //Sauvegarde de l'état actuel si redo.
        pileDeMementoRedo.push(moteur.getMemento());
        if(!pileDeMemento.isEmpty()){
            moteur.setMemento(pileDeMemento.pop());
            if(pileDeMemento.isEmpty()) { // Si la pile est vide on remet un mementoinitial (vide)
                pileDeMemento.push(moteur.getInitialMemento());
            }
        }
        for(int i = Math.abs(listeCommande.size() / 5)*5; i<listeCommande.size()%5;i++){
            MementoInserer commandeMemento = listeCommande.get(i);
            commandeMemento.
        }
        */

    }

    @Override
    public void redo() {/*
        pileDeMemento.push(moteur.getMemento());
        logger.log(Level.INFO,"Appel du redo");
        if(!pileDeMementoRedo.isEmpty())
            moteur.setMemento(pileDeMemento.pop());
    */
    }
}
