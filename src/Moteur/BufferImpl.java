package Moteur;

/**
 * Created by 14007427 on 22/10/2014.
 */
public class BufferImpl implements Buffer {

    private static BufferImpl buffer;
    private StringBuffer innerBuffer;

    private BufferImpl(){
        innerBuffer = new StringBuffer();
    }

    public static BufferImpl getBufferInstance(){
        if(buffer == null)
            return new BufferImpl();
        return buffer;
    }

    public String getContenu(int debut, int fin){
        return null;
    }
}
