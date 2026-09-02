package hot100

import java.util.ArrayDeque
import java.util.IdentityHashMap
import java.util.PriorityQueue

/**
 * Hot 100 的可直接运行方法集合。
 *
 * 这些方法没有依赖仓库中旧的 Java 节点类，便于单独复制到 LeetCode Kotlin 提交框。
 * 注释中的“容器易错”专门标出集合、堆、队列、可变数组和节点引用的常见误用。
 */
object Hot100Solutions {

    // LeetCode 习惯字段名为 val/next；这里使用 value 是为了避免与 Kotlin 关键字冲突。
    class ListNode(var value: Int, var next: ListNode? = null)

    class RandomNode(var value: Int) {
        var next: RandomNode? = null
        var random: RandomNode? = null
    }

    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    // ---------- 哈希、双指针、滑动窗口 ----------

    /** LC 1: 先查 complement，再存当前值，避免同一个元素被使用两次。 */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val indexByValue = HashMap<Int, Int>() // 容器易错：value -> index，而不是 index -> value。
        for (i in nums.indices) {
            val complement = target - nums[i]
            val previous = indexByValue[complement]
            if (previous != null) return intArrayOf(previous, i)
            indexByValue[nums[i]] = i
        }
        return intArrayOf()
    }

    /** LC 49: 26 个计数作为异位词的规范 key。 */
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groups = HashMap<String, MutableList<String>>()
        for (word in strs) {
            val count = IntArray(26)
            for (c in word) count[c - 'a']++
            val key = count.joinToString(",")
            // 容器易错：getOrPut 返回的是该 key 的可变列表；每个 key 都必须独立。
            groups.getOrPut(key) { mutableListOf() }.add(word)
        }
        return groups.values.toList()
    }

    /** LC 128: 只从没有前驱的数字开始扩展，达到线性平均复杂度。 */
    fun longestConsecutive(nums: IntArray): Int {
        val values = nums.toHashSet()
        var best = 0
        for (x in values) {
            if (x - 1 !in values) {
                var current = x
                var length = 1
                while (current + 1 in values) {
                    current++
                    length++
                }
                best = maxOf(best, length)
            }
        }
        return best
    }

    /** LC 283: 写入非零元素后统一填充尾部 0，原地且保持稳定顺序。 */
    fun moveZeroes(nums: IntArray) {
        var write = 0
        for (value in nums) if (value != 0) nums[write++] = value
        while (write < nums.size) nums[write++] = 0
    }

    /** LC 11: 面积由较矮边决定，因此移动较矮的一侧。 */
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.lastIndex
        var best = 0L
        while (left < right) {
            val area = minOf(height[left], height[right]).toLong() * (right - left)
            best = maxOf(best, area)
            if (height[left] <= height[right]) left++ else right--
        }
        return best.toInt()
    }

    /** LC 15: 排序 + 固定一个数 + 双指针，并跳过三处重复。 */
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) continue
            if (nums[i] > 0) break
            var left = i + 1
            var right = nums.lastIndex
            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                when {
                    sum == 0 -> {
                        // 容器易错：保存不可变快照，不能保存会继续移动的临时列表。
                        result += listOf(nums[i], nums[left], nums[right])
                        left++
                        right--
                        while (left < right && nums[left] == nums[left - 1]) left++
                        while (left < right && nums[right] == nums[right + 1]) right--
                    }
                    sum < 0 -> left++
                    else -> right--
                }
            }
        }
        return result
    }

    /** LC 42: 双指针维护两侧最高柱。 */
    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.lastIndex
        var leftMax = 0
        var rightMax = 0
        var water = 0L
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) leftMax = height[left]
                else water += (leftMax - height[left]).toLong()
                left++
            } else {
                if (height[right] >= rightMax) rightMax = height[right]
                else water += (rightMax - height[right]).toLong()
                right--
            }
        }
        return water.toInt()
    }

    /** LC 3: lastSeen 记录字符最新位置，左边界只前进不后退。 */
    fun lengthOfLongestSubstring(s: String): Int {
        val lastSeen = HashMap<Char, Int>()
        var left = 0
        var best = 0
        for (right in s.indices) {
            val character = s[right]
            // 容器易错：ASCII 可用数组；这里用 HashMap 以避免 Unicode 字符导致数组越界。
            val previous = lastSeen[character]
            if (previous != null && previous >= left) left = previous + 1
            lastSeen[character] = right
            best = maxOf(best, right - left + 1)
        }
        return best
    }

    /** LC 438: 固定长度窗口计数，matched 表示满足的字符种类。 */
    fun findAnagrams(s: String, p: String): List<Int> {
        if (p.length > s.length) return emptyList()
        val need = IntArray(26)
        for (c in p) need[c - 'a']++
        val window = IntArray(26)
        val result = mutableListOf<Int>()
        var matched = 0
        var left = 0
        for (right in s.indices) {
            val add = s[right] - 'a'
            window[add]++
            if (window[add] <= need[add]) matched++
            if (right - left + 1 > p.length) {
                val remove = s[left++] - 'a'
                if (window[remove] <= need[remove]) matched--
                window[remove]--
            }
            if (right - left + 1 == p.length && matched == p.length) result += left
        }
        return result
    }

    /** LC 560: 前缀和出现次数；初始化 0 -> 1 代表空前缀。 */
    fun subarraySum(nums: IntArray, k: Int): Int {
        val countByPrefix = HashMap<Int, Int>()
        countByPrefix[0] = 1
        var prefix = 0
        var answer = 0
        for (value in nums) {
            prefix += value
            answer += countByPrefix[prefix - k] ?: 0
            countByPrefix[prefix] = (countByPrefix[prefix] ?: 0) + 1
        }
        return answer
    }

    /** LC 239: 单调递减双端队列保存下标。 */
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty() || k == 0) return intArrayOf()
        val deque = ArrayDeque<Int>()
        val result = IntArray(nums.size - k + 1)
        for (i in nums.indices) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) deque.removeFirst()
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) deque.removeLast()
            deque.addLast(i)
            if (i >= k - 1) result[i - k + 1] = nums[deque.peekFirst()]
        }
        return result
    }

    /** LC 76: 右扩满足覆盖，左缩寻找最短窗口。 */
    fun minWindow(s: String, t: String): String {
        if (t.isEmpty() || s.isEmpty()) return ""
        val need = HashMap<Char, Int>()
        for (c in t) need[c] = (need[c] ?: 0) + 1
        val window = HashMap<Char, Int>()
        var formed = 0
        var left = 0
        var bestStart = 0
        var bestLength = Int.MAX_VALUE
        for (right in s.indices) {
            val c = s[right]
            if (c in need) {
                window[c] = (window[c] ?: 0) + 1
                if (window[c] == need[c]) formed++
            }
            while (formed == need.size) {
                if (right - left + 1 < bestLength) {
                    bestStart = left
                    bestLength = right - left + 1
                }
                val drop = s[left++]
                if (drop in need) {
                    if (window[drop] == need[drop]) formed--
                    window[drop] = window[drop]!! - 1
                }
            }
        }
        return if (bestLength == Int.MAX_VALUE) "" else s.substring(bestStart, bestStart + bestLength)
    }

    /** LC 53: Kadane；全负数组仍返回最大负数。 */
    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var current = nums[0]
        var best = nums[0]
        for (i in 1 until nums.size) {
            current = maxOf(nums[i], current + nums[i])
            best = maxOf(best, current)
        }
        return best
    }

    /** LC 56: 按起点排序后线性合并。 */
    fun mergeIntervals(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) return emptyArray()
        intervals.sortBy { it[0] }
        val result = mutableListOf<IntArray>()
        var current = intervals[0].clone()
        for (i in 1 until intervals.size) {
            val next = intervals[i]
            if (next[0] <= current[1]) current[1] = maxOf(current[1], next[1])
            else {
                result += current
                current = next.clone()
            }
        }
        result += current
        return result.toTypedArray()
    }

    /** LC 189: 三次反转实现原地轮转。 */
    fun rotate(nums: IntArray, k: Int) {
        if (nums.isEmpty()) return
        val shift = k % nums.size
        reverse(nums, 0, nums.lastIndex)
        reverse(nums, 0, shift - 1)
        reverse(nums, shift, nums.lastIndex)
    }

    private fun reverse(nums: IntArray, leftStart: Int, rightStart: Int) {
        var left = leftStart
        var right = rightStart
        while (left < right) {
            val tmp = nums[left]
            nums[left++] = nums[right]
            nums[right--] = tmp
        }
    }

    /** LC 238: 结果先写左乘积，再乘右乘积。 */
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }
        var prefix = 1
        for (i in nums.indices) {
            result[i] = prefix
            prefix *= nums[i]
        }
        var suffix = 1
        for (i in nums.lastIndex downTo 0) {
            result[i] *= suffix
            suffix *= nums[i]
        }
        return result
    }

    /** LC 41: 把 1..n 尽量放到对应下标，重复值必须停止交换。 */
    fun firstMissingPositive(nums: IntArray): Int {
        var i = 0
        while (i < nums.size) {
            val value = nums[i]
            val targetIndex = value - 1
            if (value in 1..nums.size && nums[targetIndex] != value) {
                val tmp = nums[i]
                nums[i] = nums[targetIndex]
                nums[targetIndex] = tmp
            } else i++
        }
        for (index in nums.indices) if (nums[index] != index + 1) return index + 1
        return nums.size + 1
    }

    /** LC 73: 首行/首列既当标记又是数据，先记录其原始零状态。 */
    fun setZeroes(matrix: Array<IntArray>) {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return
        val rows = matrix.size
        val cols = matrix[0].size
        var firstRowZero = false
        var firstColZero = false
        for (c in 0 until cols) if (matrix[0][c] == 0) firstRowZero = true
        for (r in 0 until rows) if (matrix[r][0] == 0) firstColZero = true
        for (r in 1 until rows) for (c in 1 until cols) {
            if (matrix[r][c] == 0) {
                matrix[r][0] = 0
                matrix[0][c] = 0
            }
        }
        for (r in 1 until rows) for (c in 1 until cols) {
            if (matrix[r][0] == 0 || matrix[0][c] == 0) matrix[r][c] = 0
        }
        if (firstRowZero) for (c in 0 until cols) matrix[0][c] = 0
        if (firstColZero) for (r in 0 until rows) matrix[r][0] = 0
    }

    /** LC 54: 四边界收缩，遍历底行/左列前检查是否仍有剩余区域。 */
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return emptyList()
        val result = mutableListOf<Int>()
        var top = 0
        var bottom = matrix.lastIndex
        var left = 0
        var right = matrix[0].lastIndex
        while (top <= bottom && left <= right) {
            for (c in left..right) result += matrix[top][c]
            top++
            for (r in top..bottom) result += matrix[r][right]
            right--
            if (top <= bottom) {
                for (c in right downTo left) result += matrix[bottom][c]
                bottom--
            }
            if (left <= right) {
                for (r in bottom downTo top) result += matrix[r][left]
                left++
            }
        }
        return result
    }

    /** LC 48: 转置 + 每行反转。 */
    fun rotateImage(matrix: Array<IntArray>) {
        val n = matrix.size
        for (i in 0 until n) for (j in i + 1 until n) {
            val tmp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = tmp
        }
        for (row in matrix) row.reverse()
    }

    /** LC 240: 从右上角出发，当前值大则左移，小则下移。 */
    fun searchMatrixII(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return false
        var row = 0
        var col = matrix[0].lastIndex
        while (row < matrix.size && col >= 0) {
            when {
                matrix[row][col] == target -> return true
                matrix[row][col] > target -> col--
                else -> row++
            }
        }
        return false
    }

    // ---------- 链表 ----------

    /** LC 160: 指针分别走 A+B、B+A，长度差自动抵消。 */
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var a = headA
        var b = headB
        while (a !== b) {
            a = if (a == null) headB else a.next
            b = if (b == null) headA else b.next
        }
        return a
    }

    /** LC 206: 先保存 next，再断开并反向连接。 */
    fun reverseList(head: ListNode?): ListNode? {
        var current = head
        var previous: ListNode? = null
        while (current != null) {
            val next = current.next
            current.next = previous
            previous = current
            current = next
        }
        return previous
    }

    /** LC 234: 反转后半段比较，最后恢复原链表。 */
    fun isPalindromeList(head: ListNode?): Boolean {
        if (head?.next == null) return true
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        val secondStart = if (fast == null) slow else slow?.next
        val reversed = reverseList(secondStart)
        var p1 = head
        var p2 = reversed
        var palindrome = true
        while (p2 != null) {
            if (p1?.value != p2.value) {
                palindrome = false
                break
            }
            p1 = p1.next
            p2 = p2.next
        }
        reverseList(reversed) // 恢复后半段，降低对调用方链表的副作用。
        return palindrome
    }

    /** LC 141: Floyd 快慢指针检测环。 */
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (slow === fast) return true
        }
        return false
    }

    /** LC 142: 相遇后让一个指针回头，等步长再次相遇于入口。 */
    fun detectCycle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        do {
            slow = slow?.next
            fast = fast?.next?.next
            if (slow == null || fast == null) return null
        } while (slow !== fast)
        var fromHead = head
        while (fromHead !== slow) {
            fromHead = fromHead?.next
            slow = slow?.next
        }
        return fromHead
    }

    /** LC 21: 哑节点统一处理头节点被选中的情况。 */
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var tail = dummy
        var a = list1
        var b = list2
        while (a != null && b != null) {
            if (a.value <= b.value) {
                tail.next = a
                a = a.next
            } else {
                tail.next = b
                b = b.next
            }
            tail = tail.next!!
        }
        tail.next = a ?: b
        return dummy.next
    }

    /** LC 2: 两条逆序数字链表逐位相加，并保留最终 carry。 */
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var tail = dummy
        var a = l1
        var b = l2
        var carry = 0
        while (a != null || b != null || carry != 0) {
            val sum = (a?.value ?: 0) + (b?.value ?: 0) + carry
            carry = sum / 10
            tail.next = ListNode(sum % 10)
            tail = tail.next!!
            a = a?.next
            b = b?.next
        }
        return dummy.next
    }

    /** LC 19: 快慢指针间隔 n，slow 停在待删节点前。 */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0, head)
        var fast: ListNode? = dummy
        var slow: ListNode? = dummy
        repeat(n) { fast = fast?.next }
        while (fast?.next != null) {
            fast = fast?.next
            slow = slow?.next
        }
        slow?.next = slow?.next?.next
        return dummy.next
    }

    /** LC 24: 只重连节点，不交换 value。 */
    fun swapPairs(head: ListNode?): ListNode? {
        val dummy = ListNode(0, head)
        var previous: ListNode? = dummy
        while (previous?.next != null && previous.next?.next != null) {
            val first = previous.next!!
            val second = first.next!!
            first.next = second.next
            second.next = first
            previous.next = second
            previous = first
        }
        return dummy.next
    }

    /** LC 25: 探测到完整 k 组后进行头插反转，不足一组保持原状。 */
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (k <= 1) return head
        val dummy = ListNode(0, head)
        var groupPrev: ListNode? = dummy
        while (true) {
            var kth: ListNode? = groupPrev
            repeat(k) { kth = kth?.next }
            if (kth == null) break
            val groupNext = kth?.next
            var previous = groupNext
            var current = groupPrev?.next
            while (current !== groupNext) {
                val next = current?.next
                current?.next = previous
                previous = current
                current = next
            }
            val oldFirst = groupPrev?.next
            groupPrev?.next = kth
            groupPrev = oldFirst
        }
        return dummy.next
    }

    /** LC 138: IdentityHashMap 明确按节点身份建立原节点到副本的映射。 */
    fun copyRandomList(head: RandomNode?): RandomNode? {
        if (head == null) return null
        val copies = IdentityHashMap<RandomNode, RandomNode>()
        var current = head
        while (current != null) {
            copies[current] = RandomNode(current.value)
            current = current.next
        }
        current = head
        while (current != null) {
            val copy = copies[current]!!
            copy.next = current.next?.let { copies[it] }
            copy.random = current.random?.let { copies[it] }
            current = current.next
        }
        return copies[head]
    }

    /** LC 148: 归并排序，断开中点后递归区间才会缩小。 */
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var slow = head
        var fast = head.next
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        val rightHead = slow?.next
        slow?.next = null // 容器易错：不切断链表会导致递归不收敛。
        return mergeTwoLists(sortList(head), sortList(rightHead))
    }

    /** LC 23: 小根堆保存各链表当前头节点。 */
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val heap = PriorityQueue<ListNode>(compareBy { it.value })
        for (node in lists) if (node != null) heap.add(node)
        val dummy = ListNode(0)
        var tail = dummy
        while (heap.isNotEmpty()) {
            val node = heap.remove()
            if (node.next != null) heap.add(node.next)
            tail.next = node
            tail = node
        }
        tail.next = null
        return dummy.next
    }

    /** LC 146: HashMap 定位 + 手写双向链表维护新旧顺序。 */
    class LRUCache(private val capacity: Int) {
        private class Entry(val key: Int, var value: Int) {
            var prev: Entry? = null
            var next: Entry? = null
        }

        private val nodes = HashMap<Int, Entry>()
        private val head = Entry(0, 0)
        private val tail = Entry(0, 0)

        init {
            head.next = tail
            tail.prev = head
        }

        fun get(key: Int): Int {
            val node = nodes[key] ?: return -1
            moveToFront(node)
            return node.value
        }

        fun put(key: Int, value: Int) {
            val existing = nodes[key]
            if (existing != null) {
                existing.value = value
                moveToFront(existing)
                return
            }
            val node = Entry(key, value)
            nodes[key] = node
            addFirst(node)
            if (nodes.size > capacity) {
                val removed = tail.prev!!
                remove(removed)
                nodes.remove(removed.key)
            }
        }

        private fun moveToFront(node: Entry) {
            remove(node)
            addFirst(node)
        }

        private fun addFirst(node: Entry) {
            node.next = head.next
            node.prev = head
            head.next!!.prev = node
            head.next = node
        }

        private fun remove(node: Entry) {
            node.prev!!.next = node.next
            node.next!!.prev = node.prev
        }
    }

    // ---------- 二叉树 ----------

    /** LC 94: 显式栈模拟 left-root-right。 */
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val stack = ArrayDeque<TreeNode>()
        var current = root
        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.addLast(current)
                current = current.left
            }
            current = stack.removeLast()
            result += current.value
            current = current.right
        }
        return result
    }

    /** LC 104: 深度是节点数，空树为 0。 */
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + maxOf(maxDepth(root.left), maxDepth(root.right))
    }

    /** LC 226: 交换左右引用后递归翻转子树。 */
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val left = root.left
        root.left = invertTree(root.right)
        root.right = invertTree(left)
        return root
    }

    /** LC 101: 两棵子树交叉比较外侧/内侧节点。 */
    fun isSymmetric(root: TreeNode?): Boolean {
        fun mirror(a: TreeNode?, b: TreeNode?): Boolean {
            if (a == null || b == null) return a == null && b == null
            return a.value == b.value && mirror(a.left, b.right) && mirror(a.right, b.left)
        }
        return mirror(root?.left, root?.right)
    }

    /** LC 543: 后序返回向下深度，全局记录经过当前节点的最长边数。 */
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var diameter = 0
        fun depth(node: TreeNode?): Int {
            if (node == null) return 0
            val left = depth(node.left)
            val right = depth(node.right)
            diameter = maxOf(diameter, left + right)
            return 1 + maxOf(left, right)
        }
        depth(root)
        return diameter
    }

    /** LC 102: BFS 每轮固定当前层的节点数量。 */
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val result = mutableListOf<List<Int>>()
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            val level = ArrayList<Int>(levelSize)
            repeat(levelSize) {
                val node = queue.removeFirst()
                level += node.value
                node.left?.let(queue::addLast)
                node.right?.let(queue::addLast)
            }
            result += level
        }
        return result
    }

    /** LC 108: 中点作根，闭区间递归构造平衡 BST。 */
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        fun build(left: Int, right: Int): TreeNode? {
            if (left > right) return null
            val mid = left + (right - left) / 2
            val node = TreeNode(nums[mid])
            node.left = build(left, mid - 1)
            node.right = build(mid + 1, right)
            return node
        }
        return build(0, nums.lastIndex)
    }

    /** LC 98: 用 Long 开放区间传递祖先约束。 */
    fun isValidBST(root: TreeNode?): Boolean {
        fun valid(node: TreeNode?, low: Long, high: Long): Boolean {
            if (node == null) return true
            if (node.value.toLong() <= low || node.value.toLong() >= high) return false
            return valid(node.left, low, node.value.toLong()) && valid(node.right, node.value.toLong(), high)
        }
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    /** LC 230: BST 中序顺序就是升序顺序。 */
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val stack = ArrayDeque<TreeNode>()
        var current = root
        var remaining = k
        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.addLast(current)
                current = current.left
            }
            current = stack.removeLast()
            if (--remaining == 0) return current.value
            current = current.right
        }
        return -1
    }

    /** LC 199: 每层最后出队的节点就是右视图节点。 */
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val result = mutableListOf<Int>()
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            repeat(size) { index ->
                val node = queue.removeFirst()
                if (index == size - 1) result += node.value
                node.left?.let(queue::addLast)
                node.right?.let(queue::addLast)
            }
        }
        return result
    }

    /** LC 114: 返回展开后链表的尾节点，先保存原右子树避免丢链。 */
    fun flatten(root: TreeNode?) {
        fun flattenAndGetTail(node: TreeNode?): TreeNode? {
            if (node == null) return null
            val originalRight = node.right
            val leftTail = flattenAndGetTail(node.left)
            val rightTail = flattenAndGetTail(originalRight)
            if (node.left != null) {
                node.right = node.left
                node.left = null
                leftTail!!.right = originalRight
            }
            return rightTail ?: leftTail ?: node
        }
        flattenAndGetTail(root)
    }

    /** LC 105: Map 定位中序根，前序指针按根-左-右顺序推进。 */
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) return null
        val indexByValue = HashMap<Int, Int>()
        for (i in inorder.indices) indexByValue[inorder[i]] = i
        var preorderIndex = 0
        fun build(left: Int, right: Int): TreeNode? {
            if (left > right) return null
            val rootValue = preorder[preorderIndex++]
            val node = TreeNode(rootValue)
            val split = indexByValue[rootValue]!!
            node.left = build(left, split - 1)
            node.right = build(split + 1, right)
            return node
        }
        return build(0, inorder.lastIndex)
    }

    /** LC 437: 前缀和 Map 必须在离开节点时回滚。 */
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        val prefixCount = HashMap<Long, Int>()
        prefixCount[0L] = 1
        fun dfs(node: TreeNode?, prefix: Long): Int {
            if (node == null) return 0
            val current = prefix + node.value
            var answer = prefixCount[current - targetSum] ?: 0
            prefixCount[current] = (prefixCount[current] ?: 0) + 1
            answer += dfs(node.left, current)
            answer += dfs(node.right, current)
            prefixCount[current] = prefixCount[current]!! - 1 // 容器易错：不回滚会污染兄弟子树。
            return answer
        }
        return dfs(root, 0L)
    }

    /** LC 236: 节点引用命中目标时直接返回，左右各命中则当前节点为祖先。 */
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || root === p || root === q) return root
        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)
        return if (left != null && right != null) root else left ?: right
    }

    /** LC 124: 向上贡献不能同时带两个方向，但全局候选可以左右都带。 */
    fun maxPathSum(root: TreeNode?): Int {
        var best = Long.MIN_VALUE
        fun gain(node: TreeNode?): Long {
            if (node == null) return 0L
            val left = maxOf(0L, gain(node.left))
            val right = maxOf(0L, gain(node.right))
            best = maxOf(best, left + node.value + right)
            return node.value + maxOf(left, right)
        }
        gain(root)
        return best.toInt()
    }

    // ---------- 图与回溯 ----------

    /** LC 200: DFS 淹没整座岛，避免额外 visited 容器。 */
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0
        val rows = grid.size
        val cols = grid[0].size
        fun flood(row: Int, col: Int) {
            if (row !in 0 until rows || col !in 0 until cols || grid[row][col] != '1') return
            grid[row][col] = '0'
            flood(row - 1, col)
            flood(row + 1, col)
            flood(row, col - 1)
            flood(row, col + 1)
        }
        var count = 0
        for (r in 0 until rows) for (c in 0 until cols) {
            if (grid[r][c] == '1') {
                count++
                flood(r, c)
            }
        }
        return count
    }

    /** LC 994: 多源 BFS，一层代表一分钟。 */
    fun orangesRotting(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0
        val rows = grid.size
        val cols = grid[0].size
        val queue = ArrayDeque<Int>()
        var fresh = 0
        for (r in 0 until rows) for (c in 0 until cols) {
            when (grid[r][c]) {
                1 -> fresh++
                2 -> queue.addLast(r * cols + c) // 容器易错：队列元素必须包含行列两个坐标。
            }
        }
        var minutes = 0
        val directions = intArrayOf(-1, 0, 1, 0, -1)
        while (queue.isNotEmpty() && fresh > 0) {
            repeat(queue.size) {
                val code = queue.removeFirst()
                val row = code / cols
                val col = code % cols
                for (d in 0 until 4) {
                    val nr = row + directions[d]
                    val nc = col + directions[d + 1]
                    if (nr in 0 until rows && nc in 0 until cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2
                        fresh--
                        queue.addLast(nr * cols + nc)
                    }
                }
            }
            minutes++
        }
        return if (fresh == 0) minutes else -1
    }

    /** LC 207: Kahn 拓扑排序，处理节点数等于课程数才无环。 */
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = Array(numCourses) { mutableListOf<Int>() }
        val indegree = IntArray(numCourses)
        for (pair in prerequisites) {
            val course = pair[0]
            val prerequisite = pair[1]
            graph[prerequisite].add(course)
            indegree[course]++
        }
        val queue = ArrayDeque<Int>()
        for (course in 0 until numCourses) if (indegree[course] == 0) queue.addLast(course)
        var completed = 0
        while (queue.isNotEmpty()) {
            val prerequisite = queue.removeFirst()
            completed++
            for (course in graph[prerequisite]) if (--indegree[course] == 0) queue.addLast(course)
        }
        return completed == numCourses
    }

    /** LC 208: 小写字母 Trie；isWord 区分完整单词和仅前缀。 */
    class Trie {
        private class Node {
            val children = arrayOfNulls<Node>(26) // 容器易错：未创建分支必须允许 null。
            var isWord = false
        }

        private val root = Node()

        fun insert(word: String) {
            var node = root
            for (c in word) {
                val index = c - 'a'
                node.children[index] = node.children[index] ?: Node()
                node = node.children[index]!!
            }
            node.isWord = true
        }

        fun search(word: String): Boolean = find(word)?.isWord == true

        fun startsWith(prefix: String): Boolean = find(prefix) != null

        private fun find(text: String): Node? {
            var node = root
            for (c in text) node = node.children[c - 'a'] ?: return null
            return node
        }
    }

    /** LC 46: 交换法回溯，加入结果时复制数组快照。 */
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        fun backtrack(first: Int) {
            if (first == nums.size) {
                result += nums.toList() // 容器易错：不能把同一个可变 nums 引用重复放入结果。
                return
            }
            for (i in first until nums.size) {
                val tmp = nums[first]
                nums[first] = nums[i]
                nums[i] = tmp
                backtrack(first + 1)
                nums[i] = nums[first]
                nums[first] = tmp
            }
        }
        backtrack(0)
        return result
    }

    /** LC 78: 每个递归节点都收集当前路径。 */
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        fun backtrack(start: Int) {
            result += path.toList() // 容器易错：保存不可变快照，回溯后 path 会继续变化。
            for (i in start until nums.size) {
                path += nums[i]
                backtrack(i + 1)
                path.removeAt(path.lastIndex)
            }
        }
        backtrack(0)
        return result
    }

    /** LC 17: 数字 2..9 的电话键盘 DFS。 */
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        val mapping = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        val result = mutableListOf<String>()
        val path = StringBuilder()
        fun backtrack(index: Int) {
            if (index == digits.length) {
                result += path.toString()
                return
            }
            for (c in mapping[digits[index] - '0']) {
                path.append(c)
                backtrack(index + 1)
                path.deleteCharAt(path.lastIndex)
            }
        }
        backtrack(0)
        return result
    }

    /** LC 39: 候选可重复使用，下一层仍从 i 开始。 */
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        fun backtrack(start: Int, remaining: Int) {
            if (remaining == 0) {
                result += path.toList()
                return
            }
            for (i in start until candidates.size) {
                val value = candidates[i]
                if (value > remaining) break
                path += value
                backtrack(i, remaining - value)
                path.removeAt(path.lastIndex)
            }
        }
        backtrack(0, target)
        return result
    }

    /** LC 22: 只有左括号数大于右括号数时才能追加右括号。 */
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        val path = StringBuilder()
        fun backtrack(open: Int, close: Int) {
            if (path.length == n * 2) {
                result += path.toString()
                return
            }
            if (open < n) {
                path.append('(')
                backtrack(open + 1, close)
                path.deleteCharAt(path.lastIndex)
            }
            if (close < open) {
                path.append(')')
                backtrack(open, close + 1)
                path.deleteCharAt(path.lastIndex)
            }
        }
        backtrack(0, 0)
        return result
    }

    /** LC 79: 原地用 '#' 标记访问，返回前恢复。 */
    fun exist(board: Array<CharArray>, word: String): Boolean {
        if (board.isEmpty() || board[0].isEmpty() || word.isEmpty()) return false
        val rows = board.size
        val cols = board[0].size
        fun dfs(row: Int, col: Int, index: Int): Boolean {
            if (index == word.length) return true
            if (row !in 0 until rows || col !in 0 until cols || board[row][col] != word[index]) return false
            val saved = board[row][col]
            board[row][col] = '#'
            val found = dfs(row - 1, col, index + 1) ||
                dfs(row + 1, col, index + 1) ||
                dfs(row, col - 1, index + 1) ||
                dfs(row, col + 1, index + 1)
            board[row][col] = saved
            return found
        }
        for (r in 0 until rows) for (c in 0 until cols) if (dfs(r, c, 0)) return true
        return false
    }

    /** LC 131: 预计算回文表，回溯只枚举合法切分。 */
    fun partitionPalindrome(s: String): List<List<String>> {
        val n = s.length
        val palindrome = Array(n) { BooleanArray(n) }
        for (right in 0 until n) for (left in right downTo 0) {
            palindrome[left][right] = s[left] == s[right] && (right - left <= 2 || palindrome[left + 1][right - 1])
        }
        val result = mutableListOf<List<String>>()
        val path = mutableListOf<String>()
        fun backtrack(start: Int) {
            if (start == n) {
                result += path.toList()
                return
            }
            for (end in start until n) if (palindrome[start][end]) {
                path += s.substring(start, end + 1)
                backtrack(end + 1)
                path.removeAt(path.lastIndex)
            }
        }
        backtrack(0)
        return result
    }

    /** LC 51: 行回溯；主对角线 row-col 可为负，使用 HashSet 而非直接数组下标。 */
    fun solveNQueens(n: Int): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val board = Array(n) { CharArray(n) { '.' } }
        val columns = HashSet<Int>()
        val diagonals = HashSet<Int>()
        val antiDiagonals = HashSet<Int>()
        fun backtrack(row: Int) {
            if (row == n) {
                result += board.map { String(it) }
                return
            }
            for (col in 0 until n) {
                val diagonal = row - col
                val anti = row + col
                if (col in columns || diagonal in diagonals || anti in antiDiagonals) continue
                columns += col
                diagonals += diagonal
                antiDiagonals += anti
                board[row][col] = 'Q'
                backtrack(row + 1)
                board[row][col] = '.'
                columns -= col
                diagonals -= diagonal
                antiDiagonals -= anti
            }
        }
        backtrack(0)
        return result
    }

    // ---------- 二分、栈与堆 ----------

    /** LC 35: lower bound，返回第一个 >= target 的位置。 */
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] < target) left = mid + 1 else right = mid
        }
        return left
    }

    /** LC 74: 二维矩阵按行拼接后的一维二分。 */
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return false
        val rows = matrix.size
        val cols = matrix[0].size
        var left = 0
        var right = rows * cols - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            val value = matrix[mid / cols][mid % cols]
            when {
                value == target -> return true
                value < target -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return false
    }

    /** LC 34: 两次边界二分；upper bound 减一得到最后一个等于 target 的位置。 */
    fun searchRange(nums: IntArray, target: Int): IntArray {
        fun lowerBound(value: Int): Int {
            var left = 0
            var right = nums.size
            while (left < right) {
                val mid = left + (right - left) / 2
                if (nums[mid] < value) left = mid + 1 else right = mid
            }
            return left
        }
        val first = lowerBound(target)
        if (first == nums.size || nums[first] != target) return intArrayOf(-1, -1)
        var left = first
        var right = nums.size
        // upper bound 直接按“大于 target”判断，避免 target == Int.MAX_VALUE 时加一溢出。
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] <= target) left = mid + 1 else right = mid
        }
        return intArrayOf(first, left - 1)
    }

    /** LC 33: 每轮判断哪一半有序，再判断目标是否落在该半区。 */
    fun searchRotated(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) return mid
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1 else left = mid + 1
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1 else right = mid - 1
            }
        }
        return -1
    }

    /** LC 153: 比较 mid 与右端，保留可能的最小值下标。 */
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] > nums[right]) left = mid + 1 else right = mid
        }
        return nums[left]
    }

    /** LC 4: 在较短数组上二分切分位置。 */
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var a = nums1
        var b = nums2
        if (a.size > b.size) {
            val tmp = a
            a = b
            b = tmp
        }
        val totalLeft = (a.size + b.size + 1) / 2
        var left = 0
        var right = a.size
        while (left <= right) {
            val cutA = left + (right - left) / 2
            val cutB = totalLeft - cutA
            val leftA = if (cutA == 0) Int.MIN_VALUE else a[cutA - 1]
            val rightA = if (cutA == a.size) Int.MAX_VALUE else a[cutA]
            val leftB = if (cutB == 0) Int.MIN_VALUE else b[cutB - 1]
            val rightB = if (cutB == b.size) Int.MAX_VALUE else b[cutB]
            if (leftA <= rightB && leftB <= rightA) {
                val maxLeft = maxOf(leftA, leftB).toLong()
                if ((a.size + b.size) % 2 == 1) return maxLeft.toDouble()
                return (maxLeft + minOf(rightA, rightB).toLong()) / 2.0
            }
            if (leftA > rightB) right = cutA - 1 else left = cutA + 1
        }
        return 0.0 // 题目保证输入合法；仅为编译器提供兜底返回。
    }

    /** LC 20: 左括号入栈，右括号必须匹配栈顶。 */
    fun isValidParentheses(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        val pair = mapOf(')' to '(', ']' to '[', '}' to '{')
        for (c in s) {
            if (c == '(' || c == '[' || c == '{') stack.addLast(c)
            else {
                if (stack.isEmpty() || stack.removeLast() != pair[c]) return false
            }
        }
        return stack.isEmpty()
    }

    /** LC 155: 数据栈和最小值栈同步压入，保留重复最小值。 */
    class MinStack {
        private val values = ArrayDeque<Int>()
        private val minimums = ArrayDeque<Int>()

        fun push(value: Int) {
            values.addLast(value)
            val currentMinimum = if (minimums.isEmpty()) value else minOf(value, minimums.peekLast())
            minimums.addLast(currentMinimum)
        }

        fun pop() {
            values.removeLast()
            minimums.removeLast()
        }

        fun top(): Int = values.peekLast()

        fun getMin(): Int = minimums.peekLast()
    }

    /** LC 394: 数字栈 + 前缀字符串栈处理任意嵌套。 */
    fun decodeString(s: String): String {
        val counts = ArrayDeque<Int>()
        val prefixes = ArrayDeque<String>()
        var number = 0
        var current = StringBuilder()
        for (c in s) {
            when {
                c.isDigit() -> number = number * 10 + (c - '0')
                c == '[' -> {
                    counts.addLast(number)
                    prefixes.addLast(current.toString())
                    number = 0
                    current = StringBuilder()
                }
                c == ']' -> {
                    val repeat = counts.removeLast()
                    val prefix = prefixes.removeLast()
                    val expanded = current.toString().repeat(repeat)
                    current = StringBuilder(prefix).append(expanded)
                }
                else -> current.append(c)
            }
        }
        return current.toString()
    }

    /** LC 739: 单调递减栈存下标。 */
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val answer = IntArray(temperatures.size)
        val stack = ArrayDeque<Int>()
        for (i in temperatures.indices) {
            while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.peekLast()]) {
                val previous = stack.removeLast()
                answer[previous] = i - previous
            }
            stack.addLast(i)
        }
        return answer
    }

    /** LC 84: 递增栈 + 虚拟尾部高度 0，宽度为 right-left-1。 */
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = ArrayDeque<Int>()
        var best = 0L
        for (i in 0..heights.size) {
            val currentHeight = if (i == heights.size) 0 else heights[i]
            while (stack.isNotEmpty() && currentHeight < heights[stack.peekLast()]) {
                val height = heights[stack.removeLast()]
                val leftBoundary = if (stack.isEmpty()) -1 else stack.peekLast()
                val width = i - leftBoundary - 1
                best = maxOf(best, height.toLong() * width)
            }
            stack.addLast(i)
        }
        return best.toInt()
    }

    /** LC 215: 维护 k 大元素中的最小者。 */
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<Int>() // 容器易错：这里必须是小根堆。
        for (value in nums) {
            heap.add(value)
            if (heap.size > k) heap.remove()
        }
        return heap.peek()
    }

    /** LC 347: 频率桶从高到低收集。 */
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequency = HashMap<Int, Int>()
        for (value in nums) frequency[value] = (frequency[value] ?: 0) + 1
        val buckets = Array(nums.size + 1) { mutableListOf<Int>() }
        for ((value, count) in frequency) buckets[count].add(value)
        val result = IntArray(k)
        var write = 0
        for (count in buckets.lastIndex downTo 1) {
            for (value in buckets[count]) {
                result[write++] = value
                if (write == k) return result
            }
        }
        return result
    }

    /** LC 295: max-heap 保存较小一半，min-heap 保存较大一半。 */
    class MedianFinder {
        private val lower = PriorityQueue<Int>(compareByDescending { it })
        private val upper = PriorityQueue<Int>()

        fun addNum(num: Int) {
            if (lower.isEmpty() || num <= lower.peek()) lower.add(num) else upper.add(num)
            if (lower.size > upper.size + 1) upper.add(lower.remove())
            if (upper.size > lower.size) lower.add(upper.remove())
        }

        fun findMedian(): Double {
            return if (lower.size > upper.size) lower.peek().toDouble()
            else (lower.peek().toLong() + upper.peek().toLong()) / 2.0
        }
    }

    // ---------- 贪心与动态规划 ----------

    /** LC 121: 历史最低买入价 + 当前卖出价。 */
    fun maxProfit(prices: IntArray): Int {
        var minimum = Int.MAX_VALUE
        var best = 0
        for (price in prices) {
            best = maxOf(best, price - minimum)
            minimum = minOf(minimum, price)
        }
        return best
    }

    /** LC 55: 维护可达最远位置，走到不可达位置立即失败。 */
    fun canJump(nums: IntArray): Boolean {
        var farthest = 0
        for (i in nums.indices) {
            if (i > farthest) return false
            farthest = maxOf(farthest, i + nums[i])
        }
        return true
    }

    /** LC 45: 把一次跳跃看成一层，扫描本层找下一层最远边界。 */
    fun jump(nums: IntArray): Int {
        if (nums.size <= 1) return 0
        var jumps = 0
        var currentEnd = 0
        var farthest = 0
        for (i in 0 until nums.lastIndex) {
            farthest = maxOf(farthest, i + nums[i])
            if (i == currentEnd) {
                jumps++
                currentEnd = farthest
            }
        }
        return jumps
    }

    /** LC 763: 字符最后出现位置决定当前片段右边界。 */
    fun partitionLabels(s: String): List<Int> {
        val last = IntArray(26)
        for (i in s.indices) last[s[i] - 'a'] = i
        val result = mutableListOf<Int>()
        var start = 0
        var end = 0
        for (i in s.indices) {
            end = maxOf(end, last[s[i] - 'a'])
            if (i == end) {
                result += end - start + 1
                start = i + 1
            }
        }
        return result
    }

    /** LC 70: 斐波那契滚动变量，Long 避免中间溢出。 */
    fun climbStairs(n: Int): Int {
        if (n <= 2) return n
        var twoBefore = 1L
        var oneBefore = 2L
        for (step in 3..n) {
            val current = twoBefore + oneBefore
            twoBefore = oneBefore
            oneBefore = current
        }
        return oneBefore.toInt()
    }

    /** LC 118: 每行首尾为 1，中间使用上一行相邻两项。 */
    fun generatePascal(numRows: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        repeat(numRows) { rowIndex ->
            val row = MutableList(rowIndex + 1) { 1 }
            for (i in 1 until rowIndex) row[i] = result[rowIndex - 1][i - 1] + result[rowIndex - 1][i]
            result += row
        }
        return result
    }

    /** LC 198: prev2/prev1 分别表示前两间和前一间的最优值。 */
    fun rob(nums: IntArray): Int {
        var prev2 = 0
        var prev1 = 0
        for (money in nums) {
            val current = maxOf(prev1, prev2 + money)
            prev2 = prev1
            prev1 = current
        }
        return prev1
    }

    /** LC 279: 完全平方数完全背包，求最小数量。 */
    fun numSquares(n: Int): Int {
        val dp = IntArray(n + 1) { n + 1 }
        dp[0] = 0
        for (sum in 1..n) {
            var square = 1
            while (square * square <= sum) {
                dp[sum] = minOf(dp[sum], dp[sum - square * square] + 1)
                square++
            }
        }
        return dp[n]
    }

    /** LC 322: amount 维度正序更新，硬币可重复使用。 */
    fun coinChange(coins: IntArray, amount: Int): Int {
        val unreachable = amount + 1
        val dp = IntArray(amount + 1) { unreachable }
        dp[0] = 0
        for (sum in 1..amount) {
            for (coin in coins) if (coin <= sum) {
                dp[sum] = minOf(dp[sum], dp[sum - coin] + 1)
            }
        }
        return if (dp[amount] == unreachable) -1 else dp[amount]
    }

    /** LC 139: dp[i] 表示前 i 个字符可拆分。 */
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dictionary = wordDict.toHashSet()
        val dp = BooleanArray(s.length + 1)
        dp[0] = true
        for (end in 1..s.length) {
            for (start in 0 until end) {
                if (dp[start] && s.substring(start, end) in dictionary) {
                    dp[end] = true
                    break
                }
            }
        }
        return dp[s.length]
    }

    /** LC 300: tails 的每个位置是对应长度子序列的最小尾值。 */
    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val tails = IntArray(nums.size)
        var length = 0
        for (value in nums) {
            var left = 0
            var right = length
            while (left < right) {
                val mid = left + (right - left) / 2
                if (tails[mid] < value) left = mid + 1 else right = mid
            }
            tails[left] = value
            if (left == length) length++
        }
        return length
    }

    /** LC 152: 同时维护最大/最小乘积，负数到来时交换。 */
    fun maxProductSubarray(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var maximum = nums[0].toLong()
        var minimum = nums[0].toLong()
        var best = nums[0].toLong()
        for (i in 1 until nums.size) {
            val value = nums[i].toLong()
            if (value < 0) {
                val tmp = maximum
                maximum = minimum
                minimum = tmp
            }
            maximum = maxOf(value, maximum * value)
            minimum = minOf(value, minimum * value)
            best = maxOf(best, maximum)
        }
        return best.toInt()
    }

    /** LC 416: 0/1 背包容量必须倒序，避免同一数字在本轮被重复使用。 */
    fun canPartition(nums: IntArray): Boolean {
        val total = nums.sum()
        if (total % 2 != 0) return false
        val target = total / 2
        val reachable = BooleanArray(target + 1)
        reachable[0] = true
        for (value in nums) {
            for (capacity in target downTo value) {
                reachable[capacity] = reachable[capacity] || reachable[capacity - value]
            }
        }
        return reachable[target]
    }

    /** LC 32: 栈保存有效串起点，哨兵 -1 处理从下标 0 开始的情况。 */
    fun longestValidParentheses(s: String): Int {
        val stack = ArrayDeque<Int>()
        stack.addLast(-1)
        var best = 0
        for (i in s.indices) {
            if (s[i] == '(') stack.addLast(i)
            else {
                stack.removeLast()
                if (stack.isEmpty()) stack.addLast(i)
                else best = maxOf(best, i - stack.peekLast())
            }
        }
        return best
    }

    /** LC 62: 一维 dp 正序更新，左侧是本行刚算出的值。 */
    fun uniquePaths(m: Int, n: Int): Int {
        if (m <= 0 || n <= 0) return 0
        val dp = IntArray(n) { 1 }
        for (row in 1 until m) for (col in 1 until n) dp[col] += dp[col - 1]
        return dp[n - 1]
    }

    /** LC 64: 一维 dp 的边界格只能来自唯一方向。 */
    fun minPathSum(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0
        val cols = grid[0].size
        val dp = IntArray(cols) { Int.MAX_VALUE }
        dp[0] = 0
        for (row in grid) {
            for (col in row.indices) {
                if (col > 0) dp[col] = minOf(dp[col], dp[col - 1])
                dp[col] += row[col]
            }
        }
        return dp[cols - 1]
    }

    /** LC 5: 奇数中心和偶数中心都向外扩展。 */
    fun longestPalindrome(s: String): String {
        if (s.length < 2) return s
        var bestLeft = 0
        var bestRight = 0
        fun expand(leftStart: Int, rightStart: Int): IntArray {
            var left = leftStart
            var right = rightStart
            while (left >= 0 && right < s.length && s[left] == s[right]) {
                left--
                right++
            }
            return intArrayOf(left + 1, right - 1)
        }
        for (center in s.indices) {
            val odd = expand(center, center)
            if (odd[1] - odd[0] > bestRight - bestLeft) {
                bestLeft = odd[0]
                bestRight = odd[1]
            }
            val even = expand(center, center + 1)
            if (even[1] - even[0] > bestRight - bestLeft) {
                bestLeft = even[0]
                bestRight = even[1]
            }
        }
        return s.substring(bestLeft, bestRight + 1)
    }

    /** LC 1143: 二维前缀状态，字符相等沿对角线，否则取上/左最大。 */
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val dp = Array(text1.length + 1) { IntArray(text2.length + 1) }
        for (i in 1..text1.length) for (j in 1..text2.length) {
            dp[i][j] = if (text1[i - 1] == text2[j - 1]) dp[i - 1][j - 1] + 1
            else maxOf(dp[i - 1][j], dp[i][j - 1])
        }
        return dp[text1.length][text2.length]
    }

    /** LC 72: 编辑距离的插入、删除、替换三种转移。 */
    fun minDistance(word1: String, word2: String): Int {
        val dp = Array(word1.length + 1) { IntArray(word2.length + 1) }
        for (i in dp.indices) dp[i][0] = i
        for (j in dp[0].indices) dp[0][j] = j
        for (i in 1..word1.length) for (j in 1..word2.length) {
            dp[i][j] = if (word1[i - 1] == word2[j - 1]) dp[i - 1][j - 1]
            else minOf(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
        }
        return dp[word1.length][word2.length]
    }

    /** LC 136: 异或抵消成对元素。 */
    fun singleNumber(nums: IntArray): Int {
        var answer = 0
        for (value in nums) answer = answer xor value
        return answer
    }

    /** LC 169: Boyer-Moore 投票，题目保证多数元素存在。 */
    fun majorityElement(nums: IntArray): Int {
        var candidate = 0
        var votes = 0
        for (value in nums) {
            if (votes == 0) candidate = value
            votes += if (value == candidate) 1 else -1
        }
        return candidate
    }

    /** LC 75: 荷兰国旗三指针；交换 2 后 mid 不推进。 */
    fun sortColors(nums: IntArray) {
        var low = 0
        var mid = 0
        var high = nums.lastIndex
        while (mid <= high) {
            when (nums[mid]) {
                0 -> {
                    swap(nums, low, mid)
                    low++
                    mid++
                }
                1 -> mid++
                else -> {
                    swap(nums, mid, high)
                    high--
                }
            }
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
    }

    /** LC 31: 找下降点，交换后缀中的最小增量，再反转后缀。 */
    fun nextPermutation(nums: IntArray) {
        var pivot = nums.lastIndex - 1
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) pivot--
        if (pivot >= 0) {
            var successor = nums.lastIndex
            while (nums[successor] <= nums[pivot]) successor--
            swap(nums, pivot, successor)
        }
        reverse(nums, pivot + 1, nums.lastIndex)
    }

    /** LC 287: 将 nums[i] 视为 next 指针，Floyd 找隐式链表环入口。 */
    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[nums[0]]
        while (slow != fast) {
            slow = nums[slow]
            fast = nums[nums[fast]]
        }
        var entrance = 0
        while (entrance != slow) {
            entrance = nums[entrance]
            slow = nums[slow]
        }
        return entrance
    }
}
