class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maxi(0, prices, 1, fee, dp);
    }

    public int maxi(int idx , int[]prices, int buy, int fee, int[][]dp){
        if(idx>=prices.length)return 0;

        if(dp[idx][buy]!= -1)return dp[idx][buy];
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[idx]+ maxi(idx+1, prices, 0, fee, dp), maxi(idx+1, prices, 1, fee, dp));
        }
        else{
            profit = Math.max(prices[idx] + maxi(idx+1, prices, 1, fee, dp)- fee, maxi(idx+1, prices, 0, fee, dp));
        }
        dp[idx][buy] = profit;
        return profit;
    }
}