package commandes;

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
     * Constructeur de <i>CommandeSupprimerTexteDroite</i>
     *
     * @param moteur
     *      Le moteur du mini éditeur
     */
    public CommandeSupprimerTexteDroite(MoteurEdition moteur) {
        this.moteur = moteur;
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
}
