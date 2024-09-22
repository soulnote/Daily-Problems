class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for (int i = 0; i < dp.length; i++) {
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return maxi(prices, 0, 1 , 0 ,dp);
    }
    public int maxi(int[]prices, int idx, int buy, int buyCount,  int[][][]dp){
        if(idx==prices.length || buyCount>=2)return 0;
        if (dp[idx][buy][buyCount] != -1) {
            return dp[idx][buy][buyCount]; 
        }
        int profit = 0;
        if(buy==1){
            profit = Math.max(-prices[idx] + maxi(prices, idx+1, 0, buyCount, dp), maxi(prices, idx+1, 1, buyCount, dp));
        }
        else{
            profit = Math.max(prices[idx] + maxi(prices, idx+1, 1, buyCount+1, dp), maxi(prices, idx+1, 0, buyCount ,dp));
        }
        dp[idx][buy][buyCount] = profit;
        return profit;
    }
}