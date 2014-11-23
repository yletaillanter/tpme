package Memento;

import commandes.Commande;

/**
 * Created by Yoann on 15/11/2014.
 */
public class Couple {

    private Memento memento;
    private Commande commande;

    public Couple(Memento memento, Commande commande) {
        this.memento = memento;
        this.commande = commande;
    }

    public Memento getMemento() {
        return memento;
    }

    public Commande getCommande() {
        return commande;
    }
}
