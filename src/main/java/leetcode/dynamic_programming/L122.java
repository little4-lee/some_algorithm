package leetcode.dynamic_programming;

/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class L122 {
    public int maxProfit (int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int profit = 0;
        int readyToBuyPrice = prices[0];
        int buyPrice = -1;
        int readyToSellPrice = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice != readyToBuyPrice) {
                //look for buy price
                if (prices[i] < readyToBuyPrice) readyToBuyPrice = prices[i];
                else {
                    buyPrice = readyToBuyPrice;
                    readyToSellPrice = prices[i];
                    if (i == prices.length - 1) {
                        //i is the last index, sell it
                        profit += readyToSellPrice - buyPrice;
                    }
                }
            } else {
                //look for sell price
                if (prices[i] < readyToSellPrice) {
                    //sell at this price
                    profit += readyToSellPrice - buyPrice;
                    readyToBuyPrice = prices[i];
                    buyPrice = -1;
                } else {
                    readyToSellPrice = prices[i];
                    if (i == prices.length - 1) {
                        //i is the last index, sell it
                        profit += readyToSellPrice - buyPrice;
                    }
                }
            }
        }

        return profit;
    }

    public static void main (String[] args) {
        //                int[] array = {1, 2, 3, 4, 5};
        //                int[] array = {7, 6, 4, 3, 1};
        //                int[] array = {7, 1, 5, 3, 6, 4};
        int[] array = {1, 2};
        System.out.println(new L122().maxProfit(array));
    }
}
