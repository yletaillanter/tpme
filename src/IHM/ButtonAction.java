package IHM;

import commandes.Commande;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by Yoann Le Taillanter on 05/11/2014.
 */
public class ButtonAction implements ActionListener {

    private HashMap<String, Commande> commands;
    private String commandName;

    public ButtonAction(String commandName, HashMap commands){
        this.commandName = commandName;
        this.commands = commands;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        commands.get(this.commandName).execute();
    }
}
