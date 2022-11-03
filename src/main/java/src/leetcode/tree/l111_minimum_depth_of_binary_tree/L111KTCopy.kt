package leetcode.tree.l111_minimum_depth_of_binary_tree

import leetcode.tree.TreeNode
import leetcode.tree.TreeUtils
import java.util.concurrent.LinkedBlockingQueue

class L111KTCopy {


    //non-recursive
    fun minDepth(root: _root_ide_package_.leetcode.tree.TreeNode?): Int {
        root ?: return 0

        val queue = LinkedBlockingQueue<_root_ide_package_.leetcode.tree.TreeNode>()
        queue.offer(root)

        var isStop = false
        var cur: Int
        var count: Int
        var level = 0

        while (queue.isNotEmpty() && !isStop) {
            cur = 0
            count = queue.size
            level++

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
    val node = _root_ide_package_.leetcode.tree.TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6)
//    val node = TreeUtils.array2Tree(null)
    println(L111KTCopy().minDepth(node))
}