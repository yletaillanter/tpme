package Moteur;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class PressePapierImpl implements PressePapier {

    private static PressePapier pp;
    private String pressePapier;

    /**
     * Private Constructor
     */
    private PressePapierImpl(){}

    /**
     * Create an instance of PressePapier
     * @return instance of PressePapier
     */
    public static PressePapier getPressePapierInstance(){
        if(pp == null)
            pp = new PressePapierImpl();
        return pp;
    }

    /**
     * Set content to pressePapier
     * @param content
     */
    @Override
    public void setPressePapierContent(String content) {
        pressePapier=content;
    }

    /**
     * get the content of the pressePapier
     * @return String
     */
    @Override
    public String getPressePapierContent(){
        return pressePapier;
    }
}
