package common

import java.util.Arrays

fun printArray(arr: IntArray?) {
    if (arr == null) {
        print("null array")
        return
    }
    print("[ ")
    for (i in arr) print("$i ")
    print("]")
}

fun swap(arr: IntArray?, i: Int, j: Int) {
    arr?.apply {
        val n = size
        //check
        if (i < 0 || i >= n || j < 0 || j >= n || i == j) return@apply
        val tmp = this[i]
        this[i] = this[j]
        this[j] = tmp
    }
}

fun <T> swap(arr: Array<T>?, i: Int, j: Int) {
    arr?.apply {
        val n = size
        //check
        if (i < 0 || i >= n || j < 0 || j >= n || i == j) return
        val tmp = this[i]
        this[i] = this[j]
        this[j] = tmp
    }
}