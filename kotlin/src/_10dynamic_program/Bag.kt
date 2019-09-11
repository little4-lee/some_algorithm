package _10dynamic_program


/**
 * @param weights: every object's weight
 * @param n: there are *n objects
 * @param w: the bag weight most *w
 * @return max weight of the bag
 */
fun knapsack(weights: IntArray, n: Int, w: Int): Int {
    var array = Array(n) { BooleanArray(w + 1) }
    //first row
    array[0][0] = true
    array[0][weights[0]] = true

    for (i in 1 until n) {
        //not pick object i
        for (j in 0..w)
            if (array[i - 1][j]) array[i][j] = true


        //pick object i
        for (k in 0..w - weights[i]) {
            if (array[i - 1][k]) array[i][k + weights[i]] = true
        }
    }

    for (l in w downTo 0)
        if (array[n - 1][l]) return l

    return 0
}

/**
 * space of 1d array
 * @param weights: every object's weight
 * @param n: there are *n objects
 * @param w: the bag weight most *w
 * @return max weight of the bag
 */
fun knapsackIn1DArray(weights: IntArray, n: Int, w: Int): Int {
    var array = BooleanArray(w + 1)

    //first row
    array[0] = true
    array[weights[0]] = true

    for (i in 1 until n) {
        for (j in w - weights[i] downTo 0)//must use downTo here, cause data error otherwise
            if (array[j]) array[j + weights[i]] = true
    }
    for (k in w downTo 0) if (array[k]) return k
    return 0
}

fun main() {
    println(knapsack(intArrayOf(2, 2, 4, 6, 3), 5, 9))
    println(knapsack(intArrayOf(2, 2, 4, 6, 3, 5, 7, 1), 8, 28))
    println(knapsackIn1DArray(intArrayOf(2, 2, 4, 6, 3), 5, 9))
    println(knapsackIn1DArray(intArrayOf(2, 2, 4, 6, 3, 5, 7, 1), 8, 33))

}