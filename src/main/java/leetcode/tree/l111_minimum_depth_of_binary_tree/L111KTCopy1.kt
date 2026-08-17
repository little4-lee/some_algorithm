package leetcode.tree.l111_minimum_depth_of_binary_tree

import common.TreeNode
import common.TreeUtils
import kotlin.math.min

class L111KTCopy1 {

    // recursive
    fun minDepth(root: TreeNode?): Int {
        root ?: return 0
        // 根部判断条件
        val minLeft = minDepth(root.left)
        val minRight = minDepth(root.right)

        return if (minLeft == 0 || minRight == 0) {
            // 某侧深度为0，需要使用另一侧的深度
            minLeft + minRight + 1
        } else {
            min(minLeft, minRight) + 1
        }
    }

    //non-recursive
//    fun minDepth(root: TreeNode?): Int {
//        root ?: return 0
//
//        var level = 0
//        // 最小深度逻辑：第一个没有左右子树的节点
//        var findMinDepth = false
//
//        val queue = LinkedList<TreeNode>()
//        queue.offer(root)
//
//        while (queue.isNotEmpty() && !findMinDepth) {
//            level++
//
//            val levelSize = queue.size
//            var index = 0
//            while (index < levelSize) {
//                index++
//                val tempNode = queue.poll()
//                if (tempNode.left == null && tempNode.right == null) {
//                    findMinDepth = true
//                    break
//                }
//                if (tempNode.left != null) {
//                    queue.offer(tempNode.left)
//                }
//                if (tempNode.right != null) {
//                    queue.offer(tempNode.right)
//                }
//            }
//        }
//
//        return level
//    }
}

fun main() {
    println(L111KTCopy1().minDepth(TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6)))
    println(L111KTCopy1().minDepth(TreeUtils.array2Tree(3, 2, 7)))
    println(L111KTCopy1().minDepth(TreeUtils.array2Tree(null, null, null, null)))
    println(L111KTCopy1().minDepth(null))
}