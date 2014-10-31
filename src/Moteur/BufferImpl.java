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
        for (Observer<T> o : registeredObservers) {
            o.doUpdate(this);
        }
    }

    /**
     * Add 'txt' to the buffer at 'position'
     * @param txt
     * @param position
     */
    public void addContentAtPosition(String txt, int position){
        innerBuffer.insert(position,txt);

        for (Observer<T> o : registeredObservers) {
            o.doUpdate(this);
        }
    }

    public void deleteContent(int deb,int fin){
        innerBuffer.delete(deb,fin);
        for (Observer<T> o : registeredObservers) {
            o.doUpdate(this);
        }
    }

    @Override
    public int getLength() {
        return innerBuffer.capacity();
    }

    @Override
    public void register(Observer<T> o) throws IllegalArgumentException {
        if (registeredObservers.contains(o)) {
            throw new IllegalArgumentException("o is registered already");
        }
        registeredObservers.add(o);
    }

    @Override
    public void unregister(Observer<T> o) throws IllegalArgumentException {
        if (!registeredObservers.contains(o)) {
            throw new IllegalArgumentException("o is not registered");
        }
        registeredObservers.remove(o);
    }

    @Override
    public boolean isRegistered(Observer<T> o) {
        if (o == null) {
            throw new IllegalArgumentException("o is null");
        }
        return registeredObservers.contains(o);
    }
/*
    @Override
    public T getValue() {
        return null;
    }

    @Override
    public void setValue(T v) {

    }
    */
}
