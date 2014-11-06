package Moteur;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class SelectionImpl implements Selection {

    /**
     * Selection static pour le singleton.
     *
     * @see Moteur.SelectionImpl
     */
    private static Selection select;

    /**
     * début de la sélection
     */
    private int debut;

    /**
     * fin de la sélection
     */
    private int fin;


    /**
     * Constructeur privé de la SelectionImpl.
     *
     * debut et fin sont initialisé à 0.
     */
    private SelectionImpl(){
        this.debut = 0;
        this.fin = 0;
    }

    /**
     * Retourne l'instance de SelectionImpl, la créer si elle n'existe pas.
     * @return instance of SelectionImpl
     */
    public static Selection getSelectionInstance(){
        if(select == null)
            select = new SelectionImpl();
        return select;
    }

    //******* Getters and setters ***********

    /**
     * Permet de récupérer la position de début de la sélection
     * @return debut de séléction
     */
    @Override
    public int getDebut() {
        return this.debut;
    }

    /**
     * Permet de définir la position de début de la sélection
     * @param debut
     */
    @Override
    public void setDebut(int debut) {
        this.debut = debut;
    }

    /**
     * Permet de récupérer la position de fin de la sélection
     * @return fin de séléction
     */
    @Override
    public int getFin() {
        return this.fin;
    }

    /**
     * Permet de définir la position de fin de la sélection
     * @param fin
     */
    @Override
    public void setFin(int fin) {
        this.fin = fin;
    }
}