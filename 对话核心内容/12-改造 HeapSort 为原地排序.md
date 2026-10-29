# 改造 HeapSort 为原地排序

> 原对话日期：2026-09-08  
> Codex 会话 ID：`01a07f23-1892-7f23-ac96-8268c4a9db2c`  
> Source hash：`8d98321df4ec9199260425afe355194cc8ca10c75089be4c344cf622af7795bf`

## 问题

本对话围绕“改造 HeapSort 为原地排序”展开。

<!-- codex-generated-incremental:start -->
## 最新对话结论
- 结论：这版实现是正确的标准堆排序，使用 0 下标最大堆，能够原地完成升序排序。没有明显的算法性错误。
- 建堆范围 arr.size / 2 - 1 downTo 0 正确，起点是最后一个非叶子节点。
- heaping(arr, lastIndex, i) 把 lastIndex 作为包含边界，调用逻辑一致。
- 每轮将堆顶最大值交换到 i，再对 [0, i - 1] 重新堆化，最终得到升序数组。
- heaping 使用循环而非递归，额外空间复杂度为 O(1)。
- 时间复杂度：建堆 O(n)，排序 O(n log n)，总体 O(n log n)。
<!-- codex-generated-incremental:end -->
