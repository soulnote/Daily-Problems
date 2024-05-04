class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==1)return 0;
        int[][]dp = new int[n][2];
        for(int[]num : dp){
            Arrays.fill(num, -1);
        }
        return profit(prices, 0, 1, dp);
    }
    public int profit(int[]prices, int idx, int buying, int[][]dp){
        if(idx>= prices.length)return 0;

        if(dp[idx][buying]!=-1) return dp[idx][buying];
        //not paticipating on that day
        int notParticipated =  profit(prices, idx+1, buying, dp);
        int participated = Integer.MIN_VALUE;
        if(buying==1){
            participated = profit(prices, idx+1, Math.abs(buying-1), dp) - prices[idx];
        }
        else{
            participated = profit(prices, idx+2, Math.abs(buying-1), dp) + prices[idx];
        }

        return dp[idx][buying] = Math.max(participated, notParticipated);
    }
}