package commandes;

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
     * Constructeur de <i>CommandeCouperTexte</i>
     *
     * @param moteur
     *      Le moteur du mini éditeur
     */
    public CommandeCouperTexte(MoteurEdition moteur) {
        this.moteur = moteur;
    }

    /**
     * Appel de la méthode <i>couper</i> sur le moteur.
     *
     * @see Moteur.MoteurEditionImpl
     * @see Moteur.MoteurEditionImpl#couper()
     */
    public void execute (){
        moteur.couper();
    }
}
