package Moteur;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class BufferImpl implements Buffer {

    private static BufferImpl buffer;
    private StringBuilder innerBuffer;

    /**
     * Private Constructor
     */
    private BufferImpl(){
        innerBuffer = new StringBuilder();
    }

    /**
     * Create an instance of BufferImpl
     * @return instance of BufferImpl
     */
    public static BufferImpl getBufferInstance(){
        if(buffer == null)
            buffer = new BufferImpl();
        return buffer;
    }

    /**
     *
     * @return the whole buffer
     */
    public String getContent(){
        return innerBuffer.toString();
    }

    /**
     *
     * @param deb
     * @param fin
     * @return String from buffer between 'deb' and 'fin'
     */
    public String getContentAt(int deb, int fin){
        return innerBuffer.substring(deb, fin);
    }

    /**
     * Add 'txt' to the buffer
     * @param txt
     */
    public void addContent(String txt){
        innerBuffer.append(txt);
    }

    /**
     * Add 'txt' to the buffer at 'position'
     * @param txt
     * @param position
     */
    public void addContentAtPosition(String txt, int position){
        innerBuffer.insert(position,txt);
    }

    public void deleteContent(int deb,int fin){
        innerBuffer.delete(deb,fin);
    }
}
