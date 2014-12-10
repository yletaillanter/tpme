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

    /**
     * Constructeur.
     * Instancie l'ArrayList déstiné à contenir les couple commande/memento
     */
    public EnregistreurImpl() {
        this.listMementos = new ArrayList<Couple>();
    }

    /**
     * Lors d'un clic sur "enregistrement" l'ancien scénario de commande est effacé.
     * le boolean rec est mis à "true"
     */
    @Override
    public void rec() {
        listMementos.clear();
        setRec(true);
        //logger.log(Level.INFO, "rec is called");
    }

    /**
     * le boolean rec est mis à "false"
     */
    @Override
    public void stop() {
        setRec(false);
        //logger.log(Level.INFO, "stop is called");
    }

    /**
     * Si rec est toujours à true on le passe a faux.
     *
     *<p>Un iterator parcour l'Arraylist des couple et restaure l'état de chaque commande depuis son memento
     * respectif. Puis appel de la fonction execute pour rejouer l'action.</p>
     */
    @Override
    public void play() {
        if (isRec())
            setRec(false);

        Iterator<Couple> it = listMementos.iterator();

        while (it.hasNext()) {
            Couple couple = it.next();
            couple.getCommande().setMemento(couple.getMemento());
            couple.getCommande().execute();
            //System.err.print("Play execute() ");
        }
    }

    /**
     * vidage de l'ArrayList
     */
    @Override
    public void clear() {
        listMementos.clear();
    }

    /**
     * Permet d'enregistrer les actions que fais l'utilisateur
     * si l'utilisateur a lancé le mode enregistrement (rec = true) on enregistre son action, sinon on ne fait rien.
     *
     * @param commande : la commande à sauvegarder
     */
    @Override
    public void save(Commande commande) {
        if (isRec()) {
            this.listMementos.add(new Couple(commande.getMemento(), commande));
        }
    }

    /*
    @return l'état du boolean rec.
     */
    public boolean isRec() {
        return rec;
    }

    /**
     * permet de définir l'état du boolean
     * @param rec
     */
    public void setRec(boolean rec) {
        this.rec = rec;
    }
}
