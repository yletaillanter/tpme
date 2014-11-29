package Test;
import Moteur.BufferImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//import static org.mockito.Mockito.*;

/**
 * Created by Yoann on 09/11/2014.
 */
public class BufferImplTest {
    private BufferImpl buffer;
    private String stringTest;

    @Before
    public void setUp() {
        buffer = new BufferImpl();
        stringTest = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eleifend eleifend eros," +
                " in commodo felis placerat in. Praesent orci turpis, scelerisque ultricies porta ut, finibus et nisl." +
                "Proin leo risus, posuere vitae cursus sit amet, sagittis sed lacus. Praesent sagittis vitae quam non blandit. " +
                "Nam placerat convallis nibh ac suscipit. Suspendisse rutrum lectus vitae eros imperdiet, at vulputate mauris interdum. " +
                "Nunc ac orci rutrum, suscipit quam non, mattis magna. Proin posuere erat eget dolor faucibus consequat. Duis dui ligula, " +
                "accumsan eget hendrerit non, mollis vitae lectus. Nulla facilisi. Nullam sodales est id vehicula pharetra. " +
                "Pellentesque semper placerat est a tincidunt. Proin condimentum bibendum dui at imperdiet.";
    }

    @Test
    public void getContentTest() {
        buffer.addContent(stringTest);
        Assert.assertEquals(stringTest, buffer.getContent());
    }

    @Test
    public void getContentAtTest() {
        buffer.addContent(stringTest);
        Assert.assertEquals(stringTest.substring(5, 42), buffer.getContentAt(5, 42));
    }


    @Test
    public void addContentAtPositionTest() {
        buffer.addContent(stringTest);
        stringTest = "TEST";

        buffer.addContentAtPosition("TEST", 73);
        Assert.assertEquals("TEST", buffer.getContentAt(73, (73 + stringTest.length())));
    }

    @Test
    public void deleteContentTest() {
        buffer.addContent(stringTest);
        buffer.deleteContent(11, buffer.getLength());
        Assert.assertEquals("Lorem ipsum", buffer.getContent());

        buffer.deleteContent(-150, 150);
        Assert.assertEquals("", buffer.getContent());
    }

    @Test
    public void getLengthTest() {
        Assert.assertEquals(0, buffer.getLength());
        buffer.addContent("Lorem ipsum");
        Assert.assertEquals(11, buffer.getLength());
        buffer.deleteContent(1, 11);
        Assert.assertEquals(1, buffer.getLength());
    }
/*
    @Test(expected = IllegalArgumentException.class)
    public void registerTest() {
    }

*/
}
