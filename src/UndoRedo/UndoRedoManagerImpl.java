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
    Logger logger = Logger.getLogger("UndoRedo.UndoRedoManagerImpl");

    public UndoRedoManagerImpl(){
        pileDeMemento = new Stack<MoteurEditionMemento>();
    }

    @Override
    public void save(MoteurEdition moteurEdition) {
        pileDeMemento.push(moteurEdition.getMemento());
        logger.log(Level.INFO,"Ajout d'un memento dans la pile");
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
