package algo._10dynamic_program

import javax.imageio.metadata.IIOMetadataFormatImpl
import kotlin.math.PI
import kotlin.math.max


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
    require(weights.all { it >= 0 })

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

/**
 * @param weights: every object's weight
 * @param values: every object's value
 * @param n: there are *n objects
 * @param w: the bag weight most *w
 * @return max value of the bag
 */
private fun knapsack2(weights: IntArray, values: IntArray, n: Int, w: Int): Int {
    // n >= 0
    require(n >= 0)
    // w >= 0
    require(w >= 0)
    // weights.item >= 0
    require(weights.all { it >= 0 })
    // values.item >= 0
    require(values.all { it >= 0 })
    // weights.size == n && values.size == n
    require(weights.size == n && values.size == n)

    // 空检查
    if (weights.isEmpty() || values.isEmpty() || n == 0 || w == 0) {
        return 0
    }

    val states = Array(n) { IntArray(w + 1) { -1 } }

    states[0][0] = 0
    if (weights[0] <= w) {
        states[0][weights[0]] = values[0]
    }

    for (i in 1 until n) {
        // 不选择物品i
        for (j in 0..w) {
            if (states[i - 1][j] >= 0) {
                states[i][j] = states[i - 1][j]
            }
        }
        // 选择物品i
        for (j in 0..w - weights[i]) {
            if (states[i - 1][j] >= 0) {
                // 改变后的值
                val v = states[i - 1][j] + values[i]
                if (v > states[i][j + weights[i]]) {
                    states[i][j + weights[i]] = v
                }
            }
        }
    }

    var maxValue = 0
    for (i in w downTo 0) {
        if (states[n - 1][i] > maxValue) {
            maxValue = states[n - 1][i]
        }
    }
    return maxValue
}


/**
 * @param weights: every object's weight
 * @param values: every object's value
 * @param n: there are *n objects
 * @param w: the bag weight most *w
 * @return max value of the bag
 */
private fun knapsack21DArray(weights: IntArray, values: IntArray, n: Int, w: Int): Int {
    // 边界检查
    require(n >= 0)
    require(w >= 0)
    require(weights.all { it >= 0 })
    require(values.all { it >= 0 })
    require(weights.size == n && values.size == n)

    // 空检查
    if (weights.isEmpty() || values.isEmpty() || n == 0 || w == 0) {
        return 0
    }

    val states = IntArray(w + 1) { -1 }

    // 手动初始化第一个物品
    states[0] = 0
    if (weights[0] <= w) {
        states[weights[0]] = values[0]
    }

    for (i in 1 until n) {
        // 处理第i个物品
        for (j in w - weights[i] downTo 0) {
            if (states[j] >= 0) {
                val tempValue = states[j] + values[i]
                if (tempValue > states[j + weights[i]]) {
                    states[j + weights[i]] = tempValue
                }
            }
        }
    }

    var maxValue = -1
    for (i in w downTo 0) {
        if (states[i] > maxValue) {
            maxValue = states[i]
        }
    }
    return maxValue
}

fun main() {
    println(knapsack(intArrayOf(), 0, 9))
    println(knapsack(intArrayOf(10, 2, 4, 6, 3), 5, 9))
    println(knapsack(intArrayOf(2, 2, 4, 6, 3, 5, 7, 1), 8, 28))
    println()
    println(knapsackIn1DArray(intArrayOf(), 0, 9))
    println(knapsackIn1DArray(intArrayOf(2, 2, 4, 6, 3), 5, 9))
    println(knapsackIn1DArray(intArrayOf(2, 2, 4, 6, 3, 5, 7, 1), 8, 33))
    println()
    println(knapsack2(intArrayOf(), intArrayOf(), 0, 9))
    println(knapsack2(intArrayOf(10, 2, 4, 6, 3), intArrayOf(20, 4, 8, 12, 6), 5, 9))
    println(
        knapsack2(
            intArrayOf(2, 2, 4, 6, 3, 5, 7, 1), intArrayOf(4, 4, 8, 12, 6, 10, 14, 2), 8, 28
        )
    )
    println()
    println(knapsack21DArray(intArrayOf(), intArrayOf(), 0, 9))
    println(knapsack21DArray(intArrayOf(10, 2, 4, 6, 3), intArrayOf(20, 4, 8, 12, 6), 5, 9))
    println(
        knapsack21DArray(
            intArrayOf(2, 2, 4, 6, 3, 5, 7, 1), intArrayOf(4, 4, 8, 12, 6, 10, 14, 2), 8, 28
        )
    )
}