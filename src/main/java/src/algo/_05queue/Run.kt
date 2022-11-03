package algo._05queue

fun main() {
    var queue = CircleQueueBasedOnArray(10)
    for (i in 1..50) {
        print("(" + i + ")")
        if (RandomUtil.toDo()) {
            var string = RandomUtil.ranString()
            println("enqueue " + string + " success? :" + queue.enQueue(string))
        } else {
            println("dequeue :" + queue.deQueue())
        }
        queue.printAll()
        println()
    }
}