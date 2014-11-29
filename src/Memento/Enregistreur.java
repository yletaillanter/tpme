package Memento;

import commandes.Commande;

/**
 * Created by Yoann on 14/11/2014.
 */
public interface Enregistreur {
    void rec();

    void stop();

    void play();

    void clear();

    void save(Commande commande);
}
