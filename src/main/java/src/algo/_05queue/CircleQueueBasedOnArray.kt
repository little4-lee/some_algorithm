package algo._05queue

class CircleQueueBasedOnArray {
    private var array: Array<String?>? = null
    private var capacity = 0
    private var head = 0
    private var tail = 0

    constructor(capacity: Int) {
        array = arrayOfNulls<String?>(capacity)
        this.capacity = capacity
    }

    fun enQueue(value: String): Boolean {
        //队满
        if ((tail + 1) % capacity == head) return false

        array!![tail] = value
        tail = (tail + 1) % capacity
        return true
    }

    fun deQueue(): String? {
        if (head == tail) return null

        var ret = array!![head]
        head = (head + 1) % capacity

        return ret
    }

    fun printAll() {
        if (head == tail) {
            println("queue is empty")
            return
        }

        var p = head
        while (p != tail) {
            print(" " + array!![p])
            p = (p + 1) % capacity
        }
        println()
    }
}