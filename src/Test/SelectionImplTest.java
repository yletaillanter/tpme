package Test;

import Moteur.Selection;
import Moteur.SelectionImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Yoann on 08/11/2014.
 */
public class SelectionImplTest {
    private Selection selection;

    @Before
    public void setUp() {
        selection = new SelectionImpl();
    }

    @Test
    public void initTest() {
        Assert.assertEquals(0, selection.getDebut());
        Assert.assertEquals(0, selection.getFin());
    }

    @Test
    public void setTest() {
        int[] valuesTest = {0, 1, 2, 3, 100, 1000};

        for (int i = 0; i < valuesTest.length; i++) {
            selection.setDebut(valuesTest[i]);
            Assert.assertEquals(valuesTest[i], selection.getDebut());

            selection.setFin(valuesTest[i]);
            Assert.assertEquals(valuesTest[i], selection.getFin());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTestDebutnegative() {
        selection.setDebut(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTestFinnegative() {
        selection.setFin(-10);
    }




}
