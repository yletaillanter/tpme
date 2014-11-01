package IHM;

import Moteur.BufferImpl;
import Moteur.Buffer;
import Observer.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private Button copyButton, pasteButton, cutButton, insertButton, selectButton;
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
        setTitle("Mini-Editeur");
        setSize(600,600);
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

        //Lower part
        bufferDisplay = new JTextArea();
        bufferDisplay.setEditable(false);
        bufferDisplay.setRows(7);
        bufferDisplay.setBackground(Color.LIGHT_GRAY);

        bufferDisplay.getCaret().setVisible(true);
        bufferDisplay.getCaret().setSelectionVisible(true);

        bufferDisplay.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                setDot(e.getDot());
                setMark(e.getMark());
                commands.get("Select").execute();
            }
        });

        mainPanel.add(bufferDisplay, BorderLayout.NORTH);

        //Bottom part
        JPanel userPanel = new JPanel();
        userPanel.setBackground(Color.white);
        userPanel.setLayout(new BorderLayout());
        mainPanel.add(userPanel, BorderLayout.CENTER);

        //Ajout des boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5,0));
        copyButton = new Button("Copy");
        pasteButton = new Button("Paste");
        cutButton = new Button("Cut");
        selectButton = new Button("Select");
        insertButton = new Button("Insert");
        buttonPanel.add(copyButton);
        buttonPanel.add(pasteButton);
        buttonPanel.add(cutButton);
        buttonPanel.add(selectButton);
        buttonPanel.add(insertButton);
        userPanel.add(buttonPanel,BorderLayout.NORTH);
        setButtonAction();

        // zone de texte
        userInput = new JTextArea();
        userPanel.add(userInput,BorderLayout.CENTER);

        return mainPanel;
    }

    public void setButtonAction(){

        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Copy").execute();
                logger.log(Level.INFO, "Copy clicked");
            }
        });

        pasteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Paste").execute();
                logger.log(Level.INFO, "Paste clicked");
            }
        });

        cutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Cut").execute();
                logger.log(Level.INFO, "Cut clicked");
            }
        });

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Insert").execute();
                logger.log(Level.INFO, "Insert clicked");
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
        logger.log(Level.INFO,"dot:"+dot);
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        logger.log(Level.INFO,"mark:"+mark);
        this.mark = mark;
    }

    @Override
    public void doUpdate(Subject<T> s) {

        if(s instanceof BufferImpl){
            bufferDisplay.setText(((BufferImpl) s).getContent());
        }
    }
}
