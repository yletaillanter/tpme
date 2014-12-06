package Test;

import IHM.IHMImpl;
import Memento.Enregistreur;
import Memento.EnregistreurImpl;
import Moteur.MoteurEdition;
import Moteur.MoteurEditionImpl;
import UndoRedo.UndoRedoManager;
import UndoRedo.UndoRedoManagerImpl;
import commandes.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by Yoann on 06/12/2014.
 */
public class macroTest {

    private MoteurEdition moteur = new MoteurEditionImpl();
    private Enregistreur enregistreur = new EnregistreurImpl();
    private IHMImpl ihm = new IHMImpl();
    UndoRedoManager managerMock = Mockito.mock(UndoRedoManagerImpl.class);
    Commande commandeStart, commandeStop, commandePlay, commandeInserer, commandeCopier, commandeColler, commandeCouper, commandeSelection;



    @Before
    public void setUp(){
        moteur.setUndoRedoManager(managerMock);
        commandeStart = new CommandeStart(enregistreur);
        commandeStop = new CommandeStop(enregistreur);
        commandePlay = new CommandePlay(enregistreur);
        commandeInserer = new CommandeInsererTexte(moteur, ihm, enregistreur);
        commandeCopier = new CommandeCopierTexte(moteur,enregistreur);
        commandeColler = new CommandeCollerTexte(moteur,enregistreur);
        commandeSelection = new CommandeSelectionnerTexte(moteur,ihm,enregistreur);
        commandeCouper = new CommandeCouperTexte(moteur,enregistreur);
    }

    @Test
    public void test1(){

        // TEST INSERTION scénario : simple insertion d'un String.
        //Début de l'enregistrement
        commandeStart.execute();
        //set l'input du user dans le champs de l'IHM
        ihm.setInputUser("test");
        commandeInserer.execute();
        Assert.assertEquals(moteur.getBuffer().getContent(), "test");
        //Stop de l'enregistrement
        commandeStop.execute();
        //play
        commandePlay.execute();
        Assert.assertEquals(moteur.getBuffer().getContent(), "testtest");


        //set l'input du user dans le champs de l'IHM
        moteur.selectionner(0,0);
        ihm.setInputUser("bonjour");
        commandeInserer.execute();
        Assert.assertEquals(moteur.getBuffer().getContent(), "bonjourtesttest");

        //TEST COPIER scénario : copier le premier mot "bonjour" et le copier à la position 15.
        //Début de l'enregistrement
        commandeStart.execute();
        //set la selection de la souris
        ihm.setDot(0); ihm.setMark(7);
        commandeSelection.execute();
        commandeCopier.execute();

        ihm.setDot(15); ihm.setMark(15); //curseur à la fin
        commandeSelection.execute();

        commandeColler.execute();
        commandeStop.execute();

        Assert.assertEquals(moteur.getBuffer().getContent(), "bonjourtesttestbonjour");

        commandePlay.execute();
        commandePlay.execute();
        Assert.assertEquals(moteur.getBuffer().getContent(), "bonjourtesttestbonjourbonjourbonjour");


        // TEST COUPER scénario : à chaque play  les 3 permiers caractères sont coupé et sont placé au curseur 33, donc à la fin.
        //Début de l'enregistrement
        commandeStart.execute();
        //set la selection de la souris
        ihm.setDot(0); ihm.setMark(3);
        commandeSelection.execute();
        commandeCouper.execute();
        Assert.assertEquals(moteur.getBuffer().getContent(), "jourtesttestbonjourbonjourbonjour");
        ihm.setDot(33); ihm.setMark(33);
        commandeSelection.execute();
        commandeColler.execute();
        //fin de l'enregistrement
        commandeStop.execute();
        Assert.assertEquals(moteur.getBuffer().getContent(), "jourtesttestbonjourbonjourbonjourbon");

        //rejouer l'action
        commandePlay.execute();
        Assert.assertEquals(moteur.getBuffer().getContent(), "rtesttestbonjourbonjourbonjourbonjou");
        commandePlay.execute();
        Assert.assertEquals(moteur.getBuffer().getContent(), "sttestbonjourbonjourbonjourbonjourte");
        commandePlay.execute();
        Assert.assertEquals(moteur.getBuffer().getContent(), "estbonjourbonjourbonjourbonjourtestt");

    }


}
