class Solution {
    public int maxProfit(int k, int[] prices) {
        // Create a 3D dp array where dp[day][buy/sell][transactionCount]
        int[][][] dp = new int[prices.length][2][k];

        // Use Arrays.fill to initialize the dp array
        for (int[][] day : dp) {
            for (int[] trans : day) {
                Arrays.fill(trans, -1); // Fill each 1D array with -1
            }
        }

        return maxi(prices, 0, 1, 0, dp, k); // Start with buying state
    }

    public int maxi(int[] prices, int idx, int buy, int transactionCount, int[][][] dp, int k) {
        // Base case: If all days are done or we completed two transactions, return 0 profit
        if (idx == prices.length || transactionCount == k) return 0;

        // Check if we've already computed this state
        if (dp[idx][buy][transactionCount] != -1) {
            return dp[idx][buy][transactionCount];
        }

        int profit = 0;
        if (buy == 1) {
            // We can either buy or skip
            profit = Math.max(-prices[idx] + maxi(prices, idx + 1, 0, transactionCount, dp , k), 
                              maxi(prices, idx + 1, 1, transactionCount, dp, k));
        } else {
            // We can either sell or skip
            profit = Math.max(prices[idx] + maxi(prices, idx + 1, 1, transactionCount + 1, dp, k), 
                              maxi(prices, idx + 1, 0, transactionCount, dp, k));
        }

        // Memoize the result
        dp[idx][buy][transactionCount] = profit;
        return profit;
    }
}
