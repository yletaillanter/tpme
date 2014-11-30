package commandes;

import Memento.Memento;
import UndoRedo.UndoRedoManager;

/**
 * Created by yoannlt on 29/11/14.
 */
public class CommandeRedo implements Commande {

    private UndoRedoManager manager;

    public CommandeRedo(UndoRedoManager manager){
        this.manager = manager;
    }

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
