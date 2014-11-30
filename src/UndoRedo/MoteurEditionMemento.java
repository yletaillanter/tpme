package UndoRedo;

import Memento.Memento;
import Moteur.BufferImpl;
import Moteur.PressePapierImpl;
import Moteur.SelectionImpl;

/**
 * Created by Yoann on 30/11/2014.
 */
public class MoteurEditionMemento implements Memento {

    private SelectionImpl.SelectionMemento selectionMemento;
    private BufferImpl.BufferMemento bufferMemento;
    private PressePapierImpl.PressePapierMemento pressePapierMemento;


    public MoteurEditionMemento(SelectionImpl.SelectionMemento selectionMemento, BufferImpl.BufferMemento bufferMemento, PressePapierImpl.PressePapierMemento pressePapierMemento){
        this.selectionMemento = selectionMemento;
        this.bufferMemento = bufferMemento;
        this.pressePapierMemento = pressePapierMemento;
    }

    public void setSelectionMemento(SelectionImpl.SelectionMemento selectionMemento){
        this.selectionMemento = selectionMemento;
    }

    public SelectionImpl.SelectionMemento getSelectionMemento(){
        return selectionMemento;
    }

    public void setBufferMemento(BufferImpl.BufferMemento bufferMemento){
        this.bufferMemento = bufferMemento;
    }

    public BufferImpl.BufferMemento getBufferMemento(){
        return bufferMemento;
    }

    public void setPressePapierMemento(PressePapierImpl.PressePapierMemento pressePapierMemento){
        this.pressePapierMemento = pressePapierMemento;
    }

    public PressePapierImpl.PressePapierMemento getPressePapierMemento(){
        return pressePapierMemento;
    }
}
