package commandes;

import Memento.*;
import Moteur.*;
import IHM.*;

import java.util.logging.Level;

/**
 *  <b>CommandeInsererTexte</b> est la classe qui définit la commande concrète <i>insérer</i>.
 *
 *  @see commandes.Commande
 *  @author Yoann Le Taillanter
 */
public class CommandeInsererTexte implements Commande {
    /**
     * Le moteur d'édition.
     * Référence vers le moteur d'édition du mini-éditeur.
     *
     * @see Moteur.MoteurEdition
     */
    private MoteurEdition moteur;

    /**
     * l'ihm.
     * Référence vers l'IHM du mini-éditeur
     *
     * @see Moteur.MoteurEdition
     */
    private IHM ihm;

    /**
     * L'enregistreur.
     * Référence vers l'enregistreur du memento (Caretaker).
     *
     */
    private Enregistreur enregistreur;

    /**
     * Constructeur de <i>CommandeInsererTexte</i>
     *
     * @param moteur
     *      Le moteur du mini éditeur
     * @param ihm
     *      L'IHM du mini-éditeur
     */
    public CommandeInsererTexte(MoteurEdition moteur, IHM ihm, Enregistreur enregistreur) {
        this.moteur = moteur;
        this.ihm = ihm;
        this.enregistreur = enregistreur;
    }

    /**
     * Appel de la méthode <i>inserer</i> sur le moteur.
     * <p>
     * La commande insérer à besoin du texte de l'utilisateur et de savoir
     * si la case de retout chariot est activée ou non.
     * </p>
     *
     * @see Moteur.MoteurEditionImpl
     * @see Moteur.MoteurEditionImpl#inserer(String, boolean)
     */
    public void execute(){
        moteur.inserer(ihm.getInputUser(),ihm.retourChariotIsChecked());
    }

    @Override
    public Memento getMemento() {
        return null;
    }

    @Override
    public void setMemento(Memento memento) {

    }
}
