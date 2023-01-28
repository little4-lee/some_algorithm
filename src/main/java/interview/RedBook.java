package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 接雨水问题
 * Explanation:
 * The above elevation map (black section) is represented by array
 * [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 */

class RedBook {
    public int trap(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int count = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (isPartlyMax(nums, i)) {
                list.add(i);
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
            //list.get(i) .. list.get(i + 1)
            int point = list.get(i);
            int nextPoint = list.get(i + 1);
            int min = Math.min(nums[point], nums[nextPoint]);
            for (int j = point + 1; j < nextPoint; j++) {
                count += (min - nums[j]);
            }
        }

        return count;
    }

    /**
     * 局部最优解
     *
     * @param nums
     * @param i
     * @return
     */
    private static boolean isPartlyMax(int[] nums, int i) {
        if (i == 0) return nums[i + 1] < nums[i];
        if (i == nums.length - 1) return nums[i - 1] < nums[i];
        return nums[i - 1] < nums[i] && nums[i + 1] < nums[i];
    }

    public static void main(String[] args) {
//        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] nums = {4,2,0,3,2,5};
        System.out.println(new RedBook().trap(nums));
    }

}
