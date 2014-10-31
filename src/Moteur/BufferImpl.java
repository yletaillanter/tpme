package Moteur;

import Observer.Observer;
import Observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yoann Le Taillanter on 22/10/2014.
 */
public class BufferImpl<T> implements Buffer, Subject<T> {

    private ArrayList<Observer<T>> registeredObservers;
    private static BufferImpl buffer;
    private StringBuilder innerBuffer;

    /**
     * Private Constructor
     */
    private BufferImpl(){
        innerBuffer = new StringBuilder();
        innerBuffer.append("CECI EST UN TESTD");
        registeredObservers = new ArrayList<Observer<T>>();
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

    @Override
    public int getLength() {
        return innerBuffer.capacity();
    }

    @Override
    public void register(Observer<T> o) throws IllegalArgumentException {

    }

    @Override
    public void unregister(Observer<T> o) throws IllegalArgumentException {

    }

    @Override
    public boolean isRegistered(Observer<T> o) {
        return false;
    }

    @Override
    public T getValue() {
        return null;
    }

    @Override
    public void setValue(T v) {

    }
}
