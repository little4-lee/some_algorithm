package tree

import java.util.*
import kotlin.test.todo

class L144KTCopy {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        var p = root
        val s = Stack<TreeNode>()

        while (p != null || s.isNotEmpty()) {
            while (p != null) {
                list.add(p.`val`)
                p.right?.let { s.push(it) }
                p = p.left
            }
            if (s.isNotEmpty()) p = s.pop()
        }
        return list
    }
}

fun main() {
    val node = TreeUtils.array2Tree(3, 6, 7, 5, 0, 2, 8, 0, 0, 0, 0, 4)
//    val node = TreeUtils.array2Tree(3, 1, 5, 6, 3, 0, 7)
//        TreeUtils.printTree(node);

//        TreeUtils.printTree(node);
    val list = L144KT().preorderTraversal(node)
    for (i in list) print("$i ")
}