package Moteur;

import UndoRedo.MoteurEditionMemento;

import javax.swing.text.Caret;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public interface MoteurEdition {

    /**
     * Copie la séléction dans le presse papier
     *
     * @see Moteur.PressePapier
     * @see Moteur.Selection
     */
    public void copier();

    /**
     * Colle le presse papier sur la selection
     *
     * @see Moteur.PressePapier
     * @see Moteur.Selection
     */
    public void coller();

    /**
     * Coupe la séléction dans le presse papier
     *
     * @see Moteur.PressePapier
     * @see Moteur.Selection
     */
    public void couper();

    /**
     * Insére le texte du champs input utilisateur dans le buffer, ajoute un retour chariot si la case est coché.
     *
     * @param txt           Texte à ajouter dans le buffer
     * @param retourChariot
     */
    public void inserer(String txt, boolean retourChariot);

    /**
     * Met à jour la selection
     *
     * @param dot
     * @param mark
     * @see Moteur.Selection
     */
    public void selectionner(int dot, int mark);

    /**
     * supprime avec la touche <i>del</i>
     */
    public void supprimerDroite();

    /**
     * Suppression avec la touche <i>backspace</i>
     */
    public void supprimerGauche();

    /**
     * Retourne l'instance du buffer.
     *
     * @return instance du buffer
     * @see Moteur.Buffer
     */
    public BufferImpl getBuffer();

    public PressePapier getPressePapier();
    //public Selection getSelectionImpl();

    public MoteurEditionMemento getMemento();
}
