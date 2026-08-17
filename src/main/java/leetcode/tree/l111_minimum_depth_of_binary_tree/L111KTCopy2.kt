package leetcode.tree.l111_minimum_depth_of_binary_tree

import common.TreeNode
import common.TreeUtils
import java.util.LinkedList
import kotlin.math.min

class L111KTCopy2 {

    // recursive
//    fun minDepth(root: TreeNode?): Int {
//        root ?: return 0
//        val minLeft = minDepth(root.left)
//        val minRight = minDepth(root.right)
//
//        return if (minLeft == 0 || minRight == 0) {
//            minLeft + minRight + 1
//        } else {
//            // 左右都不为0
//            minOf(minLeft, minRight) + 1
//        }
//    }

    // non recursive
    fun minDepth(root: TreeNode?): Int {
        // TODO:  边界检查
        root ?: return 0

        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        var level = 0
        var findMinDepth = false

        while (queue.isNotEmpty() && !findMinDepth) {
            level++
            // 每次处理一层
            val levelSize = queue.size
            var index = 0
            while (index < levelSize) {
                index++
                val tempNode = queue.poll()
                // 节点判断
                if (tempNode.left == null && tempNode.right == null) {
                    findMinDepth = true
                    break
                }
                if (tempNode.left != null) {
                    queue.offer(tempNode.left)
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right)
                }
            }
        }

        return level
    }

    //non-recursive
}

fun main() {
    println(L111KTCopy2().minDepth(TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6)))
    println(L111KTCopy2().minDepth(TreeUtils.array2Tree(3, 2, 7)))
    println(L111KTCopy2().minDepth(TreeUtils.array2Tree(null, null, null, null)))
    println(L111KTCopy2().minDepth(null))
}
