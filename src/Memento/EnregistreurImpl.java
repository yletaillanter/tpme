package Memento;

import commandes.Commande;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Yoann on 15/11/2014.
 */
public class EnregistreurImpl implements Enregistreur {

    private List<Couple> listMementos;
    private boolean rec;
    private Logger logger = Logger.getLogger("tpme.Memento.EnregistreurImpl");

    public EnregistreurImpl() {
        this.listMementos = new ArrayList<Couple>();
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
        if(isRec())
            setRec(false);

        Iterator<Couple> it = listMementos.iterator();

        while(it.hasNext()){
            Couple couple = it.next();
            couple.getCommande().setMemento(couple.getMemento());
            couple.getCommande().execute();
            System.err.print("Play execute() ");
        }
    }

    @Override
    public void clear() {
        listMementos.clear();
    }

    @Override
    public void save(Commande commande) {
        if(isRec()){
            this.listMementos.add(new Couple(commande.getMemento(), commande));
        }
    }

    public boolean isRec() {
        return rec;
    }

    public void setRec(boolean rec) {
        this.rec = rec;
    }
}
