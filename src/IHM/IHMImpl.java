package IHM;

import Moteur.BufferImpl;
import Observer.*;

import java.awt.*;
import java.awt.event.*;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import Observer.Observer;
import commandes.*;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class IHMImpl<T> extends JFrame implements IHM, Observer<T> {

    Logger logger = Logger.getLogger("tpme.IHM.IHMImpl");
    private HashMap<String, Commande> commands;
    private Button copyButton, pasteButton, cutButton, insertButton;
    private JTextArea userInput;
    private int dot;
    private int mark;
    private JTextArea bufferDisplay;

    JPopupMenu popup;
    JMenuItem menuItem;


    /**
     * Constructors
     */
    public IHMImpl(){
        commands = new HashMap<String, Commande>(); // error diamond types are not supported ...
        build();
    }

    /*
    public IHMImpl(HashMap<String, Commande> commands){
        this.commands = commands;
        build();
    }
    */

    private void build(){
        setTitle("Mini-editor");
        setSize(600,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(buildContentPane());
        createPopupMenu();
        setVisible(true);
    }

    private JPanel buildContentPane(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(new GridLayout(2, 0));

        //Upper part
        bufferDisplay = new JTextArea();
        bufferDisplay.setEditable(false);

        bufferDisplay.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                setDot(e.getDot());
                setMark(e.getMark());
                commands.get("Select").execute();
            }
        });

        bufferDisplay.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                bufferDisplay.getCaret().setVisible(true);
                //logger.log(Level.INFO,"focus");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        bufferDisplay.addMouseListener(new MouseListener() {
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

        mainPanel.add(bufferDisplay);

        //Bottom part
        JPanel userPanel = new JPanel();
        userPanel.setBackground(Color.white);
        userPanel.setLayout(new GridLayout(2, 0));
        mainPanel.add(userPanel);

        //Ajout des boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        copyButton = new Button("Copy");
        pasteButton = new Button("Paste");
        cutButton = new Button("Cut");
        insertButton = new Button("Insert");
        buttonPanel.add(copyButton);
        buttonPanel.add(pasteButton);
        buttonPanel.add(cutButton);
        buttonPanel.add(insertButton);
        userPanel.add(buttonPanel);
        setButtonAction();

        // zone de texte
        userInput = new JTextArea();
        userPanel.add(userInput);

        return mainPanel;
    }

    public void createPopupMenu(){
        // #########################TEST JPOPUP ####################

        //Create the popup menu.
        popup = new JPopupMenu();
        menuItem = new JMenuItem("Copy");
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
    }

    public void setButtonAction(){

        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Copy").execute();
                //logger.log(Level.INFO, "Copy clicked");
            }
        });

        pasteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Paste").execute();
                //logger.log(Level.INFO, "Paste clicked");
            }
        });

        cutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Cut").execute();
                //logger.log(Level.INFO, "Cut clicked");
            }
        });

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Insert").execute();
                userInput.setText("");
                //logger.log(Level.INFO, "Insert clicked");
            }
        });
    }

    public String getInputUser(){
        return userInput.getText();
    }

    public void addCommand(Commande command,String key ){
        this.commands.put(key,command);
    }

    public int getDot() {
        return dot;
    }

    public void setDot(int dot) {
        this.dot = dot;
        //logger.log(Level.INFO,"dot:"+dot);
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        //logger.log(Level.INFO,"mark:"+mark);
        this.mark = mark;
    }

    @Override
    public void doUpdate(Subject<T> s) {
        if(s instanceof BufferImpl){
            bufferDisplay.setText(((BufferImpl) s).getContent());
        }
    }
}
