package leetcode.tree.l102_binary_tree_level_order_traversal

import common.TreeNode
import common.TreeUtils
import java.util.LinkedList

class L102KTCopy11 {
    fun levelOrder(root: TreeNode?): List<List<Int>>? {
        if (root == null) {
            return null
        }
        val list = mutableListOf<List<Int>>()
        val queue = LinkedList<TreeNode>()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            // 每次便利一行
            val levelSize = queue.size
            val levelList = mutableListOf<Int>()
            var index = 0
            while (index < levelSize) {
                // 每次遍历一个节点
                val tempNode = queue.poll()
                levelList.add(tempNode.`val`)
                if (tempNode.left != null) {
                    queue.offer(tempNode.left)
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right)
                }
                index++
            }
            list.add(levelList)
        }
        return list
    }
}

fun main() {
    val node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6)
    val list = L102KTCopy11().levelOrder(node)
    for (l in list.orEmpty()) {
        for (i in l)
            print("$i ")
        println()
    }
}
