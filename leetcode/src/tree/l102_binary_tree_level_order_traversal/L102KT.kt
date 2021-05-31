package tree

import java.util.concurrent.LinkedBlockingQueue

class L102KT {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return mutableListOf()
        }
        val list = mutableListOf<List<Int>>()
        var cur = 0
        var countOfLevel = 0;

        val queue = LinkedBlockingQueue<TreeNode>()
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
    val node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6)

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