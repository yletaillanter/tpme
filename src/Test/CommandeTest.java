package Test;

import static org.mockito.Mockito.*;

import IHM.IHMImpl;
import Memento.Enregistreur;
import Memento.EnregistreurImpl;
import Moteur.MoteurEdition;
import Moteur.MoteurEditionImpl;
import commandes.Commande;
import commandes.CommandeInsererTexte;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by Yoann on 02/12/2014.
 */
public class CommandeTest {

    IHMImpl mockitoIHM = Mockito.mock(IHMImpl.class);
    MoteurEdition mockitoMoteur = Mockito.mock(MoteurEditionImpl.class);
    Enregistreur mockitoEnregistreur = Mockito.mock(EnregistreurImpl.class);
    Commande commandeInserer = new CommandeInsererTexte(mockitoMoteur,mockitoIHM,mockitoEnregistreur);

    @Test
    public void testInserer(){
        // Ajout de la commande
        mockitoIHM.addCommand(commandeInserer, "Insert");
        // verif de l'ajout de la commande
        verify(mockitoIHM).addCommand(commandeInserer, "Insert");

        //Appel de la commande
        commandeInserer.execute();
        verify(mockitoMoteur).inserer(null,false);
    }

}
