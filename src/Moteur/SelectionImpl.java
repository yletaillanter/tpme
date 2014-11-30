package Moteur;

import Memento.Memento;
import UndoRedo.MoteurEditionMemento;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class SelectionImpl implements Selection {

    /**
     * début de la sélection
     */
    private int debut;

    /**
     * fin de la sélection
     */
    private int fin;


    /**
     * Constructeur de la SelectionImpl.
     * <p/>
     * debut et fin sont initialisé à 0.
     */
    public SelectionImpl() {
        this.debut = 0;
        this.fin = 0;
    }

    //******* Getters and setters ***********

    /**
     * Permet de récupérer la position de début de la sélection
     *
     * @return debut de séléction
     */
    @Override
    public int getDebut() {
        return this.debut;
    }

    /**
     * Permet de définir la position de début de la sélection
     *
     * @param debut
     */
    @Override
    public void setDebut(int debut) {
        if (debut < 0)
            throw new IllegalArgumentException("can't be < 0");
        this.debut = debut;
    }

    /**
     * Permet de récupérer la position de fin de la sélection
     *
     * @return fin de séléction
     */
    @Override
    public int getFin() {
        return this.fin;
    }

    /**
     * Permet de définir la position de fin de la sélection
     *
     * @param fin
     */
    @Override
    public void setFin(int fin) {
        if (fin < 0)
            throw new IllegalArgumentException("can't be < 0");
        this.fin = fin;
    }

    @Override
    public SelectionMemento getMemento() {
        return new SelectionMemento(debut,fin);
    }

    public void setMemento(SelectionMemento memento) {
        // Restaure l'état  en remplacant l'input user.
        setDebut(memento.getDebut());
        setFin(memento.getFin());
    }

    public class SelectionMemento implements Memento{
        private int debut;
        private int fin;

        public SelectionMemento(int debut, int fin){
            this.debut = debut;
            this.fin = fin;
        }

        public int getDebut() {
            return debut;
        }

        public void setDebut(int debut) {
            this.debut = debut;
        }

        public int getFin() {
            return fin;
        }

        public void setFin(int fin) {
            this.fin = fin;
        }
    }

}