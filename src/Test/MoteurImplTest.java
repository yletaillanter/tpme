package Test;

import Moteur.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//import static org.mockito.Mockito.*;

/**
 * Created by Yoann on 09/11/2014.
 */
public class MoteurImplTest {
/*
    Buffer mockBuffer = mock(BufferImpl.class);
    Selection mockedSelection = mock(SelectionImpl.class);
    PressePapier mockedPressePapier = mock(PressePapierImpl.class);
*/
static MoteurEdition moteur;
    private StringBuilder bufferTest;
    private String stringTest;
    private int curseur;

    @Before
    public void setUp() {
        moteur = new MoteurEditionImpl();
        // Pour comparer avec le moteur.buffer
        bufferTest = new StringBuilder();
        // String de test courant
        this.stringTest = "";
        //déplacement manuel du curseur pour le test.
        curseur = 0;
    }

    @Test
    public void testInserer(){
        // TEST D'UN INSERT SIMPLE
        stringTest = "Bacon ipsum.";
        curseur += stringTest.length();
        bufferTest.append(stringTest);
        moteur.inserer(stringTest, false,moteur.getBuffer());
        moteur.selectionner(curseur, curseur);
        Assert.assertEquals(stringTest, moteur.getBuffer().getContent());
        Assert.assertEquals(bufferTest.toString(), moteur.getBuffer().getContent());


        // DEUXIEME INSERT SIMPLE
        stringTest = " Tenderloin bacon swine boudin.";
        curseur += stringTest.length();
        bufferTest.append(stringTest);
        moteur.inserer(stringTest, false,moteur.getBuffer());
        moteur.selectionner(curseur, curseur);
        Assert.assertEquals(bufferTest.toString(), moteur.getBuffer().getContent());

        //TEST RETOUR A LA LIGNE VIDE
        stringTest = "\n";
        curseur += stringTest.length();
        bufferTest.append(stringTest);
        moteur.inserer("", true,moteur.getBuffer());
        moteur.selectionner(curseur, curseur);
        Assert.assertEquals(bufferTest.toString(), moteur.getBuffer().getContent());

        // PUIS INSERT SIMPLE APRES RETOUR LIGNE
        stringTest = "test";
        curseur += stringTest.length();
        bufferTest.append(stringTest);
        moteur.inserer(stringTest, false,moteur.getBuffer());
        moteur.selectionner(curseur, curseur);
        Assert.assertEquals(bufferTest.toString(), moteur.getBuffer().getContent());
    }


    @Test
    public void copierTest() {
        stringTest = "Bacon ipsum. Tenderloin bacon swine boudin.";
        moteur.inserer(stringTest, false,moteur.getBuffer());
        curseur += stringTest.length();

        moteur.selectionner(7, 25);
        moteur.copier();
        Assert.assertEquals(moteur.getBuffer().getContentAt(7, 25), moteur.getPressePapier().getPressePapierContent());

        moteur.selectionner(10, 4);
        moteur.copier();
        Assert.assertEquals(moteur.getBuffer().getContentAt(4, 10), moteur.getPressePapier().getPressePapierContent());

        moteur.selectionner(-1, 5);
        moteur.copier();
        Assert.assertEquals(moteur.getBuffer().getContentAt(0, 5), moteur.getPressePapier().getPressePapierContent());
    }


    @Test
    public void copierCollerTest() {
        //init
        stringTest = "Bacon ipsum. Tenderloin bacon swine boudin.";
        bufferTest.append(stringTest);
        moteur.inserer(stringTest, false,moteur.getBuffer());
        curseur += stringTest.length();

        //TEST
        moteur.selectionner(0, 5);
        moteur.copier();
        Assert.assertEquals(stringTest.substring(0, 5), moteur.getPressePapier().getPressePapierContent()); // assertEqual sur le contenu du  pressePapier au passage.
        Assert.assertEquals(bufferTest.substring(0, 5), moteur.getPressePapier().getPressePapierContent());

        moteur.selectionner(curseur, curseur);
        moteur.coller();
        bufferTest.append(bufferTest.substring(0, 5));
        Assert.assertEquals(bufferTest.toString(), moteur.getBuffer().getContent());
    }


    @Test
    public void couperCollerTest() {
        //init
        stringTest = "Alcatra ham tenderloin salami.";
        curseur += stringTest.length();
        bufferTest.append(stringTest);
        moteur.inserer(stringTest, false,moteur.getBuffer());
        Assert.assertEquals(bufferTest.toString(), moteur.getBuffer().getContent());

        //TEST
        bufferTest.append(bufferTest.substring(0, 8));
        bufferTest.delete(0, 8);

        moteur.selectionner(0, 8);
        moteur.couper();
        curseur = moteur.getBuffer().getLength();
        moteur.selectionner(curseur, curseur);
        moteur.coller();
        Assert.assertEquals(bufferTest.toString(), moteur.getBuffer().getContent());
    }
}
