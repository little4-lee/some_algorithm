package leetcode.linkedlist.l234_is_palindrome;

import leetcode.linkedlist.ListNode;
import linkedlist.NodesKt;

public class L234 {
    public boolean isPalindrome (ListNode head) {
        if (head == null) return true;
        if (head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode flag = new ListNode(0);

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode slowNext = slow.next;

            slow.next = flag.next;
            flag.next = slow;
            slow = slowNext;
        }

        if (fast == null) {
            //odd
            return same(flag.next, slow.next);
        } else {
            //even
            ListNode slowNext = slow.next;
            slow.next = flag.next;
            flag.next = slow;
            return same(flag.next, slowNext);
        }
    }

    public boolean same (ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.val == p2.val) {
                p1 = p1.next;
                p2 = p2.next;
                continue;
            }
            return false;
        }

        if (p1 == null && p2 == null) {
            return true;
        } else {
            return false;
        }
    }

    public static void main (String[] args) {
        ListNode head1 = NodesKt.arrayToList(1, 2, 3, 4, 5);
        ListNode head2 = NodesKt.arrayToList(1,2,3,4,5,4,3,2,1);
        ListNode head3 = NodesKt.arrayToList(1,2,3,4,5,4,3,2,1);
        ListNode head4 = NodesKt.arrayToList(1,2,1);
        ListNode head5 = NodesKt.arrayToList(1,2);
        ListNode head6 = NodesKt.arrayToList(1);
        ListNode head7 = NodesKt.arrayToList();

        L234 obj = new L234();
        System.out.println(obj.isPalindrome(head1));
        System.out.println(obj.isPalindrome(head2));
        System.out.println(obj.isPalindrome(head3));
        System.out.println(obj.isPalindrome(head4));
        System.out.println(obj.isPalindrome(head5));
        System.out.println(obj.isPalindrome(head6));
        System.out.println(obj.isPalindrome(head7));
    }
}
