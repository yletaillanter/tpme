package Memento;

/**
 * Created by Yoann on 01/12/2014.
 */
public class MementoInserer implements Memento {

    String texteAInserer;

    public MementoInserer(String texteAInserer) {
        this.texteAInserer = texteAInserer;
    }

    public void setTexteAInserer(String texteAInserer) {
        this.texteAInserer = texteAInserer;
    }

    public String getTexteAInserer() {
        return texteAInserer;
    }

}
