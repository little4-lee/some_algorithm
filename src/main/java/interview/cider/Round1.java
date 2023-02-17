package interview.cider;

public class Round1 {
   public static void main(String[] args) {
      int[] arr = {1, 2, 2, 3};//2
      int[] arr1 = {1, 1, 2, 2, 3};//1,2
      int[] arr2 = {1, 2, 3};//[]
      System.out.println(findRepeatCount(arr));
      System.out.println(findRepeatCount(arr1));
      System.out.println(findRepeatCount(arr2));
   }

   private static int findRepeatCount(int[] arr) {
      if (arr == null) return 0;
      int[] countArr = new int[10];
      for (int i = 0; i < arr.length; i++) {
         countArr[arr[i]]++;
      }

      int repeatCount = 0;
      for (int i : countArr) {
         if (i > 1) {
            repeatCount++;
         }
      }
      return repeatCount;
   }
}
