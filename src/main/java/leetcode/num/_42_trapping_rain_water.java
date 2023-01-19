package leetcode.num;

/**
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 */
public class _42_trapping_rain_water {
    private static int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        //暴力法
        int sum = 0;
        for (int i = 1; i <= height.length - 2; i++) {
            //start: 1, end: length - 2
            //左边的最大值 maxLeft, 右边的最大值 maxRight
            int maxLeft = height[i], maxRight = height[i];
            for (int j = 0; j < i; j++) {
                if (height[j] > maxLeft) maxLeft = height[j];
            }
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > maxRight) maxRight = height[j];
            }

            //min(maxLeft, maxRight)
            int max = Math.min(maxLeft, maxRight);
            sum += max - height[i];
        }
        return sum;
    }

    public static void main (String[] args) {
        // TODO: 2023/1/19
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums));
    }


}
