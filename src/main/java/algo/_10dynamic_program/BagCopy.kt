package algo._10dynamic_program


/**
 * @param weights: every object's weight
 * @param n: there are *n objects
 * @param w: the bag weight most *w
 * @return max weight of the bag
 */
private fun knapsack(weights: IntArray, n: Int, w: Int): Int {
    // TODO: 边界检查
    // w >= 0
    require(w >= 0)
    // n>=0
    require(n >= 0)
    // weights 元素 >=0
    require(weights.all { it >= 0 })
    // weights.size = n
    require(weights.size == n)
    // 空检查
    if (weights.isEmpty() || n == 0 || w == 0) {
        return 0
    }

    // 二维数组解背包问题
    val states = Array(n) { BooleanArray(w + 1) }
    states[0][0] = true
    if (weights[0] <= w) {
        states[0][weights[0]] = true
    }

    for (i in 1 until n) {
        // 每层循环处理一个物品i
        // 物品i不放入背包
        for (j in 0..w) {
            if (states[i - 1][j]) states[i][j] = true
        }
        // 物品i放入背包
        for (j in w - weights[i] downTo 0) {
            if (states[i - 1][j]) states[i][j + weights[i]] = true
        }
    }

    for (j in w downTo 0) {
        if (states[n - 1][j]) return j
    }

    return 0
}

/**
 * space of 1d array
 * @param weights: every object's weight
 * @param n: there are *n objects
 * @param w: the bag weight most *w
 * @return max weight of the bag
 */
private fun knapsackIn1DArray(weights: IntArray, n: Int, w: Int): Int {
    // TODO: 检查边界
    // n >= 0
    require(n >= 0)
    // w >= 0
    require(w >= 0)
    // weights.size == n
    require(weights.size == n)
    // weights item >= 0
    require (weights.all { it >= 0 })

    // 空校验
    if (weights.isEmpty() || n == 0 || w == 0) {
        return 0
    }

    // 1维数组解背包问题
    val states = BooleanArray(w + 1)

    // 处理第0个背包
    states[0] = true
    if (weights[0] <= w) {
        states[weights[0]] = true
    }

    for (i in 1 until n) {
        // 处理第i个背包
        for (j in w - weights[i] downTo 0) {
            if (states[j]) states[j + weights[i]] = true
        }
    }
    for (i in w downTo 0) {
        if (states[i]) return i
    }
    return 0
}

fun main() {
    println(knapsack(intArrayOf(), 0, 9))
    println(knapsack(intArrayOf(10, 2, 4, 6, 3), 5, 9))
    println(knapsack(intArrayOf(2, 2, 4, 6, 3, 5, 7, 1), 8, 28))
    println(knapsackIn1DArray(intArrayOf(), 0, 9))
    println(knapsackIn1DArray(intArrayOf(2, 2, 4, 6, 3), 5, 9))
    println(knapsackIn1DArray(intArrayOf(2, 2, 4, 6, 3, 5, 7, 1), 8, 33))

}