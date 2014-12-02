package Test;

import static org.mockito.Mockito.*;

import Memento.Enregistreur;
import Memento.EnregistreurImpl;
import Moteur.*;
import org.junit.Assert;
import org.junit.Test;
import IHM.*;
import org.mockito.Mockito;

/**
 * Created by Yoann on 02/12/2014.
 */
public class ObserverTest {

    IHMImpl mockitoIHM = Mockito.mock(IHMImpl.class);
    Enregistreur mockitoEnregistreur = Mockito.mock(EnregistreurImpl.class);
    MoteurEdition moteur = new MoteurEditionImpl();

    @Test(expected = IllegalArgumentException.class)
    public void testRegister(){
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
    public void testUpdate(){
        //Enregistrement de l'ihm comme observer
        try{
            moteur.getBuffer().register(mockitoIHM);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        Assert.assertTrue(moteur.getBuffer().isRegistered(mockitoIHM));

        //init des variables
        String testString = "MOCKITOOOOOO";
        StringBuilder testStringBuilder = new StringBuilder();
        // appel des méthodes qui déclanche un update.
        moteur.getBuffer().addContent(testString);
        moteur.getBuffer().addContentAtPosition(testString, testString.length());
        moteur.getBuffer().deleteContent(0, testString.length());
        moteur.getBuffer().setInnerBuffer(testStringBuilder);
        //vérification de l'appel de l'update.
        verify(mockitoIHM, times(4)).doUpdate(moteur.getBuffer());
    }



}
