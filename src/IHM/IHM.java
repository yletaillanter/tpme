package IHM;

import commandes.Commande;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public interface IHM {
    public void addCommand(Commande command,String key );
    public String getInputUser();
    public void setDot(int dot);
    public int getDot();
    public void setMark(int mark);
    public int getMark();
}
