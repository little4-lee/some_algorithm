package algo._02array

fun main() {
    var intArray1 = intArrayOf(1,1,1,1,1,2)
    var intArray2 = intArrayOf(1,2,2,2,1,2)
    var intArray3 = intArrayOf(1,2,3,4,4,4)
    var intArray4 = intArrayOf(1,3,1,3,3,2)
    var intArray5 = intArrayOf(1,5,5,5,1,5)

    var arrs = arrayOf(intArray1, intArray2, intArray3, intArray4, intArray5)

    for (intarray in arrs) {
        println(ArrayAlgo().findHalf(intarray))
    }
}