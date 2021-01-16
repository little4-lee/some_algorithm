package tree

import java.util.concurrent.LinkedBlockingQueue
import kotlin.math.min
import kotlin.test.todo

class L111KTCopy {


    //non-recursive
    fun minDepth(root: TreeNode?): Int {
        root ?: return 0

        val queue = LinkedBlockingQueue<TreeNode>()
        queue.offer(root)

        var isStop = false
        var cur: Int
        var count: Int
        var level = 0

        while (queue.isNotEmpty() && !isStop) {
            cur = 0
            count = queue.size
            level++

            while (cur < count) {
                cur++
                val p = queue.poll()
                if (p.left == null && p.right == null) {
                    isStop = true
                    break
                }

                if (p.left != null) queue.offer(p.left)
                if (p.right != null) queue.offer(p.right)
            }
        }
        return level
    }
}

fun main() {
    val node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6)
//    val node = TreeUtils.array2Tree(null)
    println(L111KTCopy().minDepth(node))
}