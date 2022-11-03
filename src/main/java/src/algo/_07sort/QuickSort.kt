package algo._07sort

/**
 * 快速排序
 */
fun quickSort(array: Array<Int?>, n: Int) {
    quickSortInternally(array, 0, n - 1)
}

fun quickSortInternally(array: Array<Int?>, p: Int, r: Int) {
    if (p >= r) return

    var q = partition(array, p, r)
    quickSortInternally(array, p, q - 1)
    quickSortInternally(array, q + 1, r)
}

fun partition(array: Array<Int?>, p: Int, r: Int): Int {
    var pivot = array[r]

    var i = p
    for (j in p..r - 1) {

        if (array[j]!! < pivot!!) {

            if (i == j) {
                i++
            } else {
                var temp = array[i]
                array[i] = array[j]
                array[j] = temp
                i++
            }
        }
    }

    array[r] = array[i]
    array[i] = pivot

    return i
}