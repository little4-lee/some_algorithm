package leetcode.tree.l145_binary_tree_postorder_traversal

import leetcode.tree.TreeNode
import leetcode.tree.TreeUtils
import java.util.*

class L145KT {
    fun postOrderTraversal(root: _root_ide_package_.leetcode.tree.TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        val stack = Stack<_root_ide_package_.leetcode.tree.TreeNode>()
        var p = root
        var lastVisit: _root_ide_package_.leetcode.tree.TreeNode? = null

        while (p != null || stack.isNotEmpty()) {
            while (p != null) {
                stack.push(p)
                p = p.left
            }
            p = stack.peek()
            if (p.right == null || p.right == lastVisit) {
                stack.pop()
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
    val node = _root_ide_package_.leetcode.tree.TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6)

    //        TreeNode node = TreeUtils.array2Tree(3, 6, 7, 5, 0, 2, 8, 0, 0, 0, 0, 4);
//        TreeNode node = TreeUtils.array2Tree(3, 1, 5, 6, 3, 0, 7);


    //        TreeUtils.printTree(node);

    //        TreeNode node = TreeUtils.array2Tree(3, 6, 7, 5, 0, 2, 8, 0, 0, 0, 0, 4);
//        TreeNode node = TreeUtils.array2Tree(3, 1, 5, 6, 3, 0, 7);


    //        TreeUtils.printTree(node);
    val list = L145KT().postOrderTraversal(node)
    for (i in list) print("$i ")
}