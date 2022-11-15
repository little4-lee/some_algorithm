package algo._02array

class ArrayAlgo {

    /**
     * 寻找数组中
     * 超过一半/或刚好占一半
     * 的数字
     */
    fun findHalf(arr: IntArray): Int {
        if (arr.isEmpty()) return -1000

        var candidate = arr[0]
        var times = 0
        var i = 0
        while (i < arr.size) {
            if (candidate == arr[i]) {
                times++
            } else {
                times--
            }
            if (times == 0) {
                if (i == arr.size - 1) {
                    break
                } else {
                    candidate = arr[i + 1]
                    times = 1
                    i++
                }
            }
            i++
        }

        return candidate
    }
}