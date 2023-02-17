package interview.baidu;

import common.ListNode;

public class Round1 {
   public static void main(String[] args) {

   }

   private static boolean hasCycle(ListNode head) {
      if (head == null) return false;

      ListNode fast = head;
      ListNode slow = head;

      while (fast != null && fast.next != null) {
         fast = fast.next.next;
         slow = slow.next;
         if (fast == slow) return true;
      }

      return false;
   }
}
