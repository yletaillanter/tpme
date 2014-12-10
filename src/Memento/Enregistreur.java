package Memento;

import commandes.Commande;

/**
 * Created by Yoann on 14/11/2014.
 */
public interface Enregistreur {

    /**
     * Active le mode enregistrement de l'enregistreur.
     *
     */
    void rec();

    /**
     * Désactive le mode enregistrement de l'enregistreur.
     *
     */
    void stop();

    /**
     * Lance la lecture des commande enregistré précédement par l'enregistreur
     *
     */
    void play();

    /**
     * vide la liste.
     */
    void clear();

    /**
     * Sauvegarde la commande et son memento dans la liste
     * @param commande : la commande à sauvegarder
     */
    void save(Commande commande);
}
