package Memento;

import commandes.Commande;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Yoann on 15/11/2014.
 */
public class EnregistreurImpl implements Enregistreur {

    private List<Memento> listMemento;
    public boolean rec;
    Logger logger = Logger.getLogger("tpme.Memento.EnregistreurImpl");

    public EnregistreurImpl() {
        this.listMemento = new ArrayList<Memento>();
    }

    @Override
    public void rec() {
        setRec(true);
        logger.log(Level.INFO,"rec is called");
    }

    @Override
    public void stop() {
        setRec(false);
        logger.log(Level.INFO,"stop is called");
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
