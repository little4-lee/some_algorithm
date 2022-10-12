package _02linkedlist;

public class Node {
    private int data;
    private Node next;

    public Node (int data) {
        this.data = data;
    }

    public int getData () {
        return this.data;
    }

    public void setData (int data) {
        this.data = data;
    }

    public Node getNext () {
        return this.next;
    }

    public void setNext (Node node) {
        this.next = node;
    }

    public static void main(String[] args) {
        System.out.println("this is main");
    }
}
