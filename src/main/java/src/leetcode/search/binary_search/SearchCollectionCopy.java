package leetcode.search.binary_search;

public class SearchCollectionCopy {

    public static void main (String[] args) {

        int target = 5;
        int count = 100;
        SearchCollectionCopy collection = new SearchCollectionCopy();
        int[] arr1 = new int[count];
        int[] arr2 = new int[count];
        int[] arr3 = {1, 2, 3, 4, target, target, target, target, 10, 20, 22, 50, 100, 102};
        int[] arr4 = {target, target + 1, target + 1, target + 1, target + 1, target + 1};
        int[] arr5 = {target - 1, target - 1, target - 1, target - 1, target - 1, target};

        for (int i = 0; i < count; i++) {
            arr1[i] = i;
            arr2[i] = target;
        }

        //
        //        System.out.println(collection.bSearch(arr1, target));
        //        System.out.println(collection.bSearch(arr2, target));
        //        System.out.println(collection.bSearch(arr3, target));
        //        System.out.println(collection.bSearch(arr4, target));
        //        System.out.println(collection.bSearch(arr5, target));

        //        System.out.println(collection.bSearchExt1(arr1, target));
        //        System.out.println(collection.bSearchExt1(arr2, target));
        //        System.out.println(collection.bSearchExt1(arr3, target));
        //        System.out.println(collection.bSearchExt1(arr4, target));
        //        System.out.println(collection.bSearchExt1(arr5, target));

        //                System.out.println(collection.bSearchExt2(arr1, target));
        //                System.out.println(collection.bSearchExt2(arr2, target));
        //                System.out.println(collection.bSearchExt2(arr3, target));
        //                System.out.println(collection.bSearchExt2(arr4, target));
        //                System.out.println(collection.bSearchExt2(arr5, target));

        System.out.println(collection.bSearchExt3(arr1, target));
        System.out.println(collection.bSearchExt3(arr2, target));
        System.out.println(collection.bSearchExt3(arr3, target));
        System.out.println(collection.bSearchExt3(arr4, target));
        System.out.println(collection.bSearchExt3(arr5, target));

        System.out.println(collection.bSearchExt4(arr1, target));
        System.out.println(collection.bSearchExt4(arr2, target));
        System.out.println(collection.bSearchExt4(arr3, target));
        System.out.println(collection.bSearchExt4(arr4, target));
        System.out.println(collection.bSearchExt4(arr5, target));

    }

    /**
     * just find target, ignore repeat
     *
     * @param arr
     * @param target
     * @return
     */
    public int bSearch (int[] arr, int target) {
        if (arr == null) return -1;

        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int middle = lo + ((hi - lo) >> 2);
            if (arr[middle] == target) return middle;
            else if (arr[middle] < target) lo = middle + 1;
            else if (arr[middle] > target) hi = middle - 1;
        }
        return -1;
    }

    /**
     * find first target
     *
     * @param arr
     * @param target
     * @return
     */
    public int bSearchExt1 (int[] arr, int target) {
        if (arr == null) return -1;

        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int middle = lo + ((hi - lo) >> 1);
            if (arr[middle] == target) {
                if (middle == 0 || arr[middle - 1] != target) return middle;
                else hi = middle - 1;
            } else if (arr[middle] < target) lo = middle + 1;
            else hi = middle - 1;

        }

        return -1;
    }

    /**
     * find last target
     *
     * @param arr
     * @param target
     * @return
     */
    public int bSearchExt2 (int[] arr, int target) {
        if (arr == null) return -1;

        int lo = 0;
        int hi = arr.length - 1;
        int lastIndex = hi;

        while (lo <= hi) {
            int middle = lo + ((hi - lo) >> 1);
            if (arr[middle] == target) {
                if (middle == lastIndex || arr[middle + 1] != target) return middle;
                else lo = middle + 1;
            } else if (arr[middle] < target) lo = middle + 1;
            else hi = middle - 1;

        }

        return -1;
    }

    /**
     * find first not less than target
     *
     * @param arr
     * @param target
     * @return
     */
    public int bSearchExt3 (int[] arr, int target) {
        if (arr == null) return -1;

        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int middle = lo + ((hi - lo) >> 1);
            if (arr[middle] >= target) {
                if (middle == 0 || arr[middle - 1] < target) return middle;
                else hi = middle - 1;
            } else {
                //middle < target
                lo = middle + 1;
            }
        }

        return -1;
    }

    /**
     * find last not more than target
     *
     * @param arr
     * @param target
     * @return
     */
    public int bSearchExt4 (int[] arr, int target) {
        if (arr == null) return -1;

        final int lastIndex = arr.length - 1;
        int lo = 0;
        int hi = lastIndex;

        while (lo <= hi) {
            int middle = lo + ((hi - lo) >> 1);
            if (arr[middle] <= target) {
                if (middle == lastIndex || arr[middle + 1] > target) return middle;
                else lo = middle + 1;
            } else {
                hi = middle - 1;
            }
        }

        return -1;
    }
}
