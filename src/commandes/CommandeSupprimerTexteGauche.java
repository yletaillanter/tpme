package commandes;

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
     * Constructeur de <i>CommandeSupprimerTexteGauche</i>
     *
     * @param moteur
     *      Le moteur du mini éditeur
     */
    public CommandeSupprimerTexteGauche(MoteurEdition moteur) {

        this.moteur = moteur;
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
}
