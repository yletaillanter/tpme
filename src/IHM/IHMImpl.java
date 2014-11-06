package IHM;

import Moteur.BufferImpl;
import Observer.*;
import commandes.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

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
    private JEditorPane informationLine;
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
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(buildContentPane());
        setVisible(true);
    }

    private JPanel buildContentPane(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(new BorderLayout());

        //Upper part
        bufferDisplay = new BufferDisplay(this,this.commands);

        JPanel UpperPanel = new JPanel();
        UpperPanel.setLayout(new BorderLayout());
        mainPanel.add(UpperPanel, BorderLayout.CENTER);


        //Ajout des boutons
        JToolBar buttonToolbar = new JToolBar();
        copyButton = new Button("Copy");
        pasteButton = new Button("Paste");
        cutButton = new Button("Cut");
        insertButton = new Button("Insert");
        deleteRight = new Button("deleteRight");
        deleteLeft = new Button("deleteLeft");
        retourChariot = new JCheckBox("retour à la ligne");
        buttonToolbar.add(copyButton);
        buttonToolbar.add(pasteButton);
        buttonToolbar.add(cutButton);
        buttonToolbar.add(insertButton);
        buttonToolbar.add(deleteLeft);
        buttonToolbar.add(deleteRight);
        buttonToolbar.add(retourChariot);

        UpperPanel.add(buttonToolbar,BorderLayout.NORTH);
        UpperPanel.add(bufferDisplay,BorderLayout.CENTER);

        setButtonAction();

        //Bottom part
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2, 0));

        // zone de texte
        userInput = new JTextField();
        userInput.setBackground(Color.WHITE);

        informationLine = new JEditorPane();
        informationLine.setEditable(false);
        informationLine.setBackground(Color.LIGHT_GRAY);

        bottomPanel.add(userInput);
        bottomPanel.add(informationLine);

        mainPanel.add(bottomPanel,BorderLayout.SOUTH);

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
