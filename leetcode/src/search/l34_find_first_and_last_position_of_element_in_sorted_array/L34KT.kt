package search

/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]

 */
fun searchRange(nums: IntArray, target: Int): IntArray {
    //first
    var lo = 0
    var hi = nums.size - 1
    var first = -1

    loop@ while (lo <= hi) {
        val mid = lo + ((hi - lo) shr 1)
        when {
            nums[mid] > target -> hi = mid - 1
            nums[mid] < target -> lo = mid + 1
            else -> {
                if (mid == 0 || nums[mid - 1] != target) {
                    first = mid
                    break@loop
                }
                else hi = mid - 1
            }
        }
    }

    if (first == -1) return intArrayOf(-1, -1)

    //last
    lo = first
    hi = nums.size - 1
    var last = first
    while (lo <= hi) {
        val mid = lo + ((hi - lo) shr 1)
        if (nums[mid] > target) hi = mid - 1
        else {
            if (mid == nums.size - 1 || nums[mid + 1] != target) {
                last = mid
                break
            } else {
                lo = mid + 1
            }
        }
    }

    return intArrayOf(first, last)
}