package _05queue

class LinkedListQueue {

    private var head: Node? = null
    private var tail: Node? = null

    /**
     * 入队
     */
    fun enQueue (value: Int) {
        var newNode = Node(value)
        //空队列
        if (tail == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }
    }

    /**
     * 出队
     */
    fun deQueue (): Int? {
        if (tail == null) return -1

        var value = head?.value
        head = head?.next

        if (head == null) {
            tail = null
        }
        return value
    }

    companion object {
        class Node (var value: Int) {
            var next: Node? = null
        }
    }
}