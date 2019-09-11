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
    if (n == 1) return 1;
    if (n == 2) return 2;

    int count = 0;
    int minStep = 1;
    int maxStep = 2;
    int rows = n / minStep;

    int[][] array = new int[rows][n + 1];

    for (int i = minStep; i <= maxStep; i++) {
        array[0][i] = 1;
    }

    for (int i = 1; i < rows; i++) {
        //stepScope: min~max 1~2here
        for (int j = minStep; j <= maxStep; j++) {
            for (int k = 0; k <= n - j; k++) {
                if (array[i-1][k] > 0) {
                    //到达k有几种策略，到达k+j就要加上这么多的策略数
                    array[i][k+j] += array[i-1][k];
                }
            }
        }
    }

    for (int i = 0; i < rows; i++) {//计算所有总数为n的策略数
        count += array[i][n];
    }

    return count;
}

    public static int climbStairs2(int n) {
        int[] climbMap = new int[n + 1];
        climbMap[0] = 1;
        climbMap[1] = 1;

        for (int i = 2; i < climbMap.length; i++) {
            climbMap[i] = climbMap[i - 1] + climbMap[i - 2];
        }
        return climbMap[n];
    }

    public static void main (String[] args) {
        for (int i = 4; i < 20; i++) {
            System.out.println(new L70().climbStairs(i));
            System.out.println(new L70().climbStairs2(i));
            System.out.println();
        }
    }
}
