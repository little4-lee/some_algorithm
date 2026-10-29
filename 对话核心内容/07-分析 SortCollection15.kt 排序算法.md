# 分析 SortCollection15.kt 排序算法

> 原对话日期：2026-09-01  
> Codex 会话 ID：`01a05b36-8843-7da1-b4d0-90b180e21972`  
> Source hash：`5917726327806e8deec71bc0047239b110686645d1b0c68845b1bd03f9c10848`

## 问题

本对话围绕“分析 SortCollection15.kt 排序算法”展开。

<!-- codex-generated-incremental:start -->
## 最新对话结论
- 结论：当前快速排序实现逻辑正确，属于“末尾元素作为基准”的 Lomuto 分区算法。主要问题不在正确性，而在有序数组和大量重复元素下会严重退化。
- 入口在 SortCollection15.kt:86：
- sort() 处理 null 和空数组。
- doQuickSort() 对 [start, end] 排序。
- partition() 将 arr[end] 作为基准值。
- [start, position) 都 < value
<!-- codex-generated-incremental:end -->
