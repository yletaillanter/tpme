package UndoRedo;

import Memento.Memento;

/**
 * Created by Yoann on 30/11/2014.
 */
public class MoteurEditionMemento implements Memento {

    private Memento selectionMemento;
    private Memento bufferMemento;
    private Memento pressePapierMemento;


    public MoteurEditionMemento(Memento selectionMemento, Memento bufferMemento, Memento pressePapierMemento){
        this.selectionMemento = selectionMemento;
        this.bufferMemento = bufferMemento;
        this.pressePapierMemento = pressePapierMemento;
    }

    public void setSelectionMemento(Memento selectionMemento){
        this.selectionMemento = selectionMemento;
    }

    public void setBufferMemento(Memento bufferMemento){
        this.bufferMemento = bufferMemento;
    }

    public void setPressePapierMemento(Memento pressePapierMemento){
        this.pressePapierMemento = pressePapierMemento;
    }
}
