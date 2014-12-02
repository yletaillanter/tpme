package Test;

import static org.mockito.Mockito.*;

import IHM.IHMImpl;
import Memento.Enregistreur;
import Memento.EnregistreurImpl;
import Moteur.MoteurEdition;
import Moteur.MoteurEditionImpl;
import UndoRedo.UndoRedoManager;
import UndoRedo.UndoRedoManagerImpl;
import commandes.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by Yoann on 02/12/2014.
 */
public class CommandeTest {

    IHMImpl mockitoIHM = Mockito.mock(IHMImpl.class);
    MoteurEdition mockitoMoteur = Mockito.mock(MoteurEditionImpl.class);
    Enregistreur mockitoEnregistreur = Mockito.mock(EnregistreurImpl.class);
    UndoRedoManager mockitoManager = Mockito.mock(UndoRedoManagerImpl.class);
    Commande commandeInserer, commandeCopier, commandeColler, commandeCouper, commandeSelectionner, commandeSupDroite,
            commandeSupGauche, commandeStart, commandeStop, commandePlay, commandeUndo, commandeRedo;

    @Before
    public void setUp(){
        commandeInserer = new CommandeInsererTexte(mockitoMoteur,mockitoIHM,mockitoEnregistreur);
        commandeCopier = new CommandeCopierTexte(mockitoMoteur,mockitoEnregistreur);
        commandeColler = new CommandeCollerTexte(mockitoMoteur, mockitoEnregistreur);
        commandeCouper =  new CommandeCouperTexte(mockitoMoteur, mockitoEnregistreur);
        commandeSelectionner =  new CommandeSelectionnerTexte(mockitoMoteur, mockitoIHM, mockitoEnregistreur);
        commandeSupDroite  = new CommandeSupprimerTexteDroite(mockitoMoteur, mockitoEnregistreur);
        commandeSupGauche = new CommandeSupprimerTexteGauche(mockitoMoteur, mockitoEnregistreur);
        commandeStart = new CommandeStart(mockitoEnregistreur);
        commandeStop = new CommandeStop(mockitoEnregistreur);
        commandePlay = new CommandePlay(mockitoEnregistreur);
        commandeUndo = new CommandeUndo(mockitoManager);
        commandeRedo = new CommandeRedo(mockitoManager);
    }

    @Test
    public void testInserer(){
        //Appel de la commande
        commandeInserer.execute();
        verify(mockitoMoteur).inserer(null, false);
    }

    @Test
    public void testCopier(){
        commandeCopier.execute();
        verify(mockitoMoteur).copier();
    }

    @Test
    public void testColler(){
        commandeColler.execute();
        verify(mockitoMoteur).coller();
    }

    @Test
    public void testCouper(){
        commandeCouper.execute();
        verify(mockitoMoteur).couper();
    }

    @Test
    public void testSelectionner(){
        commandeSelectionner.execute();
        verify(mockitoMoteur).selectionner(0, 0);
    }

    @Test
    public void testSupDroite(){
        commandeSupDroite.execute();
        verify(mockitoMoteur).supprimerDroite();
    }


    @Test
    public void testSupGauche(){
        commandeSupGauche.execute();
        verify(mockitoMoteur).supprimerGauche();
    }


    @Test
    public void testStart(){
        commandeStart.execute();
        verify(mockitoEnregistreur).rec();
    }

    @Test
    public void testStop(){
        commandeStop.execute();
        verify(mockitoEnregistreur).stop();
    }

    @Test
    public void testPlay(){
        commandePlay.execute();
        verify(mockitoEnregistreur).play();
    }

    @Test
    public void testUndo(){
        commandeUndo.execute();
        verify(mockitoManager).undo();
    }

    @Test
    public void testRedo(){
        commandeRedo.execute();
        verify(mockitoManager).redo();
    }

}
