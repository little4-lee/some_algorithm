package _03linkedlist

fun main (args: Array<String>) {
    var arr01 = intArrayOf(1, 2, 3, 4, 5)
    var arr02 = null
    var arr03 = intArrayOf(1, 2)
    var arr04 = intArrayOf()

    var list = SinglyLinkedList(arr04)
    var newList = list.reverseList(list.head)


    SinglyLinkedList.printList(newList)
}