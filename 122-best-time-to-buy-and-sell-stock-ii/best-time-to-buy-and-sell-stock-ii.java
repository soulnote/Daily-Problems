class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = -1; 
            dp[i][1] = -1;
        }
        return maxi(prices, 0, 1,dp);
    }
    public int maxi(int[]prices, int idx, int buy, int[][]dp){
        if(idx==prices.length)return 0;
        if (dp[idx][buy] != -1) {
            return dp[idx][buy]; 
        }
        int profit = 0;
        if(buy==1){
            profit = Math.max(-prices[idx] + maxi(prices, idx+1, 0,dp), maxi(prices, idx+1, 1,dp));
        }
        else{
            profit = Math.max(prices[idx] + maxi(prices, idx+1, 1,dp), maxi(prices, idx+1, 0,dp));
        }
        dp[idx][buy] = profit;
        return profit;
    }
}