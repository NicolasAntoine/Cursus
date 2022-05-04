public class TwoNumbers {
     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) {
              this.val = val;
          }
          ListNode(int val, ListNode next) {
              this.val = val; this.next = next;
          }
     }
    static class Solution {
        public static ListNode addTwoNumbers(int[] l1, int[] l2) {
            char[] test = l1.toCharArray();
            for (int i = 0; i < l1.length; i++) {
                helper += (String) helper[i];
            }
            System.out.println(helper);
        }


        public static void main(String[] args) {
            //Input: l1 = [2,4,3], l2 = [5,6,4]
            //Output: [7,0,8]
            //Explanation: 342 + 465 = 807
        }
    }


}
