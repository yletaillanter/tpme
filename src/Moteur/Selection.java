package Moteur;

import Memento.Memento;
import UndoRedo.MoteurEditionMemento;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public interface Selection {

    /**
     * Permet de récupérer la position de début de la sélection
     *
     * @return debut de séléction
     */
    public int getDebut();

    /**
     * Permet de définir la position de début de la sélection
     *
     * @param debut
     */
    public void setDebut(int debut);

    /**
     * Permet de récupérer la position de fin de la sélection
     *
     * @return fin de séléction
     */
    public int getFin();

    /**
     * Permet de définir la position de fin de la sélection
     *
     * @param fin
     */
    public void setFin(int fin);

    public SelectionImpl.SelectionMemento getMemento();
    public void setMemento(SelectionImpl.SelectionMemento memento);
}
