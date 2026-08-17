package leetcode.tree.l145_binary_tree_postorder_traversal

import algo.utils.printList
import common.TreeNode
import common.TreeUtils
import java.util.*
import javax.swing.plaf.nimbus.State

class L145KTCopy2 {
    fun postOrderTraversal(root: TreeNode?): List<Int>? {
        root ?: return null

        val list = mutableListOf<Int>()
        val stack = Stack<TreeNode>()
        var cur = root
        var lastVisited: TreeNode? = null

        while (cur != null || stack.isNotEmpty()) {
            // 找到最左边的子节点
            while (cur != null) {
                stack.push(cur)
                cur = cur.left
            }

            if (stack.isNotEmpty()) {
                val tempNode = stack.peek()
                if (tempNode.right == null || lastVisited == tempNode.right) {
                    // 右节点为空，或者右节点被访问过
                    stack.pop()
                    list.add(tempNode.`val`)
                    lastVisited = tempNode
                } else {
                    // 右节点不为空，也没有访问过
                    cur = tempNode.right
                }
            }
        }

        return list
    }
}

fun main() {
    val node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6)

    //        TreeNode node = TreeUtils.array2Tree(3, 6, 7, 5, 0, 2, 8, 0, 0, 0, 0, 4);
//        TreeNode node = TreeUtils.array2Tree(3, 1, 5, 6, 3, 0, 7);


    //        TreeUtils.printTree(node);

    //        TreeNode node = TreeUtils.array2Tree(3, 6, 7, 5, 0, 2, 8, 0, 0, 0, 0, 4);
//        TreeNode node = TreeUtils.array2Tree(3, 1, 5, 6, 3, 0, 7);


    //        TreeUtils.printTree(node);
    printList(L145KTCopy2().postOrderTraversal(node))
}