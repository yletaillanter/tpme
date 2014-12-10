package Memento;

import commandes.Commande;

/**
 * Created by Yoann on 15/11/2014.
 */
public class Couple {


    /**
     * La commande a sauvegarder
     */
    private Commande commande;

    /**
     * Le memento lié à la commande à sauvegarder
     */
    private Memento memento;

    /**
     * constructeur
     * @param memento
     * @param commande
     */
    public Couple(Memento memento, Commande commande) {
        this.memento = memento;
        this.commande = commande;
    }

    /**
     *  La commande
     * @return memento
     */
    public Memento getMemento() {
        return memento;
    }

    /**
     * Le memento
     * @return commande
     */
    public Commande getCommande() {
        return commande;
    }
}
