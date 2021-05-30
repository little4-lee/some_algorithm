package search.binary_search;

public class BinarySearchCollection {
    public static void main (String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 4, 4, 5, 6, 7, 8, 9, 11, 12, 14, 44, 56, 788};
        BinarySearchCollection search = new BinarySearchCollection();
        System.out.println(search.bSearch(nums, 0));
        System.out.println(search.bSearch(nums, 1));
        System.out.println(search.bSearch(nums, 15));
        System.out.println(search.bSearch(nums, 788));
        System.out.println(search.bSearch(nums, 789));
        System.out.println(search.bSearchExt1(nums, 4));
        System.out.println(search.bSearchExt2(nums, 4));
    }


    private int bSearch (int[] nums, int target) {
        if (nums == null) return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            System.out.println("middle: " + middle);
            if (nums[middle] == target) return middle;
            else if (nums[middle] < target) low = middle + 1;
            else high = middle - 1;
        }
        return -1;
    }

    /**
     * find first
     *
     * @param nums
     * @param target
     * @return
     */
    private int bSearchExt1 (int[] nums, int target) {
        if (nums == null) return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (nums[middle] == target) {
                if (middle == 0 || nums[middle - 1] != target) {
                    return middle;
                } else {
                    high = middle - 1;
                }
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * find last
     * @param nums
     * @param target
     * @return
     */
    private int bSearchExt2(int[] nums, int target) {
        if (nums == null) return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (nums[middle] == target) {
                if (middle == high || nums[middle + 1] != target) return middle;
                else low = middle + 1;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }
}
