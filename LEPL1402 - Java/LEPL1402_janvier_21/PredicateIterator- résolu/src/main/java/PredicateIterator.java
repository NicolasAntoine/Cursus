import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * Question:
 *
 * You are asked to implement PredicateIterator<T>
 * that is an iterator that is created from another iterator
 * but it will only iterate over the elements satisfying
 * the predicate
 *
 * Once it is done, copy-paste the complete class in Inginious also with the imports
 *
 *
 * Feel free to add methods or fields in the class but do not modify
 * the signature and behavior of existing code
 *
 */
public class PredicateIterator<T> implements Iterator<T> {
    Predicate<T> p;
    Iterator<T> ite;
    T current;


    /**
     * Creates a iterator that only iterates on the elements
     * that satisfy the predicate, the other elements are skipped
     * @param ite the iterator
     * @param p the predictate speciying the element to iterate on
     */
    public PredicateIterator(Iterator<T> ite, Predicate<T> p) {
        this.ite = ite;
        this.p = p;
        current = ite.next();
    }

    /**
     * Test if at least one element left satisfying the predicate
     * @return true if there is at least one element
     *         left that satisfies the predicate
     *         false otherwise
     */
    @Override
    public boolean hasNext() {
        while(!p.test(current)){
            try {
                current = ite.next();
            } catch (Exception e) {
                return false;
            }
        }
        return current != null;
    }
    /**
     * Next element that satisfies the predicate
     * @return the next element that satisfies the predicate
     */
    @Override
    public T next() {
        if(!hasNext()) return current;
        T item = current;
        current = ite.next();
        return item;
    }
}


