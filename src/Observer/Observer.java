package Observer;

/**
 * Created by Yoann on 31/10/2014.
 */
public interface Observer<T> {
    /**
     * Signals to this that s's value has been updated
     *
     * @param s the updated subject
     */
    void doUpdate(Subject<T> s);
}
