package commandes;

import Memento.Memento;
import UndoRedo.UndoRedoManager;

/**
 * Created by yoannlt on 29/11/14.
 */
public class CommandeRedo implements Commande {

    /**
     * Le manager d'Undo Redo.
     * Référence vers le manager.
     */
    private UndoRedoManager manager;

    /**
     * Constructeur de <i>CommandeRedo</i>
     *
     * @param manager
     */
    public CommandeRedo(UndoRedoManager manager){
        this.manager = manager;
    }

    /**
     * Appel de la méthode <i>redo()</i> sur le manager d'Undo Redo.
     *
     * @see UndoRedo.UndoRedoManager#redo()
     */
    @Override
    public void execute() {
        manager.redo();
    }

    @Override
    public Memento getMemento() {
        return null;
    }

    @Override
    public void setMemento(Memento memento) {

    }
}
