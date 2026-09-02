package algo._06recursion

import javax.naming.ldap.PagedResultsResponseControl
import javax.print.attribute.standard.RequestingUserName

/**
 * 回溯算法案例
 * @author: zhangjianfei03
 */

fun main() {
    calculate8Queue(0, IntArray(8))
}

/**
 * 8皇后问题，row从0到7
 */
private fun calculate8Queue(row: Int, result: IntArray) {
    if (row < 0) return
    if (result.size != 8) result

    if (row == 8) {
        printResult(result)
        result
    }

    for (column in 0 until 8) {
        if (isOk(row, column, result)) {
            result[row] = column
            calculate8Queue(row + 1, result)
        }
    }
}

/**
 * 是否可以放在当前位置
 * @param row: 行
 * @param column: 列
 * @param result: 检查结果
 */
private fun isOk(row: Int, column: Int, result: IntArray): Boolean {
    if (row < 0 || row > 7) return false
    if (column < 0 || column > 7) return false
    if (result.size != 8) return false

    var leftUp = column - 1
    var rightUp = column + 1
    for (rowI in row - 1 downTo 0) {
        // 检查正上方
        if (result[rowI] == column) return false
        // 检查左上方
        if (leftUp >= 0) {
            if (result[rowI] == leftUp) return false
        }
        // 检查右上方
        if (rightUp < 8) {
            if (result[rowI] == rightUp) return false
        }
        leftUp--
        rightUp++
    }
    return true
}

private fun printResult(result: IntArray) {
    if (result.size != 8) {
        println("result size is not 8")
        result
    }

    println("start print result")
    for (row in 0 until 8) {
        for (column in 0 until 8) {
            if (result[row] == column) print(" Q")
            else print(" *")
        }
        println()
    }
    println("end print result")
}