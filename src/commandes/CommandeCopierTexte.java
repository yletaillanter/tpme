package commandes;

import Moteur.MoteurEdition;

import java.util.logging.Level;

/**
 *  <b>CommandeCopierTexte</b> est la classe qui définit la commande concrète <i>copier</i>.
 *
 *  @see commandes.Commande
 *  @author Yoann Le Taillanter
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
     * Constructeur de <i>CommandeCopierTexte</i>
     *
     * @param moteur
     *      Le moteur du mini éditeur
     */
    public CommandeCopierTexte(MoteurEdition moteur) {
        this.moteur = moteur;
    }

    /**
     * Appel de la méthode copier sur le moteur.
     *
     * @see Moteur.MoteurEditionImpl
     * @see Moteur.MoteurEditionImpl#copier()
     */
    public void execute (){
        moteur.copier();
    }
}
