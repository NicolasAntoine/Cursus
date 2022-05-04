
/**
 * Question:
 *
 * You are asked to merge two sorted linked lists (see the TODO below) but you need to
 * keep only one node for each distinct value
 *
 * Once it is done, copy-paste the complete class in Inginious, including the imports
 *
 *
 * Feel free to add methods or fields in the class, but do not modify
 * the signature and behavior of existing code
 *
 */
public class MergeSortedLinkedListDuplicate {


    /**
     * You receive two linked lists containing elements in increasing order.
     * You are asked to return a new linked list that contains the
     * elements of both linked lists in increasing order but without duplicates.
     * The input linked lists must remain unchanged.
     * Moreover, the final linkedList must not contain duplicate values
     * That is, instead of 1-1-2-5, you must return 1-2-5.
     *
     * The complexity of your method must be in O(n+m)
     * where n = size of list1, m = size of list2
     * @param list1 the first list containing elements in increasing order
     * @param list2 the second list containing elements in increasing order
     * @return a list that contains the elements of list1 and list2 in increasing order without duplicates
     */
    public static Node merge(Node list1, Node list2) {
        Node first = null;
        Node last = null;
        int v;
        if (list1 == null && list2 == null){
            return null;
        }
        while (list1!=null || list2!=null){
            if (list1 == null){
                v = list2.value;
                list2 = list2.next;
            } else if (list2 == null){
                v = list1.value;
                list1 = list1.next;
            } else {
                if (list1.value < list2.value) {
                    v = list1.value;
                    list1 = list1.next;
                } else if (list1.value > list2.value) {
                    v = list2.value;
                    list2 = list2.next;
                } else {
                    v = list1.value;
                    list1 = list1.next;
                    list2 = list2.next;
                }
            }
            if (first == null){
                first = new Node(v, null);
                last = first;
            } else {
                boolean test = true;
                Node current = first;
                while (current != null){
                    if (current.value == v){
                        test = false;
                    }
                    current = current.next;
                }
                if (test){
                    last.next = new Node(v, null);
                    last = last.next;
                }
            }
        }
        return first;

    }


    static class Node {

        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }
}
