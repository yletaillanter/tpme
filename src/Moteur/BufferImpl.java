package Moteur;

import Memento.Memento;
import Observer.Observer;
import Observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class BufferImpl implements Buffer, Subject {

    /**
     * Contient la liste des Observers du BufferImpl.
     *
     * @see Observer
     */
    private List<Observer> registeredObservers;


    /**
     * StringBuilder, le vrai buffer.
     */
    private StringBuilder innerBuffer;

    /**
     * Constructeur privé du bufferImpl.
     * <p/>
     * Le StringBuilder et l'ArrayList d'Observer sont instanciés.
     */
    public BufferImpl() {
        innerBuffer = new StringBuilder();
        registeredObservers = new ArrayList<Observer>();
    }

    /**
     * Permet de récupérer le contenu du buffer
     *
     * @return le contenu du buffer
     */
    public String getContent() {
        return innerBuffer.toString();
    }


    /**
     * Permet de récupérer le contenu du buffer situé entre debut et fin.
     *
     * @param deb
     * @param fin
     * @return le contenu du buffer entre debut et fin.
     */
    public String getContentAt(int deb, int fin) {
        return innerBuffer.substring(deb, fin);
    }

    /**
     * Permet d'ajouter une chaine de caractère au buffer
     *
     * @param txt String à ajouter au buffer
     */
    public void addContent(String txt) {
        innerBuffer.append(txt);
        update();
    }

    /**
     * Permet d'ajouter une chaine de caractère au buffer, à une position précise
     *
     * @param txt      String à ajouter au buffer
     * @param position Position à laquelle le String est inséré.
     */
    public void addContentAtPosition(String txt, int position) {
        innerBuffer.insert(position, txt);
        update();
    }

    /**
     * Permet de supprimer le contenu du buffer entre debut et fin
     *
     * @param deb Début de la séléction
     * @param fin Fin de la séléction
     */
    public void deleteContent(int deb, int fin) {
        if (deb < 0)
            deb = 0;
        if (fin < 0)
            fin = 0;
        innerBuffer.delete(deb, fin);
        update();
    }

    /**
     * Modifie le buffer interne du bufferImpl
     * @param innerBuffer
     */
    public void setInnerBuffer(StringBuilder innerBuffer) {
        this.innerBuffer = innerBuffer;
        update();
    }

    /**
     * Efface le contenu du buffer.
     */
    @Override
    public void clear() {
        innerBuffer.delete(0, innerBuffer.length());
    }

    /**
     * Permet d'obtenir la taille du buffer.
     *
     * @return taille du buffer
     */
    @Override
    public int getLength() {
        return innerBuffer.length();
    }

    /**
     * Enregistrer un nouvel observer
     * @param o the observer to add to the set
     * @throws IllegalArgumentException
     */
    @Override
    public void register(Observer o) throws IllegalArgumentException {
        if (registeredObservers.contains(o)) {
            throw new IllegalArgumentException("o is registered already");
        }
        registeredObservers.add(o);
    }

    /**
     * Désinscrire un observer
     * @param o the observer to remove
     * @throws IllegalArgumentException
     */
    @Override
    public void unregister(Observer o) throws IllegalArgumentException {
        if (!registeredObservers.contains(o)) {
            throw new IllegalArgumentException("o is not registered");
        }
        registeredObservers.remove(o);
    }

    /**
     * Dit si o est enregistré dans la liste des observers.
     * @param o the observer to check
     * @return
     */
    @Override
    public boolean isRegistered(Observer o) {
        if (o == null) {
            throw new IllegalArgumentException("o is null");
        }
        return registeredObservers.contains(o);
    }

    /**
     * Dit au(x) observer(s) que l'état du sujet a changé.
     */
    private void update() {
        for (Observer o : registeredObservers) {
            o.doUpdate(this);
        }
    }


    /**
     * Créer un nouveau memento du buffer
     * @return BufferMemento
     * @see Moteur.BufferImpl.BufferMemento
     */
    @Override
    public BufferImpl.BufferMemento getMemento() {
        return new BufferMemento(innerBuffer);
    }

    /**
     * permet de restaurer l'état du buffer depuis le memento.
     * @param memento
     */
    @Override
    public void setMemento(BufferMemento memento) {
        setInnerBuffer(memento.getInnerBufferMemento());

    }

    /**
     * Class interne BufferMemento
     */
    public class BufferMemento implements Memento {

        /**
         * état du buffer à sauvegarder
         */
        StringBuilder innerBufferMemento;

        /**
         * constructor
         * @param innerBufferMemento
         */
        public BufferMemento(StringBuilder innerBufferMemento){
            this.innerBufferMemento = new StringBuilder();
            this.innerBufferMemento.append(innerBufferMemento.toString());
        }

        /**
         * Permet d'obtenir l'état du buffer interne sauvegardé dans le memento
         * @return
         */
        public StringBuilder getInnerBufferMemento() {
            return innerBufferMemento;
        }

        /**
         * permet de setter le buffer interne à sauvegarder.
         * @param innerBufferMemento
         */
        public void setInnerBufferMemento(StringBuilder innerBufferMemento) {
            this.innerBufferMemento = innerBufferMemento;
        }
    }

}
