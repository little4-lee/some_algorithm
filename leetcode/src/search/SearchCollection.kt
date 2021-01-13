package search

fun main() {
    val count = 10000
    val arrIncrease = Array(count) { it }
    val arrDuplicate = Array(count) { 1 }
//    val search = ::search0
//    val search = ::bSearchExt01
//    val search = ::bSearchExt02
//    val search = ::bSearchExt03
    val search = ::bSearchExt04

    val value0 = -100
    val value1 = 1001
    val value2 = 0
    val value3 = 1
    val value4 = 999
    val value5 = 1000
    val value6 = 555
    val value7 = 1

    testSearch(value0, arrIncrease, search)
    testSearch(value1, arrIncrease, search)
    testSearch(value2, arrIncrease, search)
    testSearch(value3, arrIncrease, search)
    testSearch(value4, arrIncrease, search)
    testSearch(value5, arrIncrease, search)
    testSearch(value6, arrIncrease, search)
    testSearch(value7, arrDuplicate, search)

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

/**
 * binary search ext01:
 * return 1st index when the value equals target
 * if null return -1
 */
fun bSearchExt01(target: Int, arr: Array<Int>): Int {
    var low = 0
    var high = arr.size - 1

    while (low <= high) {
        val mid = low + ((high - low) shr 1)
        when {
            target > arr[mid] -> {
                low = mid + 1
            }
            target < arr[mid] -> {
                high = mid - 1
            }
            else -> {
                if (mid == 0 || arr[mid - 1] != target) return mid
                else high = mid - 1
            }
        }
    }

    return -1
}

/**
 * binary search ext02:
 * return last index when the value equals target
 * if null return -1
 */
fun bSearchExt02(target: Int, arr: Array<Int>): Int {
    var lo = 0
    var hi = arr.size - 1

    while (lo <= hi) {
        val mid = lo + ((hi - lo) shr 1)

        when {
            target < arr[mid] -> hi = mid - 1
            target > arr[mid] -> lo = mid + 1
            else -> {
                if (mid == arr.size - 1 || arr[mid + 1] != target) return mid
                else lo = mid + 1
            }
        }
    }

    return -1
}

/**
 * binary search ext03
 * return first element that not less than target
 * if null return -1
 */
fun bSearchExt03(target: Int, arr: Array<Int>): Int {
    var lo = 0
    var hi = arr.size - 1

    while (lo <= hi) {
        val mid = lo + ((hi - lo) shr 1)
        if (arr[mid] >= target) {
            if (mid == 0 || arr[mid - 1] < target) return mid
            else hi = mid - 1
        } else {
            lo = mid + 1
        }
    }

    return -1
}

/**
 * binary search ext04
 * return last element that not more than target
 * if null return -1
 */
fun bSearchExt04(target: Int, arr: Array<Int>): Int {
    var lo = 0
    var hi = arr.size - 1

    while (lo <= hi) {
        val mid = lo + ((hi - lo) shr 1)
        if (arr[mid] <= target) {
            if (mid == arr.size - 1 || arr[mid + 1] > target) return mid
            else lo = mid + 1
        } else {
            hi = mid - 1
        }
    }

    return -1
}