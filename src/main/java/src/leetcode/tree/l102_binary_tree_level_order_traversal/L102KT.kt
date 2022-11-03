package leetcode.tree.l102_binary_tree_level_order_traversal

import leetcode.tree.TreeNode
import leetcode.tree.TreeUtils
import java.util.concurrent.LinkedBlockingQueue

class L102KT {
    fun levelOrder(root: _root_ide_package_.leetcode.tree.TreeNode?): List<List<Int>> {
        if (root == null) {
            return mutableListOf()
        }
        val list = mutableListOf<List<Int>>()
        var cur = 0
        var countOfLevel = 0;

        val queue = LinkedBlockingQueue<_root_ide_package_.leetcode.tree.TreeNode>()
        var p = root
        queue.offer(root)

        while (queue.isNotEmpty()) {
            cur = 0
            countOfLevel = queue.size
            val innerList = mutableListOf<Int>()

            //deal with every level
            while (cur < countOfLevel) {
                cur++
                p = queue.poll()
                innerList.add(p.`val`)
                p.left?.apply { queue.offer(this) }
                p.right?.apply { queue.offer(this) }
            }
            list.add(innerList)
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
    val list = L102KT().levelOrder(node)
//    for (i in list) print("$i ")
    for (l in list) {
        for (i in l) {
            print("$i ")
        }
        println()
    }
}