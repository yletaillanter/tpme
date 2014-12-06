package Test;

import static org.mockito.Mockito.*;

import Moteur.MoteurEdition;
import Moteur.MoteurEditionImpl;
import UndoRedo.UndoRedoManager;
import UndoRedo.UndoRedoManagerImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


/**
 * Created by Yoann on 06/12/2014.
 */
public class UndoRedoTest {

    private MoteurEdition moteur = new MoteurEditionImpl();
    private UndoRedoManager manager = Mockito.mock(UndoRedoManagerImpl.class);

    @Test
    public void test1() {
        // Test de l'appel du manager UndoRedo
        moteur.setUndoRedoManager(manager);
        moteur.inserer("test save()", false);
        moteur.couper();
        moteur.coller();
        moteur.supprimerDroite();
        moteur.supprimerGauche();
        verify(manager, times(5)).save();
    }

    @Test
    public void test2() {
        // Initialisation (besoin d'un vrai manager pas de mock
        UndoRedoManager manager2 = new UndoRedoManagerImpl(moteur);
        moteur.setUndoRedoManager(manager2);

        // on insert dans le buffer
        moteur.inserer("test", false);
        Assert.assertEquals(moteur.getBuffer().getContent(), "test");

      //on appuie sur le bouton undo
        manager2.undo();
        // test si le buffer est bien vide, l'undo a fonctionné
        Assert.assertEquals(moteur.getBuffer().getContent(),"");

        // on appuie sur le bouton redo
        manager2.redo();
        // test si le buffer est revenu à son état avant l'undo
        Assert.assertEquals(moteur.getBuffer().getContent(),"test");
    }

    @Test
    public void test3(){
        //initialiation
        UndoRedoManager manager3 = new UndoRedoManagerImpl(moteur);
        moteur.setUndoRedoManager(manager3);

        for(int i = 0; i<100 ; i++){
            moteur.inserer("test"+i,false);
        }
        for(int j = 0; j<100 ; j++){
            manager3.undo();
        }

        Assert.assertEquals(moteur.getBuffer().getContent(),"");
    }

    @Test
    public void test4(){
        // Initialisation (besoin d'un vrai manager pas d'un mock)
        UndoRedoManager manager4 = new UndoRedoManagerImpl(moteur);
        moteur.setUndoRedoManager(manager4);

        // on écrit dans le buffer
        moteur.inserer("test",false);
 //       moteur.inserer(" mockito",false);
        Assert.assertEquals(moteur.getBuffer().getContent(),"test");

        // appel de couper
        moteur.selectionner(0,4);
        moteur.couper();
        Assert.assertEquals(moteur.getBuffer().getContent(),"");

        //appel d'undo
        manager4.undo();
        Assert.assertEquals(moteur.getBuffer().getContent(),"test");

        //appel d'undo
        manager4.undo();
        Assert.assertEquals(moteur.getBuffer().getContent(),"");

        //on modifie le texte
        moteur.inserer("mockito",false);
        moteur.selectionner(7,7);
        moteur.inserer(" test",false);
        Assert.assertEquals(moteur.getBuffer().getContent(),"mockito test");

        //undo
        manager4.undo();
        Assert.assertEquals(moteur.getBuffer().getContent(),"mockito");
        manager4.undo();
        Assert.assertEquals(moteur.getBuffer().getContent(),"");

        //redo
        manager4.redo();
        manager4.redo();
        //test si l'ancienne pile a été remplacé par les nouveaux memento.
        Assert.assertEquals(moteur.getBuffer().getContent(),"mockito test");
    }

}
