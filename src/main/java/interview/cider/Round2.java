package interview.cider;

public class Round2 {
   public static void main(String[] args) {
      test();
   }

   public static void test() {
      // null
      printList(
              reverseBetween(null, 0, 0)
      );
      //1 2 3 4 5 2-4
      printList(
              reverseBetween(getSampleList(), 2, 4)
      );
      //1 2 3 4 5 1-5
      printList(
              reverseBetween(getSampleList(), 1, 5)
      );
      //1 2 3 4 5 4-5
      printList(
              reverseBetween(getSampleList(), 4, 5)
      );
   }

   private static ListNode getSampleList() {
      ListNode solder = new ListNode(0);
      ListNode p = solder;
      for (int i = 1; i <= 5; i++) {
         p.next = new ListNode(i);
         p = p.next;
      }
      return solder.next;
   }

   private static void printList(ListNode head) {
      if (head == null) {
         System.out.println("empty list");
         return;
      }

      ListNode p = head;
      while (p != null) {
         System.out.print(p.val + " ");
         p = p.next;
      }
      System.out.println();
   }

   /**
    * 反转部分链表
    * 1->2->3->4->5
    * 开始 2 结束 4
    *
    * 反转之后：
    * 1->4->3->2->5
    * @return
    */
   private static ListNode reverseBetween(ListNode head, int m, int n) {
      if (head == null) return null;

      ListNode solder = new ListNode(0);
      solder.next = head;

      ListNode p = solder;
      ListNode start = null;
      ListNode preStart = null;
      int cur = 0;
      while (cur <= n) {
         ListNode pNext = p.next;
         if (cur == m - 1) {
            preStart = p;
         } else if (cur >= m && cur <= n) {
            if (cur == m) {
               start = p;
            }
            p.next = preStart.next;
            preStart.next = p;
         }

         p = pNext;
         cur++;
      }
      start.next = p;
      return solder.next;
   }


   private static class ListNode {
      ListNode next;
      int val;

      public ListNode(int val) {
         this.val = val;
      }
   }
}
