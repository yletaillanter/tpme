package Observer;

/**
 * Created by Yoann on 31/10/2014.
 */
public interface Subject {
    /******** Observers' management ********/

    /**
     * Registers an observer to the set of registered observers of this
     *
     * @param o the observer to add to the set
     * @throws IllegalArgumentException if o is null or already registered
     */
    void register(Observer o) throws IllegalArgumentException;

    /**
     * Removes an observer from the registered observers set in this
     *
     * @param o the observer to remove
     * @throws IllegalArgumentException if o is null or unregistered
     */
    void unregister(Observer o) throws IllegalArgumentException;

    /**
     * Checks whether an observer is registered
     *
     * @param o the observer to check
     * @return true iff o is already in the registered observers' set of this
     * @throws IllegalArgumentException if o is null
     */
    boolean isRegistered(Observer o);

    /******** Value management ********/

    /**
     * Retrieves the subject's state value property
     *
     * @return subject's value property
     */
    //T getValue();


    /**
     * Updates the subject's value property
     *
     * @param v new value for subject's value
     */
    //void setValue(T v);
}
