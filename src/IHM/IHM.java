package IHM;

import commandes.Commande;

import java.util.HashMap;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public interface IHM {
    /**
     * Permet d'ajouter une nouvelle commande
     * @param command
     *      La commande à ajouter
     * @param key
     *      Le nom de la commande
     */
    public void addCommand(Commande command,String key );

    /**
     * Récupère le contenu du JTextField de l'inputUser
     * @return contenu de l'InputUser
     */
    public String getInputUser();

    /**
     *
     * @param dot
     */
    public void setDot(int dot);
    public int getDot();
    public void setMark(int mark);
    public int getMark();
    public boolean retourChariotIsChecked();
}
