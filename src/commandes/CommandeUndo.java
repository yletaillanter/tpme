package commandes;

import Memento.Memento;
import UndoRedo.UndoRedoManager;

/**
 * Created by yoannlt on 29/11/14.
 */
public class CommandeUndo implements Commande {


    /**
     * Le manager d'Undo Redo.
     * Référence vers le manager.
     */
    private UndoRedoManager manager;

    /**
     * Constructeur de <i>CommandeUndo</i>
     *
     * @param manager
     */
    public CommandeUndo(UndoRedoManager manager){
        this.manager = manager;
    }


    /**
     * Appel de la méthode <i>undo()</i> sur le manager d'Undo Redo.
     *
     * @see UndoRedo.UndoRedoManager#undo()
     */
    @Override
    public void execute() {
        manager.undo();
    }

    @Override
    public Memento getMemento() {
        return null;
    }

    @Override
    public void setMemento(Memento memento) {

    }
}
