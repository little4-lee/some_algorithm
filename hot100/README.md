# LeetCode Hot 100 Kotlin 题解

本目录以 [LeetCode 官方 Top 100 Liked 学习计划](https://leetcode.cn/studyplan/top-100-liked/) 在 **2026-08-30** 的页面快照为目录基准。页面中的题目会随平台热度变化，因此这里的“Hot 100”是一个可追溯的快照，不声称永远固定。

## 内容和边界

- [题目与题解](./题目与题解.md)：每题包含英文等价题意、中文题意、核心思路、复杂度、容器易错点和对应代码方法。
- [Kotlin 实现](./Hot100Solutions.kt)：100 题的集中实现，使用独立的 `hot100` 包，避免污染原有练习代码。
- 题目原文的完整约束、示例和版权归 LeetCode 所有；每题都提供官方题目链接。仓库中的英文/中文段落是便于学习的等价题意，不替代官方页面。
- 公司/岗位只记录可以公开访问且能看到题号或题名的近期面经；“未核验”不会被写成确定结论。当前目录先提供证据登记模板，后续可按岗位和日期补充。

## 目录（按官方页面顺序）

| # | LC | English | 中文 | Link |
|---:|---:|---|---|---|
| 1 | 1 | Two Sum | 两数之和 | [题目](https://leetcode.com/problems/two-sum/) |
| 2 | 49 | Group Anagrams | 字母异位词分组 | [题目](https://leetcode.com/problems/group-anagrams/) |
| 3 | 128 | Longest Consecutive Sequence | 最长连续序列 | [题目](https://leetcode.com/problems/longest-consecutive-sequence/) |
| 4 | 283 | Move Zeroes | 移动零 | [题目](https://leetcode.com/problems/move-zeroes/) |
| 5 | 11 | Container With Most Water | 盛最多水的容器 | [题目](https://leetcode.com/problems/container-with-most-water/) |
| 6 | 15 | 3Sum | 三数之和 | [题目](https://leetcode.com/problems/3sum/) |
| 7 | 42 | Trapping Rain Water | 接雨水 | [题目](https://leetcode.com/problems/trapping-rain-water/) |
| 8 | 3 | Longest Substring Without Repeating Characters | 无重复字符的最长子串 | [题目](https://leetcode.com/problems/longest-substring-without-repeating-characters/) |
| 9 | 438 | Find All Anagrams in a String | 找到字符串中所有字母异位词 | [题目](https://leetcode.com/problems/find-all-anagrams-in-a-string/) |
| 10 | 560 | Subarray Sum Equals K | 和为 K 的子数组 | [题目](https://leetcode.com/problems/subarray-sum-equals-k/) |
| 11 | 239 | Sliding Window Maximum | 滑动窗口最大值 | [题目](https://leetcode.com/problems/sliding-window-maximum/) |
| 12 | 76 | Minimum Window Substring | 最小覆盖子串 | [题目](https://leetcode.com/problems/minimum-window-substring/) |
| 13 | 53 | Maximum Subarray | 最大子数组和 | [题目](https://leetcode.com/problems/maximum-subarray/) |
| 14 | 56 | Merge Intervals | 合并区间 | [题目](https://leetcode.com/problems/merge-intervals/) |
| 15 | 189 | Rotate Array | 轮转数组 | [题目](https://leetcode.com/problems/rotate-array/) |
| 16 | 238 | Product of Array Except Self | 除了自身以外数组的乘积 | [题目](https://leetcode.com/problems/product-of-array-except-self/) |
| 17 | 41 | First Missing Positive | 缺失的第一个正数 | [题目](https://leetcode.com/problems/first-missing-positive/) |
| 18 | 73 | Set Matrix Zeroes | 矩阵置零 | [题目](https://leetcode.com/problems/set-matrix-zeroes/) |
| 19 | 54 | Spiral Matrix | 螺旋矩阵 | [题目](https://leetcode.com/problems/spiral-matrix/) |
| 20 | 48 | Rotate Image | 旋转图像 | [题目](https://leetcode.com/problems/rotate-image/) |
| 21 | 240 | Search a 2D Matrix II | 搜索二维矩阵 II | [题目](https://leetcode.com/problems/search-a-2d-matrix-ii/) |
| 22 | 160 | Intersection of Two Linked Lists | 相交链表 | [题目](https://leetcode.com/problems/intersection-of-two-linked-lists/) |
| 23 | 206 | Reverse Linked List | 反转链表 | [题目](https://leetcode.com/problems/reverse-linked-list/) |
| 24 | 234 | Palindrome Linked List | 回文链表 | [题目](https://leetcode.com/problems/palindrome-linked-list/) |
| 25 | 141 | Linked List Cycle | 环形链表 | [题目](https://leetcode.com/problems/linked-list-cycle/) |
| 26 | 142 | Linked List Cycle II | 环形链表 II | [题目](https://leetcode.com/problems/linked-list-cycle-ii/) |
| 27 | 21 | Merge Two Sorted Lists | 合并两个有序链表 | [题目](https://leetcode.com/problems/merge-two-sorted-lists/) |
| 28 | 2 | Add Two Numbers | 两数相加 | [题目](https://leetcode.com/problems/add-two-numbers/) |
| 29 | 19 | Remove Nth Node From End of List | 删除链表的倒数第 N 个结点 | [题目](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) |
| 30 | 24 | Swap Nodes in Pairs | 两两交换链表中的节点 | [题目](https://leetcode.com/problems/swap-nodes-in-pairs/) |
| 31 | 25 | Reverse Nodes in k-Group | K 个一组翻转链表 | [题目](https://leetcode.com/problems/reverse-nodes-in-k-group/) |
| 32 | 138 | Copy List with Random Pointer | 随机链表的复制 | [题目](https://leetcode.com/problems/copy-list-with-random-pointer/) |
| 33 | 148 | Sort List | 排序链表 | [题目](https://leetcode.com/problems/sort-list/) |
| 34 | 23 | Merge k Sorted Lists | 合并 K 个升序链表 | [题目](https://leetcode.com/problems/merge-k-sorted-lists/) |
| 35 | 146 | LRU Cache | LRU 缓存 | [题目](https://leetcode.com/problems/lru-cache/) |
| 36 | 94 | Binary Tree Inorder Traversal | 二叉树的中序遍历 | [题目](https://leetcode.com/problems/binary-tree-inorder-traversal/) |
| 37 | 104 | Maximum Depth of Binary Tree | 二叉树的最大深度 | [题目](https://leetcode.com/problems/maximum-depth-of-binary-tree/) |
| 38 | 226 | Invert Binary Tree | 翻转二叉树 | [题目](https://leetcode.com/problems/invert-binary-tree/) |
| 39 | 101 | Symmetric Tree | 对称二叉树 | [题目](https://leetcode.com/problems/symmetric-tree/) |
| 40 | 543 | Diameter of Binary Tree | 二叉树的直径 | [题目](https://leetcode.com/problems/diameter-of-binary-tree/) |
| 41 | 102 | Binary Tree Level Order Traversal | 二叉树的层序遍历 | [题目](https://leetcode.com/problems/binary-tree-level-order-traversal/) |
| 42 | 108 | Convert Sorted Array to Binary Search Tree | 将有序数组转换为二叉搜索树 | [题目](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/) |
| 43 | 98 | Validate Binary Search Tree | 验证二叉搜索树 | [题目](https://leetcode.com/problems/validate-binary-search-tree/) |
| 44 | 230 | Kth Smallest Element in a BST | 二叉搜索树中第 K 小的元素 | [题目](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) |
| 45 | 199 | Binary Tree Right Side View | 二叉树的右视图 | [题目](https://leetcode.com/problems/binary-tree-right-side-view/) |
| 46 | 114 | Flatten Binary Tree to Linked List | 二叉树展开为链表 | [题目](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/) |
| 47 | 105 | Construct Binary Tree from Preorder and Inorder Traversal | 从前序与中序遍历序列构造二叉树 | [题目](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) |
| 48 | 437 | Path Sum III | 路径总和 III | [题目](https://leetcode.com/problems/path-sum-iii/) |
| 49 | 236 | Lowest Common Ancestor of a Binary Tree | 二叉树的最近公共祖先 | [题目](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) |
| 50 | 124 | Binary Tree Maximum Path Sum | 二叉树中的最大路径和 | [题目](https://leetcode.com/problems/binary-tree-maximum-path-sum/) |
| 51 | 200 | Number of Islands | 岛屿数量 | [题目](https://leetcode.com/problems/number-of-islands/) |
| 52 | 994 | Rotting Oranges | 腐烂的橘子 | [题目](https://leetcode.com/problems/rotting-oranges/) |
| 53 | 207 | Course Schedule | 课程表 | [题目](https://leetcode.com/problems/course-schedule/) |
| 54 | 208 | Implement Trie (Prefix Tree) | 实现 Trie（前缀树） | [题目](https://leetcode.com/problems/implement-trie-prefix-tree/) |
| 55 | 46 | Permutations | 全排列 | [题目](https://leetcode.com/problems/permutations/) |
| 56 | 78 | Subsets | 子集 | [题目](https://leetcode.com/problems/subsets/) |
| 57 | 17 | Letter Combinations of a Phone Number | 电话号码的字母组合 | [题目](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) |
| 58 | 39 | Combination Sum | 组合总和 | [题目](https://leetcode.com/problems/combination-sum/) |
| 59 | 22 | Generate Parentheses | 括号生成 | [题目](https://leetcode.com/problems/generate-parentheses/) |
| 60 | 79 | Word Search | 单词搜索 | [题目](https://leetcode.com/problems/word-search/) |
| 61 | 131 | Palindrome Partitioning | 分割回文串 | [题目](https://leetcode.com/problems/palindrome-partitioning/) |
| 62 | 51 | N-Queens | N 皇后 | [题目](https://leetcode.com/problems/n-queens/) |
| 63 | 35 | Search Insert Position | 搜索插入位置 | [题目](https://leetcode.com/problems/search-insert-position/) |
| 64 | 74 | Search a 2D Matrix | 搜索二维矩阵 | [题目](https://leetcode.com/problems/search-a-2d-matrix/) |
| 65 | 34 | Find First and Last Position of Element in Sorted Array | 在排序数组中查找元素的第一个和最后一个位置 | [题目](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) |
| 66 | 33 | Search in Rotated Sorted Array | 搜索旋转排序数组 | [题目](https://leetcode.com/problems/search-in-rotated-sorted-array/) |
| 67 | 153 | Find Minimum in Rotated Sorted Array | 寻找旋转排序数组中的最小值 | [题目](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) |
| 68 | 4 | Median of Two Sorted Arrays | 寻找两个正序数组的中位数 | [题目](https://leetcode.com/problems/median-of-two-sorted-arrays/) |
| 69 | 20 | Valid Parentheses | 有效的括号 | [题目](https://leetcode.com/problems/valid-parentheses/) |
| 70 | 155 | Min Stack | 最小栈 | [题目](https://leetcode.com/problems/min-stack/) |
| 71 | 394 | Decode String | 字符串解码 | [题目](https://leetcode.com/problems/decode-string/) |
| 72 | 739 | Daily Temperatures | 每日温度 | [题目](https://leetcode.com/problems/daily-temperatures/) |
| 73 | 84 | Largest Rectangle in Histogram | 柱状图中最大的矩形 | [题目](https://leetcode.com/problems/largest-rectangle-in-histogram/) |
| 74 | 215 | Kth Largest Element in an Array | 数组中的第 K 个最大元素 | [题目](https://leetcode.com/problems/kth-largest-element-in-an-array/) |
| 75 | 347 | Top K Frequent Elements | 前 K 个高频元素 | [题目](https://leetcode.com/problems/top-k-frequent-elements/) |
| 76 | 295 | Find Median from Data Stream | 数据流的中位数 | [题目](https://leetcode.com/problems/find-median-from-data-stream/) |
| 77 | 121 | Best Time to Buy and Sell Stock | 买卖股票的最佳时机 | [题目](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) |
| 78 | 55 | Jump Game | 跳跃游戏 | [题目](https://leetcode.com/problems/jump-game/) |
| 79 | 45 | Jump Game II | 跳跃游戏 II | [题目](https://leetcode.com/problems/jump-game-ii/) |
| 80 | 763 | Partition Labels | 划分字母区间 | [题目](https://leetcode.com/problems/partition-labels/) |
| 81 | 70 | Climbing Stairs | 爬楼梯 | [题目](https://leetcode.com/problems/climbing-stairs/) |
| 82 | 118 | Pascal's Triangle | 杨辉三角 | [题目](https://leetcode.com/problems/pascals-triangle/) |
| 83 | 198 | House Robber | 打家劫舍 | [题目](https://leetcode.com/problems/house-robber/) |
| 84 | 279 | Perfect Squares | 完全平方数 | [题目](https://leetcode.com/problems/perfect-squares/) |
| 85 | 322 | Coin Change | 零钱兑换 | [题目](https://leetcode.com/problems/coin-change/) |
| 86 | 139 | Word Break | 单词拆分 | [题目](https://leetcode.com/problems/word-break/) |
| 87 | 300 | Longest Increasing Subsequence | 最长递增子序列 | [题目](https://leetcode.com/problems/longest-increasing-subsequence/) |
| 88 | 152 | Maximum Product Subarray | 乘积最大子数组 | [题目](https://leetcode.com/problems/maximum-product-subarray/) |
| 89 | 416 | Partition Equal Subset Sum | 分割等和子集 | [题目](https://leetcode.com/problems/partition-equal-subset-sum/) |
| 90 | 32 | Longest Valid Parentheses | 最长有效括号 | [题目](https://leetcode.com/problems/longest-valid-parentheses/) |
| 91 | 62 | Unique Paths | 不同路径 | [题目](https://leetcode.com/problems/unique-paths/) |
| 92 | 64 | Minimum Path Sum | 最小路径和 | [题目](https://leetcode.com/problems/minimum-path-sum/) |
| 93 | 5 | Longest Palindromic Substring | 最长回文子串 | [题目](https://leetcode.com/problems/longest-palindromic-substring/) |
| 94 | 1143 | Longest Common Subsequence | 最长公共子序列 | [题目](https://leetcode.com/problems/longest-common-subsequence/) |
| 95 | 72 | Edit Distance | 编辑距离 | [题目](https://leetcode.com/problems/edit-distance/) |
| 96 | 136 | Single Number | 只出现一次的数字 | [题目](https://leetcode.com/problems/single-number/) |
| 97 | 169 | Majority Element | 多数元素 | [题目](https://leetcode.com/problems/majority-element/) |
| 98 | 75 | Sort Colors | 颜色分类 | [题目](https://leetcode.com/problems/sort-colors/) |
| 99 | 31 | Next Permutation | 下一个排列 | [题目](https://leetcode.com/problems/next-permutation/) |
| 100 | 287 | Find the Duplicate Number | 寻找重复数 | [题目](https://leetcode.com/problems/find-the-duplicate-number/) |

## 公司/岗位证据登记

“近期考到”需要同时满足：公开帖子有发布时间、公司和岗位（例如 Android/后端/算法）、并明确写出题号或可唯一对应的题名。搜索摘要、培训机构题库和没有日期的旧帖只作为线索，不作为确认记录。建议后续按下表补充原帖 URL、发布日期、面试轮次和证据等级（A=原帖明确题号，B=原帖明确题名，C=二手汇总）：

| LC | 公司 | 岗位/轮次 | 日期 | 原帖 | 证据等级 | 状态 |
|---:|---|---|---|---|:---:|---|
| - | 待核验 | 待核验 | - | - | - | 未发布具体面经，避免编造 |
