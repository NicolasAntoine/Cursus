import java.util.function.Predicate;


/**
 * Question:
 *
 * You are asked to complete the two TODO belows:
 *
 * - the add method appending an element at the end of the linked-list
 * - the filter method that returns a new LinkedListWithFilter containing
 *   the same elements in the same order but only the ones satisfying the predicate (condition)
 *   are kept.
 *
 *   Once it is done, copy-paste the complete class in Inginious also with the imports
 *
 */
public class LinkedListWithFilter {

    Node first = null;
    Node last = null;

    /**
     * Add the element v at the end of the linked list
     * @param v the element to add at the end
     */
    public void add(int v) {
        if (first == null){
            first = new Node(v, null);
            last = first;
        } else {
            last.next = new Node(v, null);
            last = last.next;
        }
    }

    public void add(int ... values) {
        for (int v: values) {
            add(v);
        }
    }

    class Node {
        int v;
        Node next;
        Node(int v, Node next) {
            this.v = v;
            this.next = next;
        }
    }

    /**
     * Compute a new version of the list in the same order
     * but only keeping the ones satisfying
     * the predicate (condition) in argument
     * Read the unit test to make sure you understand
     * @param p the predicate specifying the elements to keep
     * @return a new version of the list, same order but
     *         with only the elements satisfying the predicate
     */
    public LinkedListWithFilter filter(Predicate<Integer> p) {
        LinkedListWithFilter rep = new LinkedListWithFilter();
        Node current = first;
        while (current != null){
            if (p.test(current.v)){
                rep.add(current.v);
            }
            current = current.next;
        }
        return rep;
    }

}

