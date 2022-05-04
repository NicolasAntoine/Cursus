public class Cons {
    // The item inside this list node
    public int v;
    // The next element, null if there is none
    public Cons next;

    // Returns a new Cons by applying function f on all elements
    public Cons map(F f) {
        while (next != null){
            return new Cons(f.apply(v), next.map(f));
        }
        return new Cons(f.apply(v), null);

    }
    // Returns a new Cons containing all elements that match predicate p
    public Cons filter(P p) {
        Cons head = new Cons(v, next);
        while (head.next != null) {
            if (p.filter(head.v)) {
                return new Cons(head.v, head.next.filter(p));
            }
            head = head.next;
        }
        if (p.filter(head.v)){
            return new Cons(head.v, null);
        }
        return null;
    }
    // Constructor
    public Cons(int v, Cons next) {
        this.v = v;
        this.next = next;
    }
}