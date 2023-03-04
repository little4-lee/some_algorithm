package interview.baidu;

public class Round3 {
   public static void main(String[] args) {
      test();
   }

   public static void test() {
      System.out.println(recursiveSum(100));
   }

   private static int recursiveSum(int num) {
      if (num == 1) return 1;
      return recursiveSum(num - 1) + num;
   }
}
