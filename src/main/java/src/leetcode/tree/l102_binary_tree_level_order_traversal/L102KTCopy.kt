package leetcode.tree.l102_binary_tree_level_order_traversal

import leetcode.tree.TreeNode
import leetcode.tree.TreeUtils
import java.util.concurrent.LinkedBlockingQueue

class L102KTCopy {
    fun levelOrder(root: _root_ide_package_.leetcode.tree.TreeNode?): List<List<Int>> {
        root ?: return mutableListOf()

        val list = mutableListOf<List<Int>>()
        val queue = LinkedBlockingQueue<_root_ide_package_.leetcode.tree.TreeNode>()
        queue.offer(root)
        var p = root

        var cur = 0
        var countInLevel = 0

        while (queue.isNotEmpty()) {
            cur = 0
            countInLevel = queue.size
            val innerList = mutableListOf<Int>()
            list.add(innerList)

            while (cur < countInLevel)
                queue.poll().apply {
                    cur++
                    innerList.add(this.`val`)
                    left?.let { queue.offer(it) }
                    right?.let { queue.offer(it) }
                }
        }

        return list
    }
}

fun main() {
    val node = _root_ide_package_.leetcode.tree.TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6)
    val list = L102KTCopy().levelOrder(node)
    for (l in list) {
        for (i in l)
            print("$i ")
        println()
    }
}