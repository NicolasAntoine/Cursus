import java.util.function.Predicate;
import java.util.function.Function;

public class Cons<E> {
    // The item inside this list node
    public E v;
    // The next element, null if there is none
    public Cons<E> next;

    // Returns a new Cons by applying Function function on all elements
    public <R> Cons <R> map(Function <E,R> function) {
        if (next != null){
            return new Cons<R>(function.apply(v), next.map(function));
        }
        return new Cons<R>(function.apply(v), null);
    }
    // Returns a new Cons containing all elements that match Predicate predicate
    public Cons <E> filter(Predicate <E> predicate) {
        Cons<E> first = new Cons<E>(v, next);
        while (first.next != null) {
            if (predicate.test(first.v)) {
                return new Cons<E>(first.v, first.next.filter(predicate));
            }
            first = first.next;
        }
        if (predicate.test(first.v) && first != null) {
            return new Cons<E>(first.v, null);
        }
        return null;
    }

    // Constructor
    public Cons(E v, Cons<E> next) {
        this.v = v;
        this.next = next;
    }
}
