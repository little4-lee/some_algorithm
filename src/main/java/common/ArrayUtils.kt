package common

fun printArray(arr: IntArray?) {
    if (arr == null) {
        println("null array")
        return
    }
    print("[ ")
    for (i in arr) print("$i ")
    print("]")
}