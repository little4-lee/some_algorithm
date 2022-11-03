package leetcode.tree.l104_maximum_depth_of_binary_tree

import leetcode.tree.TreeNode
import leetcode.tree.TreeUtils
import kotlin.math.max

class L104KT {
    //recursive
    fun maxDepth(root: _root_ide_package_.leetcode.tree.TreeNode?): Int {
        root ?: return 0

        val l = maxDepth(root.left)
        val r = maxDepth(root.right)

        return max(l, r) + 1
    }
}

fun main() {
    val node = _root_ide_package_.leetcode.tree.TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6, 9)
    println(L104KT().maxDepth(node))
}