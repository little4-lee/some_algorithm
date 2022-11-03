package leetcode.tree.l145_binary_tree_postorder_traversal

import common.TreeNode
import common.TreeUtils
import java.util.*

class L145KTCopy {
    fun postOrderTraversal(root: TreeNode?): List<Int> {
        var p = root
        val list = mutableListOf<Int>()
        val s = Stack<TreeNode>()
        var lastVisit: TreeNode? = null

        while (p != null || s.isNotEmpty()) {
            while (p != null) {
                s.push(p)
                p = p.left
            }

            p = s.peek()

            if (p.right == null || p.right == lastVisit) {
                s.pop()
                list.add(p.`val`)
                lastVisit = p
                p = null
            } else {
                p = p.right
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
    val list = L145KTCopy().postOrderTraversal(node)
    for (i in list) print("$i ")
}