# 评价一下： SortCollection19.kt的快速排序实现中partition中的边界检查是否有必要

> 原对话日期：2026-09-03  
> Codex 会话 ID：`01a06526-a313-7fb3-aae3-919362f3733e`  
> Source hash：`1e0753f0059226c99eb0d53bd164da814520f8ef0363f721016c6fa780b1b57e`

## 问题

本对话围绕“评价一下： SortCollection19.kt的快速排序实现中partition中的边界检查是否有必要”展开。

<!-- codex-generated-incremental:start -->
## 最新对话结论
- i !in arr.indices 和 j !in arr.indices 同时覆盖负数和 = arr.size 的上界越界，也能处理空数组。
- i == j 时跳过自交换是安全的，只是一个微优化，不影响正确性。
- 当前两个调用点 SortCollection19.kt:74 和 SortCollection19.kt:79 的索引都能由 partition 的不变量保证合法。
<!-- codex-generated-incremental:end -->
