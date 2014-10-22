/**
 * Created by 14007427 on 22/10/2014.
 */
public class CommandeCouperTexte implements Commande {

    private MoteurEdition moteur;

    public CommandeCouperTexte(MoteurEdition m) {
        this.moteur = m;
    }

    public void execute (){
        moteur.couper();
    }
}
