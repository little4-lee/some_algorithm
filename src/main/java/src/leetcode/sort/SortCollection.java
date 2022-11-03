package leetcode.sort;

public class SortCollection {


    public int[] quickSort (int[] nums) {
        quickInternal(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickInternal (int[] nums, int start, int end) {
        if (start >= end) return;

        int position = partition(nums, start, end);

        quickInternal(nums, start, position - 1);
        quickInternal(nums, position + 1, end);
    }

    private int partition (int[] nums, int start, int end) {
        int p = getAppropriatePosition(start, end);
        int value = nums[p];

        int position = start;
        for (int i = start; i != p && i <= end; i++) {
            if (nums[i] < value) {
                int tmp = nums[position];
                nums[position] = nums[i];
                nums[i] = tmp;
                position++;
            }
        }
        nums[p] = nums[position];
        nums[position] = value;

        return position;
    }

    /**
     * TODO optimize
     * @param start
     * @param end
     * @return
     */
    private int getAppropriatePosition (int start, int end) {
        return end;
    }


}
