/**
 * Created by 14007427 on 22/10/2014.
 */
public class CommandeCollerTexte implements Commande {

    private MoteurEdition moteur;

    public CommandeCollerTexte(MoteurEdition moteur) {
        this.moteur = moteur;
    }

    public void execute() {
        moteur.coller();
    }
}
