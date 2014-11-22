package Moteur;

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
     *
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
    public String getContent(){
        return innerBuffer.toString();
    }


    /**
     * Permet de récupérer le contenu du buffer situé entre debut et fin.
     *
     * @param deb
     * @param fin
     * @return le contenu du buffer entre debut et fin.
     */
    public String getContentAt(int deb, int fin){
            return innerBuffer.substring(deb, fin);
    }

    /**
     * Permet d'ajouter une chaine de caractère au buffer
     *
     * @param txt
     *      String à ajouter au buffer
     */
    public void addContent(String txt){
        innerBuffer.append(txt);
        update();
    }

    /**
     * Permet d'ajouter une chaine de caractère au buffer, à une position précise
     * @param txt
     *      String à ajouter au buffer
     * @param position
     *      Position à laquelle le String est inséré.
     */
    public void addContentAtPosition(String txt, int position){
        innerBuffer.insert(position,txt);
        update();
    }

    /**
     * Permet de supprimer le contenu du buffer entre debut et fin
     *
     * @param deb
     *      Début de la séléction
     * @param fin
     *      Fin de la séléction
     */
    public void deleteContent(int deb,int fin){
        innerBuffer.delete(deb,fin);
        update();
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

    @Override
    public void register(Observer o) throws IllegalArgumentException {
        if (registeredObservers.contains(o)) {
            throw new IllegalArgumentException("o is registered already");
        }
        registeredObservers.add(o);
    }

    @Override
    public void unregister(Observer o) throws IllegalArgumentException {
        if (!registeredObservers.contains(o)) {
            throw new IllegalArgumentException("o is not registered");
        }
        registeredObservers.remove(o);
    }

    @Override
    public boolean isRegistered(Observer o) {
        if (o == null) {
            throw new IllegalArgumentException("o is null");
        }
        return registeredObservers.contains(o);
    }

    private void update(){
        for (Observer o : registeredObservers) {
            o.doUpdate(this);
        }
    }
}
