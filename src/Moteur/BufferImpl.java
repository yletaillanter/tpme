package Moteur;

/**
 * Created by 14007427 on 22/10/2014.
 */
public class BufferImpl implements Buffer {

    static private StringBuffer buffer;

    private BufferImpl(){}

    static public StringBuffer getBuffer(){
        if(buffer == null)
            return new StringBuffer();
        return buffer;
    }
}
