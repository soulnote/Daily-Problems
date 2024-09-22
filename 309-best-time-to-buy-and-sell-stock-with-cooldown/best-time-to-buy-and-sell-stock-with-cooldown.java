import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        // Memoization array jo results ko store karega: dp[day jo price ka index hai][buy ko 1 se/sell ko 0 se]
        int[][] dp = new int[prices.length][2];

        // dp array ko -1 se initialize kar rahe hain (unvisited state)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Pehle din se aur buy karne ka option leke start karenge
        return maxi(0, 1, prices, dp); 
    }

    public int maxi(int idx, int buy, int[] prices, int[][] dp) {
        // Base case: Agar sab din khatam ho gaye to return 0 (aur koi din nahi bacha)
        if (idx >= prices.length) return 0;

        // Check karenge agar result pehle se memoize kiya hua hai
        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }

        int profit = 0;
        if (buy == 1) {
            // Option hai ya to stock kharid lo ya skip karo
            profit = Math.max(-prices[idx] + maxi(idx + 1, 0, prices, dp), 
                              maxi(idx + 1, 1, prices, dp));
        } else {
            // Option hai ya to stock bech lo ya skip karo
            // Agar bechte ho to next din kharid nahi sakte, to idx + 2 pe move karna padega
            profit = Math.max(prices[idx] + maxi(idx + 2, 1, prices, dp), 
                              maxi(idx + 1, 0, prices, dp));
        }

        // Result ko dp array me store karenge
        dp[idx][buy] = profit;
        return profit;
    }
}
