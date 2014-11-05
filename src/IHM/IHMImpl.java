package IHM;

import Moteur.BufferImpl;
import Observer.*;
import commandes.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class IHMImpl<T> extends JFrame implements IHM, Observer<T> {

    Logger logger = Logger.getLogger("tpme.IHM.IHMImpl");
    private HashMap<String, Commande> commands;
    private Button copyButton, pasteButton, cutButton, insertButton, deleteRight, deleteLeft;
    private JTextField userInput;
    private int dot;
    private int mark;
    private BufferDisplay bufferDisplay;
    private JCheckBox retourChariot;
    private boolean retourChariotChecked = false;

    /**
     * Constructors
     */
    public IHMImpl(){
        commands = new HashMap<String, Commande>(); // error diamond types are not supported ...
        build();
    }

    private void build(){
        setTitle("Mini-Editeur");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(buildContentPane());
        setVisible(true);
    }

    private JPanel buildContentPane(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(new BorderLayout(0,0));

        //Upper part
        bufferDisplay = new BufferDisplay(this,this.commands);
        mainPanel.add(bufferDisplay, BorderLayout.NORTH);

        //Bottom part
        JPanel userPanel = new JPanel();
        userPanel.setBackground(Color.white);
        userPanel.setLayout(new BorderLayout());
        mainPanel.add(userPanel, BorderLayout.CENTER);

        //Ajout des boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 7));
        copyButton = new Button("Copy");
        pasteButton = new Button("Paste");
        cutButton = new Button("Cut");
        insertButton = new Button("Insert");
        deleteRight = new Button("deleteRight");
        deleteLeft = new Button("deleteLeft");
        retourChariot = new JCheckBox("retour à la ligne");
        buttonPanel.add(copyButton);
        buttonPanel.add(pasteButton);
        buttonPanel.add(cutButton);
        buttonPanel.add(insertButton);
        buttonPanel.add(deleteLeft);
        buttonPanel.add(deleteRight);
        buttonPanel.add(retourChariot);
        userPanel.add(buttonPanel,BorderLayout.NORTH);

        setButtonAction();

        // zone de texte
        userInput = new JTextField();
        userInput.setBackground(Color.WHITE);
        userPanel.add(userInput,BorderLayout.CENTER);

        userInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == Event.ENTER){
                        commands.get("Insert").execute();
                        userInput.setText("");
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
           });

        return mainPanel;
    }


    /**
     * Definit les actions propres aux boutons + la checkBox.
     */
    public void setButtonAction(){

        copyButton.addActionListener(new ButtonAction("Copy", this.commands));
        pasteButton.addActionListener(new ButtonAction("Paste", this.commands));
        cutButton.addActionListener(new ButtonAction("Cut", this.commands));
        insertButton.addActionListener(new ButtonAction("Insert", this.commands));
        deleteLeft.addActionListener(new ButtonAction("DeleteLeft", this.commands));
        deleteRight.addActionListener(new ButtonAction("DeleteRight", this.commands));

        retourChariot.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                retourChariotChecked = !retourChariotIsChecked();
            }
        });
    }

    // ################ GETTER AND SETTER #########################

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
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public boolean retourChariotIsChecked(){
       return retourChariotChecked;
    }

    @Override
    public void doUpdate(Subject<T> s) {
        if (s instanceof BufferImpl) {
            bufferDisplay.setText(((BufferImpl) s).getContent());
        }
    }
}
