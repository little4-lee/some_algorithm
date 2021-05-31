package tree

import com.sun.deploy.net.protocol.chrome.ChromeURLConnection
import java.util.concurrent.LinkedBlockingQueue

class L102KTCopy {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        root ?: return mutableListOf()

        val list = mutableListOf<List<Int>>()
        val queue = LinkedBlockingQueue<TreeNode>()
        queue.offer(root)
        var p = root

        var cur = 0
        var countInLevel = 0

        while (queue.isNotEmpty()) {
            cur = 0
            countInLevel = queue.size
            val innerList = mutableListOf<Int>()
            list.add(innerList)

            while (cur < countInLevel)
                queue.poll().apply {
                    cur++
                    innerList.add(this.`val`)
                    left?.let { queue.offer(it) }
                    right?.let { queue.offer(it) }
                }
        }

        return list
    }
}

fun main() {
    val node = TreeUtils.array2Tree(3, 2, 7, 4, null, 5, 6)
    val list = L102KTCopy().levelOrder(node)
    for (l in list) {
        for (i in l)
            print("$i ")
        println()
    }
}