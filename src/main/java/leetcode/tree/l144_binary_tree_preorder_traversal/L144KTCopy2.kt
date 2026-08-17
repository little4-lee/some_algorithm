package leetcode.tree.l144_binary_tree_preorder_traversal

import algo.utils.printList
import common.TreeNode
import common.TreeUtils
import java.util.*

class L144KTCopy2 {
    fun preorderTraversal(root: TreeNode?): List<Int>? {
        //recursive
//        root ?: return null
//        val list = mutableListOf<Int>()
//        list.add(root.`val`)
//        preorderTraversal(root.left)?.let {
//            list.addAll(it)
//        }
//        preorderTraversal(root.right)?.let {
//            list.addAll(it)
//        }
//        return list
//
        // non recursive
        root ?: return null
        val list = mutableListOf<Int>()
        val stack = Stack<TreeNode>()
        var cur = root

        while (cur != null || stack.isNotEmpty()) {
            // 找到最左边节点
            while (cur != null) {
                list.add(cur.`val`)
                if (cur.right != null) {
                    stack.push(cur.right)
                }
                cur = cur.left
            }
            if (stack.isNotEmpty()) {
                cur = stack.pop()
            }
        }

        return list
    }
}

fun main() {
    printList(L144KTCopy2().preorderTraversal(TreeUtils.array2Tree(3, 6, 7, 5, 0, 2, 8, 0, 0, 0, 0, 4)))
    printList(L144KTCopy2().preorderTraversal(TreeUtils.array2Tree(null)))
    printList(L144KTCopy2().preorderTraversal(null))
//    for (i in list) print("$i ")
}