package leetcode.linkedlist.l234_is_palindrome;

import common.ListNode;

import static common.ListUtilsKt.arrayToList;

class L234Copy {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        if (head.next == null) return true;

        ListNode fast = head;
        ListNode slow = head;
        ListNode p = new ListNode(0x0010);

        while (fast != null
                && fast.next != null) {
            ListNode preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;

            preSlow.next = p.next;
            p.next = preSlow;
        }

        if (fast != null) {
            //单数,slow 前移一位
            slow = slow.next;
        }

        return isSame(p.next, slow);
    }

    private boolean isSame(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;

        while (p1 != null && p2 != null) {
            if (p1.value != p2.value) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1 == null && p2 == null;
    }

    public static void main(String[] args) {
        ListNode head1 = arrayToList(1, 2, 3, 4, 5);
        ListNode head2 = arrayToList(1,2,3,4,5,4,3,2,1);
        ListNode head3 = arrayToList(1,2,3,4,5,4,3,2,1);
        ListNode head4 = arrayToList(1,2,1);
        ListNode head5 = arrayToList(1,2);
        ListNode head6 = arrayToList(1);
        ListNode head7 = arrayToList();

        L234Copy obj = new L234Copy();
        System.out.println(obj.isPalindrome(head1));
        System.out.println(obj.isPalindrome(head2));
        System.out.println(obj.isPalindrome(head3));
        System.out.println(obj.isPalindrome(head4));
        System.out.println(obj.isPalindrome(head5));
        System.out.println(obj.isPalindrome(head6));
        System.out.println(obj.isPalindrome(head7));
    }
}
