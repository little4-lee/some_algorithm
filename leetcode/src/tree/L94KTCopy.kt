package tree

import java.util.*

fun inorderTraversalCopy(root: TreeNode?):  List<Int> {
    val list = mutableListOf<Int>()
    var p = root
    val stack = Stack<TreeNode>()

    while (p != null || stack.isNotEmpty()) {
        while (p != null) {
            stack.push(p)
            p = p.left
        }

        if (stack.isNotEmpty()) {
            p = stack.pop()
            list.add(p.`val`)
            p = p.right
        }
    }

    return list
}

fun main() {
    val node = TreeUtils.array2Tree(3, 6, 7, 5, 0, 2, 8, 0, 0, 0, 0, 4)


//        TreeUtils.printTree(node);


//        TreeUtils.printTree(node);
    val list = inorderTraversalCopy(node)
    for (i in list) print("$i ")
}