package commandes;

import Moteur.MoteurEdition;
import IHM.*;

import java.util.logging.Level;

/**
 *  <b>CommandeSelectionnerTexte</b> est la classe qui définit la commande concrète <i>séléctionner</i>.
 *
 *  @see commandes.Commande
 *  @author Yoann Le Taillanter
 */
public class CommandeSelectionnerTexte implements Commande {

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
     * Constructeur de <i>CommandeSelectionnerTexte</i>
     *
     * @param moteur
     *      Le moteur du mini-éditeur
     * @param ihm
     *      L'IHM du mini-éditeur
     */
    public CommandeSelectionnerTexte(MoteurEdition moteur,IHM ihm) {
        this.ihm = ihm;
        this.moteur = moteur;
    }

    /**
     * Appel de la méthode <i>selectionner</i> sur le moteur.
     * <p>
     * La commande insérer à besoin du début et de la fin de la séléction,
     * qui sont les méthodes getDot() et getMark() de l'IHM.
     * </p>
     *
     * @see Moteur.MoteurEditionImpl
     * @see Moteur.MoteurEditionImpl#selectionner(int, int)
     */
    public void execute() {
        moteur.selectionner(ihm.getDot(),ihm.getMark());
    }
}
