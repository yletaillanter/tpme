package Moteur;

/**
 * Created by 14007427 on 22/10/2014.
 */
public class SelectionImpl implements Selection {

    private int debut;
    private int fin;

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