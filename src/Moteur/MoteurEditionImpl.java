package Moteur;

import UndoRedo.MoteurEditionMemento;
import UndoRedo.UndoRedoManager;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class MoteurEditionImpl implements MoteurEdition {

    Logger logger = Logger.getLogger("tpme.Moteur.MoteurEditionImpl");

    /**
     * Le buffer.
     *
     * @see Moteur.BufferImpl
     */
    private BufferImpl buffer;

    /**
     * La séléction
     *
     * @see Moteur.SelectionImpl
     */
    private Selection selection;

    /**
     * Le presse papier
     *
     * @see Moteur.PressePapierImpl
     */
    private PressePapier pp;

    /**
     *  Gestion des Ctrl Z / Ctrl Y
     */
    private UndoRedoManager undoRedoManager;

    /**
     *  Comteur d'action pour l'Undo/Redo
     */
    private int counter;

    /**
     * Constructeur du <i>MoteurEditionImpl</i>
     * Créer le moteur puis initialise les buffer, selection et presse-papier.
     *
     * @see Moteur.BufferImpl
     * @see Moteur.SelectionImpl
     * @see Moteur.PressePapierImpl
     */
    public MoteurEditionImpl() {
        buffer = new BufferImpl();
        selection = new SelectionImpl();
        pp = new PressePapierImpl();
        counter = 1;
    }

    /**
     * Copie la séléction dans le presse papier
     *
     * @see Moteur.PressePapier
     * @see Moteur.Selection
     */
    @Override
    public void copier() {
        pp.setPressePapierContent(
                buffer.getContentAt(
                        selection.getDebut(), selection.getFin()
                )
        );
        counter++;
        actionSave();
    }

    /**
     * Insére le texte du champs input utilisateur dans le buffer, ajoute un retour chariot si la case est coché.
     *
     * @param txt           Texte à ajouter dans le buffer
     * @param retourChariot
     */
    @Override
    public void inserer(String txt, boolean retourChariot) {
        //logger.log(Level.INFO,"Ajout dans buffer: " + txt );
        if (retourChariot) {
            buffer.addContentAtPosition("\n", selection.getDebut());
            buffer.addContentAtPosition(txt, selection.getDebut());
        } else
            buffer.addContentAtPosition(txt, selection.getDebut());

        counter++;
        actionSave();
        //System.out.println(buffer.getContent());
    }

    /**
     * Colle le presse papier sur la selection
     *
     * @see Moteur.PressePapier
     * @see Moteur.Selection
     */
    @Override
    public void coller() {
        buffer.addContentAtPosition(pp.getPressePapierContent(), selection.getDebut());
        counter++;
        actionSave();
        //logger.log(Level.INFO,"coller : "+selection.getDebut());
    }

    /**
     * Coupe la séléction dans le presse papier
     *
     * @see Moteur.PressePapier
     * @see Moteur.Selection
     */
    @Override
    public void couper() {
        pp.setPressePapierContent(
                buffer.getContentAt(
                        selection.getDebut(), selection.getFin()
                )
        );
        buffer.deleteContent(selection.getDebut(), selection.getFin());
        counter++;
        actionSave();

        //logger.log(Level.INFO,"couper");
    }

    /**
     * Met à jour la selection
     *
     * @param dot
     * @param mark
     * @see Moteur.Selection
     */
    @Override
    public void selectionner(int dot, int mark) {
        if (dot < 0)
            dot = 0;
        if (mark < 0)
            mark = 0;
        if (dot >= mark) {
            selection.setDebut(mark);
            selection.setFin(dot);
        } else {
            selection.setDebut(dot);
            selection.setFin(mark);
        }
        //counter++;
        actionSave();
    }

    /**
     * supprime avec la touche <i>del</i>
     * <p>
     * Sauvegarde la position du curseur puis la reaffecte à la fin
     * (la touche del ne fait pas bouger le curseur)
     * Si debut != fin il y a une selection de l'utilisateur, pas de distinction pour la suppression           *
     * </p>
     *
     * @see Moteur.SelectionImpl
     * @see Moteur.BufferImpl
     */
    @Override
    public void supprimerDroite() {
        int test = selection.getDebut();
        if (selection.getDebut() == selection.getFin())
            buffer.deleteContent(selection.getDebut(), selection.getFin() + 1);
        else
            buffer.deleteContent(selection.getDebut(), selection.getFin());

        selection.setDebut(test);
        selection.setFin(test);
        counter++;
        actionSave();
        //logger.log(Level.INFO,"supprimerDroite");
    }

    /**
     * supprime avec la touche <i>backspace</i>
     * <p>
     * Sauvegarde la position du curseur puis la reaffecte avec 1 de moins à la fin
     * (backspace recule de 1 caractère)
     * Test si début est à 0 pour OutExceptions.
     * Si debut != fin il y a une selection de l'utilisateur, pas de distinction pour la suppression           *
     * </p>
     *
     * @see Moteur.SelectionImpl
     * @see Moteur.BufferImpl
     */
    @Override
    public void supprimerGauche() {
        int test = selection.getDebut() - 1;
        if (selection.getDebut() > 0 || selection.getFin() > selection.getDebut()) {
            if (selection.getDebut() == selection.getFin()) {
                buffer.deleteContent(selection.getDebut() - 1, selection.getFin());
                selection.setDebut(test);
                selection.setFin(test);
            } else
                buffer.deleteContent(selection.getDebut(), selection.getFin());
        }
        counter++;
        actionSave();
    }
    //logger.log(Level.INFO,""+dot);
    //logger.log(Level.INFO,""+mark);

    /**
     * Retourne l'instance du buffer.
     *
     * @return instance du buffer
     * @see Moteur.BufferImpl
     */
    @Override
    public BufferImpl getBuffer() {
        return buffer;
    }

    @Override
    public PressePapier getPressePapier() {
        return pp;
    }

    public void setUndoRedoManager(UndoRedoManager undoRedoManager) {
        this.undoRedoManager = undoRedoManager;
        undoRedoManager.save(this);
    }

    public void actionSave(){
        logger.log(Level.INFO,"counter = " + counter + " %5 = " + counter%5 );
        if(counter%5 == 0)
            undoRedoManager.save(this);
    }

    /**
     * Retourne un objet contenant l'état du moteur (de ses composants)
     * @return MoteurEditionMemento contenant Selection, buffer et pressePapier Memento
     */
    public MoteurEditionMemento getMemento(){
        return new MoteurEditionMemento(selection.getMemento(),buffer.getMemento(),pp.getMemento());
    }

    public MoteurEditionMemento getInitialMemento(){
        return new MoteurEditionMemento(selection.getInitialMemento(),buffer.getInitialMemento(), pp.getInitialMemento());
    }

    /**
     *
     */
    public void setMemento(MoteurEditionMemento memento){
        selection.setMemento(memento.getSelectionMemento());
        pp.setMemento(memento.getPressePapierMemento());
        buffer.setMemento(memento.getBufferMemento());
    }

}
