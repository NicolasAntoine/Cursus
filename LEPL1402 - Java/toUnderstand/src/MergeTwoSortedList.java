public class MergeTwoSortedList {
    ListNode head;
    ListNode last;
    Integer size;

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    MergeTwoSortedList(ListNode head, ListNode last, Integer size){
        this.head = head;
        this.last = last;
        this.size = size;
    }

    public void add(int val){
        if (head == null){
            head = new ListNode(val, null);
            last = head;
            size++;
        } else {
            last.next = new ListNode(val, null);
            last = last.next;
            size++;
        }
    }

    public ListNode mergeTwoSortedList(MergeTwoSortedList list1, MergeTwoSortedList list2) {
        if (list1 == null && list2 == null){
            return null;
        } else if (list1 == null){
            return list2.head;
        } else if (list2 == null){
            return list1.head;
        } else {
            Integer valeur;
            if (list1.head.val > )
        }

    }

    public static void main(String[] args) {
        MergeTwoSortedList liste = new MergeTwoSortedList(null, null, 0);
        MergeTwoSortedList liste2 = new MergeTwoSortedList(null, null, 0);

        liste.add(1);
        liste.add(2);
        liste.add(4);

        liste2.add(1);
        liste2.add(3);
        liste2.add(4);

        ListNode current = liste.head;
        while (current != liste.last){
            System.out.println(current.val);
            current = current.next;
        }
        System.out.println(liste.last.val);
        System.out.println(liste.size);
    }

}

