package leetcode.linkedlist.l92_reverse_linked_list_2;

import common.ListNode;

import static common.ListUtilsKt.arrayToList;
import static common.ListUtilsKt.printList;

class L92Copy3 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;

        ListNode solder = new ListNode(0);
        solder.next = head;
        
        int count = 1;
        ListNode start = null;
        ListNode preStart = null;
        ListNode p = head;
        
        if (m == 1) {
            preStart = solder;
        }
        
        while (count <= n) {
            ListNode pNext = p.next;
            
            if (count < m) {
                //before reverse
                if (count == m - 1) {
                    preStart = p;
                }
            } else {
                //do reverse
                if (count == m) {
                    start = p;
                }
                p.next = preStart.next;
                preStart.next = p;
            }
            
            count++;
            p = pNext;
        }
        
        //merge list
        start.next = p;
        return solder.next;
    }
    
    public static void main(String[] args) {

        ListNode list1 = arrayToList(1);
        ListNode list2 = arrayToList(1, 2);
        ListNode list3 = arrayToList(1, 2, 3, 4, 5);


        printList(new L92Copy3().reverseBetween(arrayToList(1), 1, 1));
        System.out.println();

        printList(new L92Copy3().reverseBetween(arrayToList(1, 2), 1, 1));
        System.out.println();
        printList(new L92Copy3().reverseBetween(arrayToList(1, 2), 2, 2));
        System.out.println();
        printList(new L92Copy3().reverseBetween(arrayToList(1, 2), 1, 2));


        System.out.println();
        printList(new L92Copy3().reverseBetween(arrayToList(1, 2, 3, 4, 5), 2, 4));
        System.out.println();
        printList(new L92Copy3().reverseBetween(arrayToList(1, 2, 3, 4, 5), 2, 2));
    }
}
