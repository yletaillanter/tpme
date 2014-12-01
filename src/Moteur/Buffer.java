package Moteur;

import Memento.Memento;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public interface Buffer {
    /**
     * Permet de récupérer le contenu du buffer
     *
     * @return le contenu du buffer
     */
    public String getContent();

    /**
     * Permet de récupérer le contenu du buffer situé entre debut et fin.
     *
     * @param debut
     * @param fin
     * @return le contenu du buffer entre debut et fin.
     */
    public String getContentAt(int debut, int fin);

    /**
     * Permet d'ajouter une chaine de caractère au buffer
     *
     * @param txt String à ajouter au buffer
     */
    public void addContent(String txt);

    /**
     * Permet d'ajouter une chaine de caractère au buffer, à une position précise
     *
     * @param txt      String à ajouter au buffer
     * @param position Position à laquelle le String est inséré.
     */
    public void addContentAtPosition(String txt, int position);

    /**
     * Permet de supprimer le contenu du buffer entre debut et fin
     *
     * @param debut Début de la séléction
     * @param fin   Fin de la séléction
     */
    public void deleteContent(int debut, int fin);

    /**
     * Permet d'obtenir la taille du buffer.
     *
     * @return taille du buffer
     */
    public int getLength();

    public BufferImpl.BufferMemento getMemento();

    public BufferImpl.BufferMemento getInitialMemento();

    public void setMemento(BufferImpl.BufferMemento memento);

    public void clear();

}
