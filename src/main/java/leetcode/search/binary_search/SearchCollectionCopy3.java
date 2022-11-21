package leetcode.search.binary_search;

import static common.ArrayUtilsKt.printArray;

public class SearchCollectionCopy3 {
    /**
     * just find target, ignore repeat
     */
    private static class BinarySearch implements ISearch {
        @Override
        public int search(int[] arr, int target) {
            if (arr == null) return -1;

            int lo = 0;
            int hi = arr.length - 1;

            while (lo <= hi) {
                int middle = lo + ((hi - lo) >> 1);
                if (arr[middle] > target) {
                    hi = middle - 1;
                } else if (arr[middle] < target) {
                    lo = middle + 1;
                } else {
                    //equals
                    return middle;
                }
            }

            return -1;
        }
    }

    /**
     * find first target
     */
    private static class FindFirst implements ISearch {
        @Override
        public int search(int[] arr, int target) {

            return -1;
        }
    }


    /**
     * find last target
     */
    private static class FindLast implements ISearch {
        @Override
        public int search(int[] arr, int target) {

            return -1;
        }
    }

    /**
     * find first not less than target
     */
    private static class FindFirstNotLessThan implements ISearch {
        @Override
        public int search(int[] arr, int target) {

            return -1;
        }
    }

    /**
     * find last not more than target
     */
    private static class FindLastNotMoreThan implements ISearch {
        @Override
        public int search(int[] arr, int target) {

            return -1;
        }
    }


    public static void main(String[] args) {

        int target = 5;
        int count = 100;
        int[] arr1 = new int[count];
        int[] arr2 = new int[count];
        int[] arr3 = {1, 2, 3, 4, target, target, target, target, 10, 20, 22, 50, 100, 102};
        int[] arr4 = {target, target + 1, target + 1, target + 1, target + 1, target + 1};
        int[] arr5 = {target - 1, target - 1, target - 1, target - 1, target - 1, target};
        int[] arr6 = {1, 2, 3, 4, 6, 7, 8, 9};

        for (int i = 0; i < count; i++) {
            arr1[i] = i;
            arr2[i] = target;
        }
        int[][] numArrayArray = {arr1, arr2, arr3, arr4, arr5, arr6};
        ISearch[] searchArray = {new BinarySearch(),
                new FindFirst(),
                new FindLast(),
                new FindFirstNotLessThan(),
                new FindLastNotMoreThan()};

        for (ISearch search : searchArray) {
            System.out.println("===>" + search.getClass().getSimpleName());
            System.out.println("target: " + target);
            for (int[] numArray : numArrayArray) {
                printArray(numArray);
                System.out.println("\nresult: " + search.search(numArray, target) + "\n");
            }
            System.out.println("----------------------");
        }
    }
}
