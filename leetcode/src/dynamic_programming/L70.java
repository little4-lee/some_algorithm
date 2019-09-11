package dynamic_programming;

/**
 * 70. Climbing Stairs 爬楼梯
 * https://leetcode.com/problems/climbing-stairs/
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 */
public class L70 {
    public int climbStairs (int n) {
        if (n < 3) return n;

        int res = 0;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main (String[] args) {
        //        System.out.println(new L70().climbStairs(1));
        //        System.out.println(new L70().climbStairs(2));
        //        System.out.println(new L70().climbStairs(3));
        //        System.out.println(new L70().climbStairs(4));
        //        System.out.println(new L70().climbStairs(5));
        //        System.out.println(new L70().climbStairs(6));
        //        System.out.println(new L70().climbStairs(7));
        //        System.out.println(new L70().climbStairs(8));
        //        System.out.println(new L70().climbStairs(9));
        System.out.println(new L70().climbStairs(44));

        //        L70 l70 = new L70();
        //        for (int i = 1; i <= 20; i++) {
        //            l70.count = 0;
        //            System.out.print("n: " + i);
        //            System.out.print("; result: " + l70.climbStairs(i));
        //            System.out.print("; count: " + l70.count);
        //            System.out.println();
        //        }
    }
}
