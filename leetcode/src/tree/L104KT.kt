package tree

import kotlin.math.max

class L104KT {
    //recursive
    fun maxDepth(root: TreeNode?): Int {
        root ?: return 0

        val l = maxDepth(root.left)
        val r = maxDepth(root.right)

        return max(l, r) + 1
    }
}

fun main() {
    val node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6, 9)
    println(L104KT().maxDepth(node))
}