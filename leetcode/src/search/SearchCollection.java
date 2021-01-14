package search;

public class SearchCollection {

    public static void main (String[] args) {

        int target = 5;
        int count = 100;
        SearchCollection collection = new SearchCollection();
        int [] arr1 = new int[count];
        int [] arr2 = new int[count];
        int [] arr3 = {1,2,3,4,target,target,target,target,10,20,22,50,100,102};

        for (int i = 0; i < count; i++) {
            arr1[i] = i;
            arr2[i] = target;
        }


        System.out.println(collection.bSearch(arr1, target));
        System.out.println(collection.bSearch(arr2, target));
        System.out.println(collection.bSearch(arr3, target));

    }

    /**
     * just find target, ignore repeat
     * @param arr
     * @param target
     * @return
     */
    public int bSearch (int [] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }


}
