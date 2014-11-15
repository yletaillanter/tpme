package commandes;

import Memento.Enregistreur;
import Memento.Memento;
import Moteur.MoteurEdition;

import java.util.logging.Level;

/**
 *  <b>CommandeSupprimerTexteGauche</b> est la classe qui définit la commande concrète <i>supprimerGauche</i>.
 *
 *  @see commandes.Commande
 *
 *  @author Baptiste Quéré
 */
public class CommandeSupprimerTexteGauche implements Commande {

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
     * Constructeur de <i>CommandeSupprimerTexteGauche</i>
     *
     * @param moteur
     *      Le moteur du mini éditeur
     */
    public CommandeSupprimerTexteGauche(MoteurEdition moteur, Enregistreur enregistreur) {
        this.moteur = moteur;
        this.enregistreur = enregistreur;
    }

    /**
     * Appel de la méthode <i>supprimerGauche</i> sur le moteur.
     *
     * @see Moteur.MoteurEditionImpl
     * @see Moteur.MoteurEditionImpl#supprimerGauche()
     */
    public void execute (){
        moteur.supprimerGauche();
    }

    @Override
    public Memento getMemento() {
        return null;
    }

    @Override
    public void setMemento(Memento memento) {

    }
}
