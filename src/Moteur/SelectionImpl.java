package Moteur;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class SelectionImpl implements Selection {

    private static Selection select;
    private int debut;
    private int fin;


    /**
     * Private Constructor
     */
    private SelectionImpl(){
        this.debut = 0;
        this.fin = 0;
    }

    /**
     * Create an instance of Selection
     * @return instance of Selection
     */
    public static Selection getSelectionInstance(){
        if(select == null)
            select = new SelectionImpl();
        return select;
    }

    //******* Getters and setters ***********
    @Override
    public int getDebut() {
        return this.debut;
    }

    @Override
    public void setDebut(int debut) {
        this.debut = debut;
    }

    @Override
    public int getFin() {
        return this.fin;
    }

    @Override
    public void setFin(int fin) {
        this.fin = fin;
    }
}