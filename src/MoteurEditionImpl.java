/**
 * Created by 14007427 on 22/10/2014.
 */
public class MoteurEditionImpl implements MoteurEdition {

    private Buffer buffer;
    private PressePapier pp;
    private Selection selection;

    public MoteurEditionImpl(){
        this.buffer = new BufferImpl();
        this.pp = new PressePapierImpl();
        this.selection = new SelectionImpl();
    }

    @Override
    public void copier(){

    }

    @Override
    public void inserer(){

    }

    public void coller(){

    }

    public void couper(){

    }

    public void selectionner(){

    }
}
