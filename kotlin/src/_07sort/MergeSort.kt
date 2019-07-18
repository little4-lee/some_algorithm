package _07sort

fun mergeSort(array: Array<Int?>, n: Int) {
    mergeSortInternally(array, 0, n - 1)
}

/**
 * 归并排序的递归函数
 */
fun mergeSortInternally(array: Array<Int?>, p: Int, r: Int) {

    var str = ""
    for (i in p..r) {
        str += " " + i
    }

    if (p >= r) return

    var q = p + (r - p) / 2
    mergeSortInternally(array, p, q)
    mergeSortInternally(array, q + 1, r)

//    merge(array, p, q, r)
    mergeWithSoldier(array, p, q, r)
}

/**
 * 合并两个"有序数组"(实际是同一数组的两个有序区间)
 */
fun merge(array: Array<Int?>, p: Int, q: Int, r: Int) {

    var newArray = arrayOfNulls<Int>(r - p + 1)

    var i = p
    var j = q + 1
    var k = 0

    while (i <= q && j <= r) {
        if (array[i]!! < array[j]!!) {
            newArray[k] = array[i]
            i++
        } else {
            newArray[k] = array[j]
            j++
        }
        k++
    }

    if (i <= q) {
        while (i <= q) {
            newArray[k] = array[i]
            k++
            i++
        }
    } else if (j <= r) {
        while (j <= r) {
            newArray[k] = array[j]
            k++
            j++
        }
    }

    for (l in 0..r - p) {
        array[p + l] = newArray[l]!!
    }
}

/**
 * 合并两个"有序数组"(实际是同一数组的两个有序区间)
 * - 使用哨兵
 */
fun mergeWithSoldier(array: Array<Int?>, p: Int, q: Int, r: Int) {
    //两个新数组，分别比原数组多一个元素，用来存放"哨兵"
    var leftArr = arrayOfNulls<Int>(q - p + 2)
    var rightArr = arrayOfNulls<Int>(r - q + 1)

    for (i in 0..q - p) {
        leftArr[i] = array[p + i]
    }
    leftArr[q - p + 1] = Int.MAX_VALUE

    for (j in 0 until r - q) {
        rightArr[j] = array[q + 1 + j]
    }
    rightArr[r - q] = Int.MAX_VALUE

    var i = 0
    var j = 0
    var k = p
    while (k <= r) {
        //这里很棒的一点：当left或right数组达到哨兵节点时,对应的指针不会后移了，知道两个都达到哨兵节点，退出循环
        if (leftArr[i]!! <= rightArr[j]!!) {
            array[k] = leftArr[i]
            i++
        } else {
            array[k] = rightArr[j]
            j++
        }
        k++
    }
}













