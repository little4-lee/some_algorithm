package interview.wonders

val observerList = HashSet<String>()

fun remove(string: String) {
    val iterator = observerList.iterator()
    while (iterator.hasNext()) {
        val current = iterator.next()
        if (current == string) {
            iterator.remove()
        }
    }
}

fun notifyA() {
    // TODO: 报错 ConcurrentModificationException,
    //  只能修改notifyA(), 应该怎么改？
    var iterator = observerList.iterator()
    while (iterator.hasNext()) {
        val cur = iterator.next()
        doNotify(cur)
    }
}

fun notifyARefactor() {
    var iterator = observerList.iterator()
    while (iterator.hasNext()) {
        val countBeforeNotify = observerList.count()
        val cur = iterator.next()
        doNotify(cur)
        val countAfterNotify = observerList.count()
        if (countAfterNotify != countBeforeNotify) {
            iterator = observerList.iterator()
        }
    }
}

fun doNotify(cur: String) {
    println(cur)
    observerList.remove(cur)
}

fun main() {

    for (i in 0..10) {
        observerList.add(i.toString())
    }
//    notifyA()
    notifyARefactor()
}