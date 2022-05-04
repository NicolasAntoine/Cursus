import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyStack<E> {

    private LinkedList<E> queue;
    /*
     * Constructor
     */
    public MyStack() {
        this.queue = new LinkedList<>();
    }

    /**
     * Push an element on the stack
     *
     * @param elem the Element to push
     */
    public void push(E elem) {
        queue.add(elem);
    }

    /**
     * Remove the element at the top of the stack
     *
     * @return The element at the top of the stack
     */
    public E pop() {
        E elem = queue.remove(queue.size()-1);
        return elem;
    }

    /**
     * Look at the element at the top of the stack
     *
     * @return The element at the top of the stack
     */
    public E peek() {
        E elem = queue.remove(queue.size()-1);
        queue.add(elem);
        return elem;
    }

    /**
     * Is the stack empty
     *
     * @return True if there is no element in the stack
     *         and false otherwise
     */
    public boolean empty() {
        return queue.isEmpty();
    }

}
