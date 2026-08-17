package leetcode.tree.l104_maximum_depth_of_binary_tree

import common.TreeNode
import common.TreeUtils
import java.util.LinkedList
import kotlin.contracts.ReturnsNotNull
import kotlin.math.max

class L104KT3 {
    //recursive
//    fun maxDepth(root: TreeNode?): Int {
//        root ?: return 0
//
//        val maxLeft = maxDepth(root.left)
//        val maxRight = maxDepth(root.right)
//        return max(maxLeft, maxRight) + 1
//    }

    // non recursive

    fun maxDepth(root: TreeNode?): Int {
        root ?: return 0

        var level = 0
        val queue = LinkedList<TreeNode>()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            // 每次遍历一层
            val levelSize = queue.size
            var index = 0
            while (index < levelSize) {
                val tempNode = queue.poll()
                if (tempNode.left != null) {
                    queue.offer(tempNode.left)
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right)
                }
                index++
            }
            level++
        }
        return level
    }
}

fun main() {
    println(L104KT3().maxDepth(TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6, 9)))
    println(L104KT3().maxDepth(TreeUtils.array2Tree(3, 2, 7)))
    println(L104KT3().maxDepth(TreeUtils.array2Tree(null, null, null, null)))
    println(L104KT3().maxDepth(null))
}