package array;

/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/
 * <p>
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 */
public class L75 {
    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int BLUE = 2;

    public void sortColors (int[] nums) {
        if (nums == null) return;

        int lastRedIndex = -1;
        int firstBlueIndex = nums.length;

        int cur = 0;
        int temp;
        while (cur < Math.min(nums.length, firstBlueIndex)) {
            if (nums[cur] == RED) {
                lastRedIndex++;
                if (cur == lastRedIndex) {
                    //no swap
                } else {
                    //do swap
                    temp = nums[lastRedIndex];
                    nums[lastRedIndex] = nums[cur];
                    nums[cur] = temp;
                }
                cur++;
                continue;
            }

            if (nums[cur] == BLUE) {
                firstBlueIndex--;
                temp = nums[firstBlueIndex];
                nums[firstBlueIndex] = nums[cur];
                nums[cur] = temp;
                continue;
            }

            cur++;
        }
    }

    public static void main (String[] args) {
        int[] array = {2,2,2,1,2,1,2,0,2,1,0,0,0,2};
        new L75().sortColors(array);
        ArrayUtils.printArray(array);
    }
}
