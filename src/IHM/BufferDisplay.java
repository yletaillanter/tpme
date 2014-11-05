    package IHM;

    import commandes.Commande;

    import javax.swing.*;
    import javax.swing.event.CaretEvent;
    import javax.swing.event.CaretListener;
    import java.awt.*;
    import java.awt.event.*;
    import java.util.HashMap;


    /**
     * Created by 14007686 on 05/11/2014.
     */
    public class BufferDisplay extends JTextArea {

        private IHMImpl ihmAssocie;
        private HashMap<String, Commande> commands;
        private JPopupMenu popup;
        private JMenuItem menuItem;

        public BufferDisplay(IHMImpl ihm, HashMap commands){
            ihmAssocie = ihm;
            this.commands = commands;
            setEditable(false);
            setRows(15);
            setBackground(Color.LIGHT_GRAY);
            getCaret().setVisible(true);
            getCaret().setSelectionVisible(true);

            implementListener();
            createPopupMenu();
        }


        private void implementListener(){

        // #################### CARET LISTENER #################### //
            addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                ihmAssocie.setDot(e.getDot());
                ihmAssocie.setMark(e.getMark());
                commands.get("Select").execute();
            }
            });
        // #################### FOCUS LISTENER #################### //
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

        // #################### MOUSE LISTENER #################### //
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

    // #################### KEY LISTENER #################### //
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == Event.DELETE)
                    commands.get("DeleteRight").execute();

                if (e.getKeyChar() == Event.BACK_SPACE)
                    commands.get("DeleteLeft").execute();
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
            });

        }
        public void createPopupMenu(){

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
            popup.add(menuItem);
        }
    }
