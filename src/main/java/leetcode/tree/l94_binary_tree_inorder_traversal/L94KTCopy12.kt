package tree

import com.sun.source.tree.Tree
import common.TreeNode
import common.TreeUtils
import common.arrayToList
import java.util.*

private fun inorderTraversal(root: TreeNode?):  List<Int> {
    val list = mutableListOf<Int>()
    val stack = Stack<TreeNode>()
    var cur = root

    while (cur != null || stack.isNotEmpty()) {
        // 找到最左边的节点
        while (cur != null) {
            stack.push(cur)
            cur = cur.left
        }
        // 每一个没有左节点的根节点，插入队列
        if (stack.isNotEmpty()) {
            val temp = stack.pop()
            list.add(temp.`val`)
            if (temp.right != null) {
                cur = temp.right
            }
        }
    }

    return list
}

fun main() {
    val node = TreeUtils.array2Tree(3, 6, 7, 5, 0, 2, 8, 0, 0, 0, 0, 4)


//        TreeUtils.printTree(node);


//        TreeUtils.printTree(node);
    val list = inorderTraversal(node)
    for (i in list) print("$i ")
}