package leetcode.tree;

public class HeapUtils {
    public static void heapSort (int[] nums) {
        buildHeap(nums);
        sort(nums);
    }


    /**
     * 建堆
     *
     * @param nums
     */
    private static void buildHeap (int[] nums) {

        int index;
        for (int i = 1; i < nums.length; i++) {
            index = i;
            //insert to heap
            while (nums[index] > nums[index / 2] && index / 2 > 0) {
                int temp = nums[index];
                nums[index] = nums[index / 2];
                nums[index / 2] = temp;
                index = index / 2;
            }
        }
    }

    private static void sort (int[] nums) {
        int k = nums.length - 1;
        while (k > 1) {
            swap(nums, 1, k);
            k--;
            heaping(nums, k, 1);
        }
    }

    private static void heaping (int[] nums, int count, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= count && nums[i * 2] > nums[i]) maxPos = i * 2;
            if (i * 2 + 1 <= count && nums[i * 2 + 1] > nums[maxPos]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(nums, maxPos, i);
            i = maxPos;
        }
    }

    private static void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 打印堆
     *
     * @param heap
     * @param root 根节点位置
     */
    public static void printHeap (int[] heap, int root) {
        // TODO: 2021/4/8
        int level = 0;
        int index = root;
        int start = root;
        int end = root;
        int maxLevel = log2(heap.length - root);

        while (start < heap.length) {
            while (index >= start && index <= end) {
                if (index >= heap.length) break;
                String space = getSpace(maxLevel, level, "   ");
                if (index == start) {
                    //print space
                    System.out.print(space);
                }
                space = getSpace(maxLevel, level, " ");
                System.out.print(space + heap[index] + " ");
                index++;
            }
            System.out.println();
            level++;
            start = end + 1;
            end = start + (int) Math.pow(2, level) - 1;
        }
    }

    private static String getSpace (int maxLevel, int level, String s) {
        int step = maxLevel - level;
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < step; i++) {
            space.append(s);
        }
        return space.toString();
    }

    public static void main (String[] args) {
        int[] heap = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        buildHeap(heap);
        printArr(heap);
        sort(heap);
        printArr(heap);
        printHeap(heap, 0);
    }

    public static int log2 (int n) {
        return (int) (Math.log(n) / Math.log(2));
    }

    public static void printArr (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
