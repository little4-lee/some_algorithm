package leetcode.tree.l111_minimum_depth_of_binary_tree

import common.TreeNode
import common.TreeUtils
import kotlin.math.min

class L111KTCopy2 {

    // recursive
    fun minDepth(root: TreeNode?): Int {
        return TODO("Implement minDepth")
    }

    //non-recursive
}

fun main() {
    println(L111KTCopy2().minDepth(TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6)))
    println(L111KTCopy2().minDepth(TreeUtils.array2Tree(3, 2, 7)))
    println(L111KTCopy2().minDepth(TreeUtils.array2Tree(null, null, null, null)))
    println(L111KTCopy2().minDepth(null))
}
