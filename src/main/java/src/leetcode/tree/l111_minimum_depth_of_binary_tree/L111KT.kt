package leetcode.tree.l111_minimum_depth_of_binary_tree

import common.TreeNode
import common.TreeUtils
import java.util.concurrent.LinkedBlockingQueue

class L111KT {
    //recursive
//    fun minDepth(root: TreeNode?): Int {
//        root ?: return 0
//        val l = minDepth(root.left)
//        val r = minDepth(root.right)
//        return min(l, r) + 1
//    }

    //non-recursive
    fun minDepth(root: TreeNode?): Int {
        root ?: return 0

        val queue = LinkedBlockingQueue<TreeNode>()
        queue.offer(root)

        var level = 0
        var cur = 0
        var count = 0

        var isStop = false

        while (queue.isNotEmpty() && !isStop) {
            level++
            cur = 0
            count = queue.size

            while (cur < count) {
                cur++
                val p = queue.poll()

                if (p.left == null && p.right == null) {
                    isStop = true
                    break
                }
                if (p.left != null) queue.offer(p.left)
                if (p.right != null) queue.offer(p.right)
            }
        }

        return level
    }
}

fun main() {
    val node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6)
    println(L111KT().minDepth(node))
}