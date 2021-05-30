package search.l34_find_first_and_last_position_of_element_in_sorted_array;

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
public class L34 {

    public static void main (String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int first = -1;

        //find first
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    first = mid;
                    break;
                }
                else hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        if (first == -1) return new int[]{-1, -1};

        //last
        lo = first;
        hi = nums.length - 1;

        int last = -1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    last = mid;
                    break;
                }
                else lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return new int[]{first, last};
    }
}
