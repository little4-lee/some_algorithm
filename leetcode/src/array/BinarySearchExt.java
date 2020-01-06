package array;

/**
 * 二分查找的扩展
 */
public class BinarySearchExt {

    /**
     * 查找递增数组中第一个大于等于某个给定值的元素
     * @return -1: 未找到
     */
    public int findFirstEqualOrLargerIndex (int[] array, int num) {
        if (array == null || array.length == 0) return -1;

        int start = 0;
        int end = array.length - 1;

        while (start != end) {
            int middle = start + (end - start) / 2;

            if (array[middle] >= num) {
                if (start == middle) return middle;
                else
                    if (array[middle - 1] < num) return middle;
                    else end = middle -1;

            } else {
                start = middle + 1;
            }
        }
        if (array[start] >= num) {
            return start;
        } else {
            return -1;
        }
    }

    public static void main (String[] args) {
        testFFLI();
    }

    public static void testFFLI() {
        BinarySearchExt binarySearchExt = new BinarySearchExt();
        System.out.println(binarySearchExt.findFirstEqualOrLargerIndex(null, 1));
        System.out.println(binarySearchExt.findFirstEqualOrLargerIndex(new int [0], 1));
        System.out.println(binarySearchExt.findFirstEqualOrLargerIndex(new int [] {0}, 1));
        System.out.println(binarySearchExt.findFirstEqualOrLargerIndex(new int [] {1}, 1));
        System.out.println(binarySearchExt.findFirstEqualOrLargerIndex(new int [] {0, 0}, 1));
        System.out.println(binarySearchExt.findFirstEqualOrLargerIndex(new int [] {0, 1}, 1));
        System.out.println(binarySearchExt.findFirstEqualOrLargerIndex(new int [] {1, 1}, 1));
        System.out.println(binarySearchExt.findFirstEqualOrLargerIndex(new int [] {0, 1, 2}, 1));
        System.out.println(binarySearchExt.findFirstEqualOrLargerIndex(new int [] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 1));
        System.out.println(binarySearchExt.findFirstEqualOrLargerIndex(new int [] {0, 1, 1, 1, 1, 1, 6, 7, 8, 9}, 1));
        System.out.println(binarySearchExt.findFirstEqualOrLargerIndex(new int [] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 10));
    }
}
