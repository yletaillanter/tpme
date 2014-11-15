package commandes;

import Memento.Enregistreur;
import Memento.Memento;
import Moteur.MoteurEdition;

/**
 *  <b>CommandeSupprimerTexteDroite</b> est la classe qui définit la commande concrète <i>supprimerDroite</i>.
 *
 *  @see commandes.Commande
 *
 *  @author Baptiste Quéré
 */
public class CommandeSupprimerTexteDroite implements Commande {

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
     * Constructeur de <i>CommandeSupprimerTexteDroite</i>
     *
     * @param moteur
     *      Le moteur du mini éditeur
     */
    public CommandeSupprimerTexteDroite(MoteurEdition moteur, Enregistreur enregistreur) {
        this.moteur = moteur;
        this.enregistreur = enregistreur;
    }

    /**
     * Appel de la méthode <i>supprimerDroite()</i> sur le moteur.
     *
     * @see Moteur.MoteurEditionImpl
     * @see Moteur.MoteurEditionImpl#supprimerDroite()
     */
    public void execute (){
        moteur.supprimerDroite();
    }

    @Override
    public Memento getMemento() {
        return null;
    }

    @Override
    public void setMemento(Memento memento) {

    }
}
