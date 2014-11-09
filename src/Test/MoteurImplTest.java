package Test;

import Moteur.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 * Created by Yoann on 09/11/2014.
 */
public class MoteurImplTest {
/*
    Buffer mockBuffer = mock(BufferImpl.class);
    Selection mockedSelection = mock(SelectionImpl.class);
    PressePapier mockedPressePapier = mock(PressePapierImpl.class);
*/
    MoteurEdition moteur;

    @Before
    public void setUp(){
        moteur = new MoteurEditionImpl();
    }

    @Test
    public void testInserer(){
        moteur.inserer("Bacon ipsum dolor amet corned beef bacon brisket porchetta.",false);
        Assert.assertEquals("Bacon ipsum dolor amet corned beef bacon brisket porchetta.", moteur.getBuffer().getContent());

        moteur.inserer(" Tenderloin bacon swine boudin leberkas.",true);
        Assert.assertEquals("Bacon ipsum dolor amet corned beef bacon brisket porchetta.\n Tenderloin bacon swine boudin leberkas.",moteur.getBuffer().getContent());
    }
}
