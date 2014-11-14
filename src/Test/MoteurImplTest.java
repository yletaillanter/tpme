package Test;

import Moteur.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
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
    static MoteurEdition moteur = new MoteurEditionImpl();

    @BeforeClass
    public static void setUp(){
    }

    @Test
    public void testInserer(){
        moteur.inserer("Bacon ipsum.",false);
        moteur.selectionner(12,12);
        Assert.assertEquals("Bacon ipsum.", moteur.getBuffer().getContent());

        moteur.inserer(" Tenderloin bacon swine boudin.",true);
        Assert.assertEquals("Bacon ipsum. Tenderloin bacon swine boudin.",moteur.getBuffer().getContent());
    }
}
