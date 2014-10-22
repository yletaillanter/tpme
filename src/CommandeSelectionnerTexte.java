/**
 * Created by 14007427 on 22/10/2014.
 */
public class CommandeSelectionnerTexte implements Commande {

    private MoteurEdition moteur;

    public CommandeSelectionnerTexte(MoteurEdition moteur) {
        this.moteur = moteur;
    }

    public void execute() {
        moteur.selectionner();
    }
}
