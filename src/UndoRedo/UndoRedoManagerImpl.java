package UndoRedo;

import Moteur.MoteurEdition;
import Moteur.MoteurEditionImpl;

import java.util.Stack;

/**
 * Created by yoannlt on 29/11/14.
 */
public class UndoRedoManagerImpl implements UndoRedoManager {

    private Stack<MoteurEditionImpl.MoteurEditionMemento> pileDeMemento;

    public UndoRedoManagerImpl(){
        pileDeMemento = new Stack<MoteurEditionImpl.MoteurEditionMemento>();
    }

    @Override
    public void save(MoteurEdition moteurEdition) {
        pileDeMemento.push(moteurEdition.getMemento());
    }
}
