package UndoRedo;

import Memento.*;
import Moteur.MoteurEdition;
import Moteur.MoteurEditionImpl;

import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by yoannlt on 29/11/14.
 */
public class UndoRedoManagerImpl implements UndoRedoManager {

    private Stack<MoteurEditionMemento> pileDeMemento;
    private Stack<MoteurEditionMemento> pileDeMementoRedo;
    Logger logger = Logger.getLogger("UndoRedo.UndoRedoManagerImpl");
    private ArrayList<Memento> listeCommande;
    private MoteurEdition moteur;

    /**
     *  Compteur d'action pour l'Undo/Redo
     */
    private int counter;

    public UndoRedoManagerImpl(MoteurEdition moteur){
        this.moteur = moteur;
        pileDeMemento = new Stack<MoteurEditionMemento>();
        pileDeMementoRedo = new Stack<MoteurEditionMemento>();
        listeCommande = new ArrayList<Memento>();
        counter = 0;
    }

    @Override
    public void save(MoteurEdition moteurEdition, Memento memento) {
        counter++;
        if(counter%5 == 0 ) { // sauvegarde du moteur complet
            if(pileDeMemento.size()==0){
                pileDeMemento.push(moteurEdition.getInitialMemento());
                logger.log(Level.INFO, "Ajout d'un memento Moteur initial dans la pile");
            }
            else {
                pileDeMemento.push(moteurEdition.getMemento());
                logger.log(Level.INFO, "Ajout d'un memento Moteur dans la pile");
            }
        }
        else{ // sauvegarde de l'action
            listeCommande.add(memento);
            logger.log(Level.INFO, "Ajout d'un memento Commande dans la liste");
        }

    }

    @Override
    public void undo() {
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
