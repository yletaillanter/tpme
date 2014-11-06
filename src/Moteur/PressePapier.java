package Moteur;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
interface PressePapier {
    /**
     * Permet de définir le contenu du presse-papier.
     * @param content
     */
    public void setPressePapierContent(String content);

    /**
     * Permet de récupérer le contenu du presse-papier.
     * @return contenu du presse-papier
     */
    public String getPressePapierContent();
}
