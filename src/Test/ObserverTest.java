package Test;

import static org.mockito.Mockito.*;

import Memento.Enregistreur;
import Memento.EnregistreurImpl;
import Moteur.*;
import commandes.CommandeInsererTexte;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import IHM.*;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

/**
 * Created by Yoann on 02/12/2014.
 */
public class ObserverTest {

    IHMImpl mockitoIHM = Mockito.mock(IHMImpl.class);
    Enregistreur mockitoEnregistreur = Mockito.mock(EnregistreurImpl.class);
    MoteurEdition moteur = new MoteurEditionImpl();

    @Before
    public void setUp(){

        //ajout de la commande insérer
        mockitoIHM.addCommand(new CommandeInsererTexte(moteur,mockitoIHM,mockitoEnregistreur),"Insert");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test1(){
        Assert.assertFalse(moteur.getBuffer().isRegistered(mockitoIHM));
        try{
            moteur.getBuffer().register(mockitoIHM);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        Assert.assertTrue(moteur.getBuffer().isRegistered(mockitoIHM));


        try {
            moteur.getBuffer().unregister(mockitoIHM);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(moteur.getBuffer().isRegistered(mockitoIHM));

        mockitoIHM = null;
        moteur.getBuffer().unregister(mockitoIHM);
    }

    @Test
    public void test2(){





    }



}
