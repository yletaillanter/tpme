package Moteur;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public interface MoteurEdition {
    public void copier();
    public void coller();
    public void couper();
    public void inserer(String txt);
    public void selectionner(int dot, int mark);
    //public PressePapier getPressePapier();
    //public Selection getSelectionImpl();
    public BufferImpl getBuffer();
}
