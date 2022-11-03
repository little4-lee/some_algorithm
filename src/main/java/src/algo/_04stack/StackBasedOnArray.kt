package algo._04stack

class StackBasedOnArray {

    private var count: Int
    private val LENGTH_UNIT = 10
    private var data: Array<Int?>? = null

    constructor() {
        data = arrayOfNulls(LENGTH_UNIT)
        count = 0
    }

    fun push (value: Int) {
        if (count == (data?.size)) {
            var newArray = arrayOfNulls<Int>(2 * data!!.size)
            data = copyToNewArray(newArray, data)
        }

        data!![count] = value
        count++
    }

    private fun copyToNewArray(newArray: Array<Int?>, oldArray: Array<Int?>?): Array<Int?>? {

        if (oldArray == null) return newArray

        for (i in oldArray.indices) {
            newArray[i] = oldArray[i]
        }

        return newArray
    }

    fun pop (): Int {
        if (count == 0) return -1

        count--
        return data!![count]!!
    }

    fun printAll () {
        if (count == 0) println("stack is empty")

        for (items in data!!) {
            print(" " + items)
        }

        println()
    }
}