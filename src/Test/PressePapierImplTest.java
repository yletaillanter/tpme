package Test;

import Moteur.PressePapierImpl;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Yoann Le Taillanter
 */
@SuppressWarnings( "deprecation" )
public class PressePapierImplTest {

    PressePapierImpl pp;

    @Before
    public void setUp() throws Exception {
    //pp = PressePapierImpl.getPressePapierInstance();
    }


    @Test
    public void testSetPressePapierContent() throws Exception {

        //Affectation d'un String au presse papier
        pp.setPressePapierContent("Hello world!");
        Assert.assertEquals("Hello world!",pp.getPressePapierContent());

        //Affectation de deux String à la suite, résultat égale à la dernière entrée.
        pp.setPressePapierContent("Ceci est un test d'écriture dans le presses papier");
        pp.setPressePapierContent("Puis de réécriture par dessus");
        Assert.assertEquals("Puis de réécriture par dessus",pp.getPressePapierContent());

        // Test de 100 écriture dans le presse papier
        for (int i = 0;i<100;i++){
            pp.setPressePapierContent("test n°"+i);
            Assert.assertEquals("test n°"+i,pp.getPressePapierContent());
        }
        Assert.assertEquals("test n°99",pp.getPressePapierContent());

        //Test avec un texte plus grand
        String txt = "Bacon ipsum dolor amet ground round andouille pariatur laborum venison in shankle lorem tri-tip dolore quis "+
                     "drumstick ullamco sunt magna. Occaecat lorem ea, id pork dolore minim tempor kevin pork belly ut sunt short loin. Reprehenderit tempor landjaeger dolore, corned beef ham aliqua ball tip sirloin shankle."+
                     "Ground round proident aliqua porchetta, tongue exercitation meatball. Sausage swine in nisi, venison elit incididunt consectetur in occaecat ea pariatur mollit shoulder."+
                     "Shank voluptate turducken deserunt sirloin est ullamco ribeye et prosciutto cow dolor ut shoulder turkey. Nulla capicola kielbasa shankle, fugiat adipisicing t-bone elit veniam exercitation " +
                     "beef pork loin consequat bresaola. Kielbasa labore aute shankle, kevin short loin reprehenderit commodo deserunt cupidatat. Proident bresaola magna, elit culpa beef ribs sirloin kielbasa capicola " +
                     "hamburger. Turkey biltong excepteur, leberkas aliqua tenderloin sausage boudin ipsum ea. Frankfurter leberkas enim anim eiusmod irure andouille pork doner ex ribeye tri-tip nisi ea. Chuck ex consequat " +
                     "sirloin ipsum venison aute veniam tenderloin sausage cow adipisicing.Ut ham hock veniam sed aliqua aliquip turducken non flank. Shankle sirloin chicken beef ribs. Do beef ribs ullamco ex reprehenderit " +
                     "bacon ea fugiat. Officia elit ut doner, pork spare ribs veniam consequat duis shank. Velit andouille consequat turkey laborum. Porchetta nisi ribeye, sunt venison tri-tip ullamco enim deserunt swine. " +
                     "Sed occaecat meatloaf tempor short ribs pork bresaola officia culpa eiusmod shank ut.";
        pp.setPressePapierContent(txt);
        Assert.assertEquals(txt,pp.getPressePapierContent());
    }

    @Test
    public void testGetPressePapierContent() throws Exception {
    }
}