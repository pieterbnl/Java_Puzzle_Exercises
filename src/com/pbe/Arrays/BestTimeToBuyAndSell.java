package com.pbe.Arrays;

// LEETCODE.COM: Best Time to Buy and Sell Stock II
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// Example 1:
// Input: prices = [7,1,5,3,6,4]
// Output: 7
// Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
// Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

// Constraints:
// 1 <= prices.length <= 3 * 104
// 0 <= prices[i] <= 104

public class BestTimeToBuyAndSell {

    public static void main(String[] args) {
        int[] prices = {1, 5, 4, 3, 8, 4};
//        int[] prices = {7, 1, 5, 3, 6, 4, 20};
//        int[] prices = {1, 2, 3, 4, 5};
//        int[] prices = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(prices));
    }

    // Need to find sets of buying and selling prices which together lead to the max possible profit.

    // 1. One pass solution
//    public static int maxProfit(int[] prices) {
//        int maxprofit = 0; // set max profit
//        for (int i = 1; i < prices.length; i++) { // loop through full prices array, starting from element 1
//            if (prices[i] > prices[i - 1]) // compare element with previous and see if value is large
//                maxprofit += prices[i] - prices[i - 1]; // if so, add to profit
//        }
//        return maxprofit; // return max profit
//    }

    // 2. Brute force solution
    // Calculating profit according all possible sets and find the max combo.
    public static int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }

    public static int calculate(int[] prices, int s) {
        int totalProfit = 0;

        for (int start = s; start < prices.length; start++) { // loop through array, starting from s position
            int maxDayProfit = 0; // set max day profit to 0 for new loop
            for (int i = start + 1; i < prices.length; i++) { // loop through array to check day to day price differences, starting from s+1 position
                if (prices[start] < prices[i]) { // check price difference between the days
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start]; // recursive call
                    if (profit > maxDayProfit) // check if newly found profit is larger than current max day profit
                        maxDayProfit = profit; // if so, set new maxdayprofit
                }
            }
            if (maxDayProfit > totalProfit)
                totalProfit = maxDayProfit;
        }
        return totalProfit;
    }
}