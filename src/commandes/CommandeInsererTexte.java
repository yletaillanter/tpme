package commandes;

import Memento.*;
import Moteur.*;
import IHM.*;

/**
 * <b>CommandeInsererTexte</b> est la classe qui définit la commande concrète <i>insérer</i>.
 *
 * @author Yoann Le Taillanter
 * @see commandes.Commande
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
     */
    private Enregistreur enregistreur;

    /**
     * Constructeur de <i>CommandeInsererTexte</i>
     *
     * @param moteur Le moteur du mini éditeur
     * @param ihm    L'IHM du mini-éditeur
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
     * @see Moteur.MoteurEditionImpl#inserer(String, boolean,Buffer)
     */
    public void execute() {
        enregistreur.save(this);
        moteur.inserer(ihm.getInputUser(), ihm.retourChariotIsChecked(),moteur.getBuffer());
        ihm.setInputUser("");
    }

    // Surcharge d'execute pour que le memento utilise l'état sauvegardé.
    public void execute(String texteAInserer) {
        moteur.inserer(texteAInserer, ihm.retourChariotIsChecked(), moteur.getBuffer());
    }

    @Override
    public Memento getMemento() {
        return new MementoInserer(ihm.getInputUser());
    }


    @Override
    public void setMemento(Memento memento) {
        // Restaure l'état  en remplacant l'input user.
        MementoInserer mem = (MementoInserer) memento;
        execute(mem.getTexteAInserer());
    }
}
