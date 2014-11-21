package IHM;

import commandes.Commande;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yoann Le Taillanter on 05/11/2014.
 */
public class ButtonAction implements ActionListener {

    /**
     * Map de Commandes et de leur nom
     */
    private Map<String, Commande> commands;

    /**
     * Nom de la commande
     */
    private String commandName;

    /**
     * Constructeur du ButtonAction
     *
     * @param commandName
     *      Le nom de la commande sur laquelle l'actionListener sera créé
     * @param commands
     *      La HashMap de commandes
     */
    public ButtonAction(String commandName, Map<String, Commande> commands){
        this.commandName = commandName;
        this.commands = commands;
    }

    /**
     * Appel de l'execute de la commande
     * @param e
     *
     * @see commandes.Commande#execute()
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        commands.get(this.commandName).execute();
    }
}
