package UndoRedo;

import Memento.*;
import Moteur.MoteurEdition;

import java.util.LinkedList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by yoannlt on 29/11/14.
 */
public class UndoRedoManagerImpl implements UndoRedoManager {

    private Stack<MoteurEditionMemento> pileDeMemento;
    private Stack<MoteurEditionMemento> pileDeMementoRedo;
    private boolean modeUndo;
    Logger logger = Logger.getLogger("UndoRedo.UndoRedoManagerImpl");
    private MoteurEdition moteur;


    public UndoRedoManagerImpl(MoteurEdition moteur){
        this.moteur = moteur;
        pileDeMemento = new Stack<MoteurEditionMemento>();
        pileDeMementoRedo = new Stack<MoteurEditionMemento>();
        modeUndo = false;
    }

    /**<p>
     * Sauvegarde le memento du moteur. si l'état undo est activé, donc si l'utilisateur a commencé a revenir en arrière dans ses actions
     * et qu'il a modifié le texte il faut effacer la pile de redo, qui n'a plus lieu d'être. (des actions dans le passé ont un impact dans sur le "future".)
     * puis on appel push sur la pile pour sauvegarder. </p>
     *
     */
    @Override
    public void save() {
        if(isModeUndo()){
            //Si mode undo activé, on vide la pile de redo car cette dernière n'est plus valable
            clearStack(pileDeMementoRedo);
            setModeUndo(false);
        }

        pileDeMemento.push(moteur.getMemento());
        //logger.log(Level.INFO, "Ajout d'un memento Moteur dans la pile");
    }

    /**
     * <p>Active le mode undo. Si la pile n'est pas vide il sauvegarde l'état actuel en empilant
     * dans la pile redo puis dépile et restaure l'état du dernier élément de la pile undo </p>
     */
    @Override
    public void undo() {
        setModeUndo(true);

        if(!pileDeMemento.isEmpty()){
            pileDeMementoRedo.push(moteur.getMemento());
            moteur.setMemento(pileDeMemento.pop());
        }
    }

    /**
     *<p> Si la pile n'est pas vide et si le mode undo est activé (sinon pas de redo ...) on emple l'état actuel
     * dans les redo puis dépile et restaure le premier redo de la pile.
     * Lorsque la pile est vide l'état modeUndo est annulé, l'utilisateur est au dernier état possible.</p>
     */
    @Override
    public void redo() {
        if(!pileDeMementoRedo.isEmpty()){
            if(isModeUndo()){
                pileDeMemento.push(moteur.getMemento());
                moteur.setMemento(pileDeMementoRedo.pop());
                //logger.log(Level.INFO,"Appel du redo");

                if(pileDeMementoRedo.isEmpty())
                    setModeUndo(false);
                }
            }
        }

    public boolean isModeUndo() {
        return modeUndo;
    }

    public void setModeUndo(boolean modeUndo) {
        this.modeUndo = modeUndo;
    }

    /**
     * vidage la pile avec une technique ancestrale trés sophistiquée.
     * @param stack
     */
    public void clearStack(Stack stack){
        while(!stack.empty()){
            stack.pop();
        }
    }
}
