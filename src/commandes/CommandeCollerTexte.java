package commandes;

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
     * Constructeur de <i>CommandeCollerTexte</i>
     *
     * @param moteur
     *      Le moteur du mini éditeur
     */
    public CommandeCollerTexte(MoteurEdition moteur) {
        this.moteur = moteur;
    }

    /**
     * Appel de la méthode <i>coller</i> sur le moteur.
     *
     * @see Moteur.MoteurEditionImpl
     * @see Moteur.MoteurEditionImpl#coller()
     */
    public void execute() {
        moteur.coller();
    }
}
