package Test;

import Moteur.Selection;
import Moteur.SelectionImpl;
import junit.framework.Assert;
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
        int[] valuesTest = {0, 1, 2, 3, 100, -5, -50};

        for (int i = 0; i < valuesTest.length; i++) {
            selection.setDebut(i);
            Assert.assertEquals(i, selection.getDebut());
            selection.setFin(i);
            Assert.assertEquals(i, selection.getFin());
        }
    }
}
