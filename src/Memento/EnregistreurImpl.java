package Memento;

import commandes.Commande;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yoann on 15/11/2014.
 */
public class EnregistreurImpl implements Enregistreur {

    private List<Memento> listMemento;
    public boolean rec;

    public EnregistreurImpl() {
        this.listMemento = new ArrayList<Memento>();
    }

    @Override
    public void rec() {
        setRec(true);
    }

    @Override
    public void stop() {
        setRec(false);
    }

    @Override
    public void play() {
        for(Memento memento : listMemento){
            //executer l'action
        }
    }

    @Override
    public void clear() {
        listMemento.clear();
    }

    @Override
    public void save(Commande commande) {
        if(isRec())
            this.listMemento.add(commande.getMemento());
    }

    public boolean isRec() {
        return rec;
    }

    public void setRec(boolean rec) {
        this.rec = rec;
    }
}
