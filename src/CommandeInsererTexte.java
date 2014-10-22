/**
 * Created by 14007427 on 22/10/2014.
 */
public class CommandeInsererTexte implements Commande {

    private MoteurEdition moteur;

    public CommandeInsererTexte(MoteurEdition moteur) {
        this.moteur = moteur;
    }

    public void execute(){
        moteur.inserer();
    }
}
