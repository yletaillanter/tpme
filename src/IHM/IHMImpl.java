package IHM;

import Moteur.BufferImpl;
import Observer.*;
import commandes.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class IHMImpl<T> extends JFrame implements IHM, Observer<T> {

    private Logger logger = Logger.getLogger("tpme.IHM.IHMImpl");
    private Map<String, Commande> commands;
    private JButton copyButton, pasteButton, cutButton, insertButton, deleteRight, deleteLeft, start, stop, play;
    private Image recIcon;
    private JTextField userInput;
    private JTextField numberOfCharacter;
    private JTextField cursorPosition;
    private JEditorPane informationLine;
    private int dot;
    private int mark;
    private JTextArea bufferDisplay;
    private JCheckBox retourChariot;
    private boolean retourChariotChecked = false;

    private JPanel  mainPanel;
    private JPanel upperPanel;
    private JToolBar buttonToolbar;
    private JPanel  bottomPanel;

    /**
     * Constructors
     */
    public IHMImpl(){
        commands = new Hashtable<String, Commande>(); // error diamond types are not supported ...
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
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(new BorderLayout());

        //Upper part
        upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());

        bufferDisplay = new BufferDisplay(this,this.commands);

        //Ajout des boutons
        buttonToolbar = new JToolBar();
        copyButton = new JButton("Copy");
        pasteButton = new JButton("Paste");
        cutButton = new JButton("Cut");
        insertButton = new JButton("Insert");
        deleteRight = new JButton("Suppr");
        deleteLeft = new JButton("Backspace");
        //Icon warnIcon = new ImageIcon("Icons/recorder.png");
        start = new JButton("Rec");//,warnIcon);
        stop = new JButton("Stop");
        play = new JButton("Play");
        retourChariot = new JCheckBox("retour à la ligne");
        buttonToolbar.add(copyButton);
        buttonToolbar.add(pasteButton);
        buttonToolbar.add(cutButton);
        buttonToolbar.add(insertButton);
        buttonToolbar.add(deleteLeft);
        buttonToolbar.add(deleteRight);
        buttonToolbar.add(start);
        buttonToolbar.add(stop);
        buttonToolbar.add(play);
        buttonToolbar.add(retourChariot);

        setButtonAction();

        upperPanel.add(buttonToolbar, BorderLayout.NORTH);
        upperPanel.add(bufferDisplay, BorderLayout.CENTER);

        mainPanel.add(upperPanel, BorderLayout.CENTER);

        //Bottom part
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2, 0));

        // zone de texte
        userInput = new JTextField();
        userInput.setBackground(Color.WHITE);

        informationLine = new JEditorPane();
        informationLine.setLayout(new GridLayout());
        informationLine.setEditable(false);
        informationLine.setBackground(Color.LIGHT_GRAY);

        numberOfCharacter = new JTextField();
        numberOfCharacter.setEditable(false);
        numberOfCharacter.setText("Nombre de Caractères : ");
        numberOfCharacter.setBackground(Color.LIGHT_GRAY);
        informationLine.add(numberOfCharacter);

        cursorPosition = new JTextField();
        cursorPosition.setEditable(false);
        cursorPosition.setText("Position du Curseur : ");
        cursorPosition.setBackground(Color.LIGHT_GRAY);
        informationLine.add(cursorPosition);

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
    private void setButtonAction(){
        copyButton.addActionListener(new ButtonAction("Copy", this.commands));
        pasteButton.addActionListener(new ButtonAction("Paste", this.commands));
        cutButton.addActionListener(new ButtonAction("Cut", this.commands));
        insertButton.addActionListener(new ButtonAction("Insert", this.commands));
        deleteLeft.addActionListener(new ButtonAction("DeleteLeft", this.commands));
        deleteRight.addActionListener(new ButtonAction("DeleteRight", this.commands));
        start.addActionListener(new ButtonAction("Start", this.commands));
        stop.addActionListener(new ButtonAction("Stop", this.commands));
        play.addActionListener(new ButtonAction("Play", this.commands));

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

    public void setCursorPosition(String infoSelection){
        cursorPosition.setText("Position du Curseur : " + infoSelection);
    }

    @Override
    public void doUpdate(Subject<T> s) {
        if (s instanceof BufferImpl) {
            bufferDisplay.setText(((BufferImpl) s).getContent());
            numberOfCharacter.setText("Nombre de Caractères : " + ((BufferImpl) s).getLength());
        }
    }

}
