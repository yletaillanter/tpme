package commandes;

import Memento.*;
import Moteur.MoteurEdition;

/**
 * <b>CommandeCopierTexte</b> est la classe qui définit la commande concrète <i>copier</i>.
 *
 * @author Yoann Le Taillanter
 * @see commandes.Commande
 */
public class CommandeCopierTexte implements Commande {

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
     */
    private Enregistreur enregistreur;

    /**
     * Constructeur de <i>CommandeCopierTexte</i>
     *
     * @param moteur Le moteur du mini éditeur
     */
    public CommandeCopierTexte(MoteurEdition moteur, Enregistreur enregistreur) {
        this.moteur = moteur;
        this.enregistreur = enregistreur;
    }

    /**
     * Appel de la méthode copier sur le moteur.
     *
     * @see Moteur.MoteurEditionImpl#copier()
     */
    public void execute() {
        enregistreur.save(this);
        moteur.copier();
    }

    @Override
    public Memento getMemento() {
        return new MementoCopier();
    }

    @Override
    public void setMemento(Memento memento) {
        // Pas d'état à restaurer
    }

    private class MementoCopier implements Memento {

        // Pas d'état à sauvegarder.

        public MementoCopier() {
        }
    }
}
