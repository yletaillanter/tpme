package Moteur;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class MoteurEditionImpl implements MoteurEdition {

    Logger logger = Logger.getLogger("tpme.Moteur.MoteurEditionImpl");
    private BufferImpl buffer;
    private Selection selection;
    private PressePapier pp;

    public MoteurEditionImpl(){
        this.buffer = BufferImpl.getBufferInstance();
        this.selection = SelectionImpl.getSelectionInstance() ;
        this.pp = PressePapierImpl.getPressePapierInstance();
    }

    @Override
    public void copier() {
        //if(buffer.getLength()>)
        pp.setPressePapierContent(buffer.getContentAt(selection.getDebut(),selection.getFin()));
    }

    @Override
    public void inserer(String txt, boolean retourChariot){
        logger.log(Level.INFO,"Ajout dans buffer: " + txt );
        if(retourChariot) {
            buffer.addContent(txt);
            buffer.addContent("\n");
        }
        else
            buffer.addContent(txt);

        //System.out.println(buffer.getContent());
    }

    @Override
    public void coller(){
        buffer.addContentAtPosition(pp.getPressePapierContent(), selection.getDebut());
        //logger.log(Level.INFO,"coller");
    }

    @Override
    public void couper(){
        pp.setPressePapierContent(buffer.getContentAt(selection.getDebut(),selection.getFin()));
        buffer.deleteContent(selection.getDebut(),selection.getFin());
        //logger.log(Level.INFO,"couper");
    }

    @Override
    public void selectionner(int dot, int mark){
        if(dot>=mark){
            selection.setDebut(mark);
            selection.setFin(dot);
        }
        else {
            selection.setDebut(dot);
            selection.setFin(mark);
        }
    }

    @Override
    public void supprimerDroite() {
        int test = selection.getDebut();
            if (selection.getDebut() == selection.getFin())
                buffer.deleteContent(selection.getDebut(), selection.getFin() + 1);
            else
                buffer.deleteContent(selection.getDebut(), selection.getFin());
        selection.setDebut(test);
        //logger.log(Level.INFO,"supprimerDroite");
    }

    @Override
    public void supprimerGauche() {
        int test = selection.getDebut() - 1;
        if (selection.getDebut() > 0 || selection.getFin() > selection.getDebut()) {
            if (selection.getDebut() == selection.getFin())
                buffer.deleteContent(selection.getDebut() - 1, selection.getFin());
            else
                buffer.deleteContent(selection.getDebut(), selection.getFin());
        selection.setDebut(test); selection.setFin(test);
        //logger.log(Level.INFO,"supprimerGauche");
        //logger.log(Level.INFO,"début: "+selection.getDebut());
        //logger.log(Level.INFO,"fin: "+selection.getFin()+"");
        }
    }
        //logger.log(Level.INFO,""+dot);
        //logger.log(Level.INFO,""+mark);

/* inutile
    @Override
    public PressePapier getPressePapier() {
        return pp;
    }

    @Override
    public Selection getSelectionImpl() {
        return selection;
    }
*/
    @Override
    public BufferImpl getBuffer() {
        return buffer;
    }

}
