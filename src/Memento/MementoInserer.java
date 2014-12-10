package Memento;

/**
 * Created by Yoann on 01/12/2014.
 */
public class MementoInserer implements Memento {

    /**
     * Contient le texte à sauvegarde.
     * C'est l'état de la commande insérer.
     */
    String texteAInserer;

    public MementoInserer(String texteAInserer) {
        this.texteAInserer = texteAInserer;
    }

    /**
     * permet de définir ultérieurement l'état du memento
     * @param texteAInserer
     */
    public void setTexteAInserer(String texteAInserer) {
        this.texteAInserer = texteAInserer;
    }

    /*
    * @return l'état sauvegardé
     */
    public String getTexteAInserer() {
        return texteAInserer;
    }

}
