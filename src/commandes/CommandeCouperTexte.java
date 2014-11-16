package commandes;

import Memento.*;
import Moteur.MoteurEdition;

import java.util.logging.Level;

/**
 *  <b>CommandeCouperTexte</b> est la classe qui définit la commande concrète <i>couper</i>.
 *
 *  @see commandes.Commande
 *
 *  @author Yoann Le Taillanter
 */
public class CommandeCouperTexte implements Commande {

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
     * Constructeur de <i>CommandeCouperTexte</i>
     *
     * @param moteur
     *      Le moteur du mini éditeur
     */
    public CommandeCouperTexte(MoteurEdition moteur, Enregistreur enregistreur) {
        this.moteur = moteur;
        this.enregistreur = enregistreur;
    }

    /**
     * Appel de la méthode <i>couper</i> sur le moteur.
     *
     * @see Moteur.MoteurEditionImpl
     * @see Moteur.MoteurEditionImpl#couper()
     */
    public void execute (){
        enregistreur.save( this );
        moteur.couper();
    }

    @Override
    public Memento getMemento() {
        return new mementoCouper();
    }

    @Override
    public void setMemento(Memento memento) {
        // Pas d'état à restaurer
    }

    private class mementoCouper implements Memento{

        // Pas d'état à sauvegarder.

        public mementoCouper(){
        }
    }
}
