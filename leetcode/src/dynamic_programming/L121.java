package dynamic_programming;

/**
 * Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class L121 {
//    /**
//     * Exhaustive method
//     * @param prices
//     * @return
//     */
//    public int maxProfit (int[] prices) {
//        int profit = 0;
//        for (int i = 0; i < prices.length - 1; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                if (prices[j] - prices[i] > profit) {
//                    profit = prices[j] - prices[i];
//                }
//            }
//        }
//        return profit;
//    }

    public int maxProfit (int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int profit = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > profit) profit = prices[i] - min;
            if (prices[i] < min) min = prices[i];
        }

        return profit;
    }

    public static void main (String[] args) {
                int[] array = {7, 1, 5, 3, 6, 4};
//        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(new L121().maxProfit(array));
    }
}
