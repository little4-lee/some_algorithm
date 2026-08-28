package algo._10dynamic_program

import javax.imageio.metadata.IIOMetadataFormatImpl
import javax.swing.text.StyleContext
import kotlin.math.max


/**
 * @param weights: every object's weight
 * @param n: there are *n objects
 * @param w: the bag weight most *w
 * @return max weight of the bag
 */
private fun knapsack(weights: IntArray, n: Int, w: Int): Int {
    TODO()
}

/**
 * space of 1d array
 * @param weights: every object's weight
 * @param n: there are *n objects
 * @param w: the bag weight most *w
 * @return max weight of the bag
 */
private fun knapsackIn1DArray(weights: IntArray, n: Int, w: Int): Int {
    // 异常数据检查
    require(n >= 0)
    require(w >= 0)
    require(weights.size == n)
    require(weights.all { it >= 0 })

    if (weights.isEmpty() || n == 0 || w == 0) {
        return 0
    }

    val states = BooleanArray(w + 1)

    // 手动初始化第0个物品
    states[0] = true
    if (weights[0] <= w) {
        states[weights[0]] = true
    }

    for (i in 1 until n) {
        // 处理第i个物品
        for (j in w - weights[i] downTo 0) {
            if (states[j]) {
                states[j + weights[i]] = true
            }
        }
    }

    // 找到最大的重量
    for (i in w downTo 0) {
        if (states[i]) return i
    }

    return -1
}


/**
 * @param weights: every object's weight
 * @param values: every object's value
 * @param n: there are *n objects
 * @param w: the bag weight most *w
 * @return max value of the bag
 */
private fun knapsack2(weights: IntArray, values: IntArray, n: Int, w: Int): Int {
    TODO()
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

    if (weights.isEmpty() || values.isEmpty() || n == 0 || w == 0) {
        return 0
    }

    val states = IntArray(w + 1) { -1 }

    // 手动处理第0个物品
    states[0] = 0
    if (weights[0] <= w) {
        states[weights[0]] = values[0]
    }

    // 处理后续的物品
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

    // 找到最大值
    return states.maxOrNull() ?: -1
}

fun main() {
//    println(knapsack(intArrayOf(), 0, 9))
//    println(knapsack(intArrayOf(10, 2, 4, 6, 3), 5, 9))
//    println(knapsack(intArrayOf(2, 2, 4, 6, 3, 5, 7, 1), 8, 28))
//    println()
    println(knapsackIn1DArray(intArrayOf(), 0, 9))
    println(knapsackIn1DArray(intArrayOf(2, 2, 4, 6, 3), 5, 9))
    println(knapsackIn1DArray(intArrayOf(2, 2, 4, 6, 3, 5, 7, 1), 8, 33))
    println()
//    println(knapsack2(intArrayOf(), intArrayOf(), 0, 9))
//    println(knapsack2(intArrayOf(10, 2, 4, 6, 3), intArrayOf(20, 4, 8, 12, 6), 5, 9))
//    println(
//        knapsack2(
//            intArrayOf(2, 2, 4, 6, 3, 5, 7, 1), intArrayOf(4, 4, 8, 12, 6, 10, 14, 2), 8, 28
//        )
//    )
//    println()
    println(knapsack21DArray(intArrayOf(), intArrayOf(), 0, 9))
    println(knapsack21DArray(intArrayOf(10, 2, 4, 6, 3), intArrayOf(20, 4, 8, 12, 6), 5, 9))
    println(
        knapsack21DArray(
            intArrayOf(2, 2, 4, 6, 3, 5, 7, 1), intArrayOf(4, 4, 8, 12, 6, 10, 14, 2), 8, 28
        )
    )
}