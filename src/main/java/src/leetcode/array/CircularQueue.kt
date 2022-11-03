package leetcode.array

/**
 * 基于数组的循环队列
 */
class CircularQueue(capacity: Int) {
    private val array = arrayOfNulls<String>(capacity)
    private var head = 0
    private var tail = 0

    fun enqueue(element: String): Boolean {
        if (isFull()) return false

        array[tail] = element
        tail++
        return true
    }

    fun dequeue(): String? {
        if (isEmpty()) return null

        val element = array[head]
        head++
        return element
    }

    private fun isEmpty(): Boolean = head == tail

    private fun isFull(): Boolean = (tail + 1) % array.size == head


}

fun main() {
    val queue = CircularQueue(20)
    repeat(100) {
        val result = queue.enqueue(it.toString())
        println("enqueue $it, success: $result")
    }

    repeat(100) {
        val result = queue.dequeue()
        println("dequeue time: $it, result: $result")
    }
}