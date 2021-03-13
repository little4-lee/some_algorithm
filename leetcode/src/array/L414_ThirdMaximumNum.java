package array;

public class L414_ThirdMaximumNum {


    public int thirdMax(int[] nums) {
        Integer[] a = new Integer[3];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < a.length; j++) {

                if (a[j] == null) {
                    a[j] = nums[i];
                    break;
                }
                if (nums[i] == a[j]) break;
                if (nums[i] <= a[j]) continue;

                //move
                for (int k = a.length - 1; k > j; k--) {
                    if (a[k] == null) {
                        a[k] = a[k - 1];
                    } else if (a[k] != a[k - 1]) {
                        a[k] = a[k - 1];
                    }
                }
                a[j] = nums[i];
                break;
            }
        }

        return a[2] == null ? a[0] : a[2];
    }

    public static void main (String[] args) {
        int [] arr = {3,2,1};
        int [] arr1 = {1,2};
        int [] arr2 = {1,1,1,1,2};
        int [] arr3 = {1,2,100,100,2};
        int [] arr4 = {11, 2, 2, 5, 33, 5, 6, 47, 8, 99, 99, 10, 100};
        System.out.println(new L414_ThirdMaximumNum().thirdMax(arr));
        System.out.println(new L414_ThirdMaximumNum().thirdMax(arr1));
        System.out.println(new L414_ThirdMaximumNum().thirdMax(arr2));
        System.out.println(new L414_ThirdMaximumNum().thirdMax(arr3));
        System.out.println(new L414_ThirdMaximumNum().thirdMax(arr4));
    }
}
