package search

fun main() {
    val count = 10000
    val array = Array(count){it}

    val value0 = -100
    val value1 = 1001
    val value2 = 0
    val value3 = 1
    val value4 = 999
    val value5 = 1000
    val value6 = 555

    testSearch(value0, array, ::search0)
    testSearch(value1, array, ::search0)
    testSearch(value2, array, ::search0)
    testSearch(value3, array, ::search0)
    testSearch(value4, array, ::search0)
    testSearch(value5, array, ::search0)
    testSearch(value6, array, ::search0)


}
fun testSearch(value: Int, array: Array<Int>, search: (Int, Array<Int>) -> Int) {
    println("search value: $value")
    val result = search.invoke(value, array)
    println("search result: $result")
    println()
}

//TODO boundary
fun search0(value: Int, array: Array<Int>): Int {
    var low = 0
    var high = array.size - 1

    while (low <= high) {
        val middle = low + (high - low) / 2

        if (value == array[middle]) return middle
        if (value < array[middle]) high = middle - 1
        else low = middle + 1
    }

    return -1
}