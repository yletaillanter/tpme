package UndoRedo;

import Memento.*;
import Moteur.MoteurEdition;

import java.util.LinkedList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by yoannlt on 29/11/14.
 */
public class UndoRedoManagerImpl implements UndoRedoManager {

    private Stack<MoteurEditionMemento> pileDeMemento;
    private Stack<MoteurEditionMemento> pileDeMementoRedo;
    private boolean modeUndo;
    Logger logger = Logger.getLogger("UndoRedo.UndoRedoManagerImpl");
    private MoteurEdition moteur;

    /**
     *  Compteur d'action pour l'Undo/Redo
     */
    private int counter;

    public UndoRedoManagerImpl(MoteurEdition moteur){
        this.moteur = moteur;
        pileDeMemento = new Stack<MoteurEditionMemento>();
        pileDeMementoRedo = new Stack<MoteurEditionMemento>();
        modeUndo = false;
    }

    @Override
    public void save(MoteurEdition moteur) {
        if(isModeUndo()){
            clearStack(pileDeMementoRedo);
            setModeUndo(false);
        }
        if(pileDeMemento.size()==0){
            pileDeMemento.push(moteur.getInitialMemento());
            logger.log(Level.INFO, "Ajout d'un memento initial dans la liste");
        }
        else {
            pileDeMemento.push(moteur.getMemento());
            logger.log(Level.INFO, "Ajout d'un memento Moteur dans la pile");
        }
    }

    @Override
    public void undo() {

        //Sauvegarde de l'état actuel pour redo.
        pileDeMementoRedo.push(moteur.getMemento());
        if(!pileDeMemento.isEmpty()){
            moteur.setMemento(pileDeMemento.pop());
            setModeUndo(true);
            if(pileDeMemento.isEmpty()) { // Si la pile est vide on remet un mementoinitial (vide)
                pileDeMemento.push(moteur.getInitialMemento());

            }
        }

    }

    @Override
    public void redo() {
        pileDeMemento.push(moteur.getMemento());
        if(!pileDeMementoRedo.isEmpty()){
            moteur.setMemento(pileDeMementoRedo.pop()); logger.log(Level.INFO,"Appel du redo");
        }
        else{
            setModeUndo(false);
        }

    }

    public boolean isModeUndo() {
        return modeUndo;
    }

    public void setModeUndo(boolean modeUndo) {
        this.modeUndo = modeUndo;
    }

    public void clearStack(Stack stack){
        while(!stack.empty()){
            stack.pop();
        }
    }
}
