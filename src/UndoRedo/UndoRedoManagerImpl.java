package UndoRedo;

import Moteur.MoteurEdition;
import Moteur.MoteurEditionImpl;

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
    private MoteurEdition moteur;

    public UndoRedoManagerImpl(MoteurEdition moteur){
        this.moteur = moteur;
        pileDeMemento = new Stack<MoteurEditionMemento>();
        pileDeMementoRedo = new Stack<MoteurEditionMemento>();
    }

    @Override
    public void save(MoteurEdition moteurEdition) {
        pileDeMemento.push(moteurEdition.getMemento());
        logger.log(Level.INFO,"Ajout d'un memento dans la pile");
    }

    @Override
    public void undo() {
        pileDeMementoRedo.push(moteur.getMemento());
        if(!pileDeMemento.isEmpty())
            moteur.setMemento(pileDeMemento.pop());
    }

    @Override
    public void redo() {

    }
}
