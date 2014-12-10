package UndoRedo;

import Moteur.MoteurEdition;
import Memento.*;
import Moteur.MoteurEditionImpl;

/**
 * Created by yoannlt on 29/11/14.
 */
public interface UndoRedoManager {
    /**
     * sauvegarde le memento
     */
    void save();

    /**
     * défaire l'action précédente pour revenir à l'ancienne état
     */
    void undo();

    /**
     * refaire l'action si elle vient d'être défaite.
     */
    void redo();
}
