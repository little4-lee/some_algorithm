package dynamic_programming;

/**
 * Min Cost Climbing Stairs
 * <p>
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor,
 * and you can either start from the step with index 0, or the step with index 1.
 * <p>
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * path: cost[0]-->cost[2]-->cost[4]-->cost[6]-->cost[7]-->cost[9]
 * cost:   1   -->  1    -->   1   -->   1   -->   1   -->  1    = 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 */
public class L746 {
    public int minCostClimbingStairs (int[] cost) {
        if (cost == null || cost.length <= 1) return 0;
        int[][] array = new int[cost.length][cost.length];

        //init data
        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost.length; j++) {
                array[i][j] = -1;
            }
        }

        //first row
        array[0][0] = cost[0];
        array[0][1] = cost[1];

        int minStep = 1000;
        if (cost.length <= 3) minStep = cost[cost.length - 2];

        for (int i = 1; i < cost.length; i++) {
            //step: 1
            for (int j = 0; j < cost.length - 1; j++) {
                if (array[i - 1][j] != -1) {
                    if (array[i][j + 1] == -1 || array[i][j + 1] > array[i - 1][j] + cost[j + 1]) {
                        array[i][j + 1] = array[i - 1][j] + cost[j + 1];
                        if (j == cost.length - 2 || j == cost.length - 3)
                            if (array[i][j + 1] < minStep) minStep = array[i][j + 1];
                    }
                }
            }

            //step: 2
            for (int k = 0; k < cost.length - 2; k++) {
                if (array[i - 1][k] != -1) {
                    if (array[i][k + 2] == -1 || array[i][k + 2] > array[i - 1][k] + cost[k + 2]) {
                        array[i][k + 2] = array[i - 1][k] + cost[k + 2];
                        if (k == cost.length - 3 || k == cost.length - 4)
                            if (array[i][k + 2] < minStep) minStep = array[i][k + 2];
                    }
                }
            }

        }
        return minStep;
    }

    public static void main (String[] args) {
        //        int[] array = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] array = {10, 15, 20};
        //        int[] array = {10, 15, 1, 100};
        System.out.println(new L746().minCostClimbingStairs(array));
    }
}
