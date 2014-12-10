package IHM;

import Moteur.Selection;
import commandes.Commande;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;


/**
 * Created by Baptiste Quéré on 05/11/2014.
 */
public class BufferDisplay extends JTextArea {

    /**
     * L'ihm du mini-éditeur
     * Référence vers l'ihm
     */
    private IHMImpl ihmAssocie;

    /**
     * La Hashtable de commandes/nom
     */
    private Map<String, Commande> commands;

    /**
     * JPopupMenu pour le clic droit
     */
    private JPopupMenu popup;

    /**
     * JMenuItem pour le JPopupMenu du clic droit
     */
    private JMenuItem menuItem;

    /**
     * Constructeur de BufferDisplay
     * <p/>
     * <ul>
     * <li>initialise l'ihm et la HashMap</li>
     * <li>rend la fenêtre non éditable</li>
     * <li>définit la couleur du BG</li>
     * <li>rend le curseur visible</li>
     * <li>appel de la méthode implementListener()</li>
     * <li>appel de la méthode createPopupMenu()</li>
     * </ul>
     *
     * @param ihm      ihm du mini-éditeur
     * @param commands hashmap de commandes
     * @see #implementListener()
     * @see #createPopupMenu()
     */
    public BufferDisplay(IHMImpl ihm, Map commands) {
        this.ihmAssocie = ihm;
        this.commands = commands;
        setEditable(false);
        setBackground(Color.WHITE);
        getCaret().setVisible(true);
        getCaret().setSelectionVisible(true);

        implementListener();
        createPopupMenu();
    }


    /**
     * Définit les différents Listener présent sur le bufferDisplay
     */
    private void implementListener() {

        /**
         * Met à jour la selection à chaque utilisation du Caret (Curseur)
         *
         * @see IHM#setDot(int)
         * @see IHM#setMark(int)
         */
        addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                ihmAssocie.setDot(e.getDot());
                ihmAssocie.setMark(e.getMark());
                commands.get("Select").execute();
                ihmAssocie.setCursorPosition(("" + e.getDot()));
            }
        });

        /**
         * FocusListener qui fait réapparaitre le curseur lorsque le bufferDisplay récupère le focus
         */
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                getCaret().setVisible(true);
                //logger.log(Level.INFO,"focus");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                maybeShowPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                maybeShowPopup(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            private void maybeShowPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(),
                            e.getX(), e.getY());
                }
            }
        });

        /**
         * Detecte les touches appuyés sur le BufferDisplay
         */
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Supprime le son système
                InputMap inputMap = getInputMap();
                ActionMap actionMap = getActionMap();
                KeyStroke keyStroke = KeyStroke.getKeyStrokeForEvent(e);
                inputMap.put(keyStroke, "doNothing");
                actionMap.put("doNothing", new AbstractAction() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Do Nothing
                    }
                });
                // touche del appel supprimerDroite
                if (e.getKeyChar() == Event.DELETE)
                    commands.get("DeleteRight").execute();

                // Touche backspace appel supprimergauche
                if (e.getKeyChar() == Event.BACK_SPACE)
                    commands.get("DeleteLeft").execute();
            }
        });
    }

    /**
     * Créer le menu JPopupMenu du clic droit et affecte les commandes aux boutons.
     */
    private void createPopupMenu() {

        popup = new JPopupMenu();
        // Ajout l'item copy au popup menu
        menuItem = new JMenuItem("Copy");
        // Action Listener de l'item = execture la commande
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Copy").execute();
            }
        });
        popup.add(menuItem);

        menuItem = new JMenuItem("Paste");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Paste").execute();
            }
        });
        popup.add(menuItem);

        menuItem = new JMenuItem("Cut");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Cut").execute();
            }
        });
        popup.add(menuItem);

        menuItem = new JMenuItem("DeleteRight");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("DeleteRight").execute();
            }
        });
        popup.add(menuItem);

        menuItem = new JMenuItem("DeleteLeft");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("DeleteLeft").execute();
            }
        });
        //Ajoute le menuItem au JPopupMenu
        popup.add(menuItem);
    }
}
