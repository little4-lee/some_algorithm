package algo._06recursion

import javax.imageio.metadata.IIOMetadataFormatImpl

class RecursionPractice {

    fun findLine(line: Int) : Int{
        if (line == 1) return 1

        else return findLine(line-1) + 1
    }

    fun upstartsWay (level: Int) : Int{

        if (level == 1) return 1
        if (level == 2) return 2

        return upstartsWay(level - 1) + upstartsWay(level - 2)
    }

    /**
     * 非递归实现爬楼梯
     * 逻辑：用循环模拟入栈出栈
     */
    fun upstartsWayNonRecursive(level: Int): Int {
        if (level <= 0) return 0
        if (level == 1) return 1
        if (level == 2) return 2
        var ret = 0
        var pre = 2
        var prepre = 1
        for (i in 3 .. level) {
            ret = pre + prepre
            prepre = pre
            pre = ret
        }
        return ret
    }
}

fun main() {
    val recursiveSample = RecursionPractice()
    println(recursiveSample.upstartsWayNonRecursive(50))
    println(recursiveSample.upstartsWay(50))
}