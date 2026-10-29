# 评价 FindFirst 算法实现

> 原对话日期：2026-09-04  
> Codex 会话 ID：`01a06a68-5905-7b01-9b81-790ed48659ae`  
> Source hash：`fe148de2017716b56b47e61e6d720d0829fdc76b68f96e3b2d1fa1dc7456a8fd`

## 问题

本对话围绕“评价 FindFirst 算法实现”展开。

<!-- codex-generated-incremental:start -->
## 最新对话结论
- 结论：按当前工作树中的 SearchCollectionCopy9.kt:73，在 arr 已按非降序排列（允许重复）的前提下，FindFirst 算法正确；时间复杂度 O(log n)，空间复杂度 O(1)。没有发现功能性算法错误。
- arr[mid] < target 时右移 low，arr[mid] target 时左移 high，二分边界更新正确。
- 命中后，若 mid == low，说明当前区间左侧已经被证明小于 target；否则检查 arr[mid - 1]。若左邻居也是 target，继续向左搜索。
- mid == low arr[mid - 1] != target 使用了短路求值，不会发生 mid - 1 越界。
- low + (high - low) / 2 的中点写法可避免常见的 low + high 溢出。
- mid == low 可读性较弱
<!-- codex-generated-incremental:end -->
