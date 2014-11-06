package Moteur;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class PressePapierImpl implements PressePapier {


    /**
     * bufferImpl static pour le singleton.
     *
     * @see Moteur.Buffer
     */
    private static PressePapier pp;

    /**
     * La chaine de caractère du presse-papier
     */
    private String pressePapier;

    /**
     * Constructeur privé du PressePapierImpl.
     */
    private PressePapierImpl(){}

    /**
     * Retourne l'instance de PressePapier, la créer si elle n'existe pas.     *
     * @return instance of PressePapier
     */
    public static PressePapier getPressePapierInstance(){
        if(pp == null)
            pp = new PressePapierImpl();
        return pp;
    }

    /**
     * Permet de définir le contenu du presse-papier.
     * @param content
     */
    @Override
    public void setPressePapierContent(String content) {
        pressePapier=content;
    }

    /**
     * Permet de récupérer le contenu du presse-papier.
     * @return contenu du presse-papier
     */
    @Override
    public String getPressePapierContent(){
        return pressePapier;
    }
}
