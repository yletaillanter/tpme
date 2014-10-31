package IHM;

import Moteur.BufferImpl;
import Observer.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
        setVisible(true);
    }

    private JPanel buildContentPane(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(new GridLayout(2, 0));

        //Upper part
        bufferDisplay = new JTextArea();
        bufferDisplay.setEditable(false);
        bufferDisplay.getCaret().setVisible(true);
        bufferDisplay.getCaret().setSelectionVisible(true);

        bufferDisplay.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                setDot(e.getDot());
                setMark(e.getMark());
                commands.get("Select").execute();
                //bufferDisplay.getCaret().setSelectionVisible(true);

            }
        });

        bufferDisplay.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                bufferDisplay.getCaret().setSelectionVisible(true);
                logger.log(Level.INFO,"focuuuuuuuuuuuuuuuuuuuuuuuuuuuuus");
            }

            @Override
            public void focusLost(FocusEvent e) {

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
