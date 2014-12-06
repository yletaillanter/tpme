package UndoRedo;

import Moteur.MoteurEdition;
import Memento.*;
import Moteur.MoteurEditionImpl;

/**
 * Created by yoannlt on 29/11/14.
 */
public interface UndoRedoManager {
    void save();
    void undo();
    void redo();
}
