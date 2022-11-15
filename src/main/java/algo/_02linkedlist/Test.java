package algo._02linkedlist;

public class Test {
    public static void main (String [] args) {
//        int [] data = {1,1,1,1,1,1,2,3,4,4,4};
//        int [] data = {1};
        int [] data = {1, 2, 3, 3, 2, 1};

        SinglyLinkedList linkedList = new SinglyLinkedList(data);
//        linkedList.printLinkedList();
//        linkedList.deleteFirstByValue(1);
//        linkedList.deleteAllByValue(1);
        System.out.println("is p? " + linkedList.isPalindromicNumber());
    }
}
