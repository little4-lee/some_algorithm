package _04stack

class StackBasedOnLinkedList {

    private var top: Node? = null

    fun push (value: Int) {

        var newNode = Node(value)
        if (top == null) {
            top = newNode
        } else {
            newNode.next = top
            top = newNode
        }
    }

    fun pop (): Int {
        if (top == null) return -1

        var value = top!!.value
        top = top?.next
        return value
    }

    fun printAll () {
        var p = top
        while (p != null) {
            print(" " + p.value)
            p = p.next
        }
        println()
    }

    companion object {
        class Node(var value: Int) {
            var next: Node? = null
        }
    }
}