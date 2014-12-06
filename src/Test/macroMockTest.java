package Test;

import IHM.IHMImpl;
import Memento.EnregistreurImpl;
import Moteur.MoteurEdition;
import Moteur.MoteurEditionImpl;
import UndoRedo.UndoRedoManager;
import UndoRedo.UndoRedoManagerImpl;
import commandes.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Yoann on 06/12/2014.
 */
public class macroMockTest {

    MoteurEdition moteur = new MoteurEditionImpl();
    EnregistreurImpl enregistreur = Mockito.mock(EnregistreurImpl.class);
    IHMImpl ihm = new IHMImpl();
    UndoRedoManager managerMock = Mockito.mock(UndoRedoManagerImpl.class);
    Commande commandeStart, commandeStop, commandePlay, commandeInserer;


    @Before
    public void setUp() {
        moteur.setUndoRedoManager(managerMock);
        commandeStart = new CommandeStart(enregistreur);
        commandeStop = new CommandeStop(enregistreur);
        commandePlay = new CommandePlay(enregistreur);
        commandeInserer = new CommandeInsererTexte(moteur, ihm, enregistreur);
    }

    @Test
    public void test1() {
        commandeStart.execute();
        verify(enregistreur).rec();

        commandeStop.execute();
        verify(enregistreur).stop();

        commandePlay.execute();
        verify(enregistreur).play();
    }

    @Test
    public void test2() {
        commandeStart.execute();
        commandeInserer.execute();
        verify(enregistreur).save(commandeInserer);
    }
}

