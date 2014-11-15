package commandes;

import Memento.*;
import Moteur.MoteurEdition;

import java.util.logging.Level;

/**
 *  <b>CommandeCollerTexte</b> est la classe qui définit la commande concrète <i>coller</i>.
 *
 *  @see commandes.Commande
 *  @author Yoann Le Taillanter
 */
public class CommandeCollerTexte implements Commande {

    /**
     * Le moteur d'édition.
     * Référence vers le moteur d'édition du mini-éditeur.
     *
     * @see Moteur.MoteurEdition
     */
    private MoteurEdition moteur;

    /**
     * L'enregistreur.
     * Référence vers l'enregistreur du memento (Caretaker).
     *
     */
    private Enregistreur enregistreur;

    /**
     * Constructeur de <i>CommandeCollerTexte</i>
     *
     * @param moteur
     *      Le moteur du mini éditeur
     */
    public CommandeCollerTexte(MoteurEdition moteur, Enregistreur enregistreur) {
        this.moteur = moteur;
        this.enregistreur = enregistreur;
    }

    /**
     * Appel de la méthode <i>coller</i> sur le moteur.
     *
     * @see Moteur.MoteurEditionImpl#coller()
     */
    public void execute() {
        enregistreur.save( this );
        moteur.coller();
    }

    @Override
    public Memento getMemento() {
        return new mementoColler();
    }

    @Override
    public void setMemento(Memento memento) {
        // Pas d'état à restaurer
    }

    private class mementoColler implements Memento{

        // Pas d'état à sauvegarder.

        public mementoColler(){
        }
    }
}
