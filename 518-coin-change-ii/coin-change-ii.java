class Solution {
    public int change(int amount, int[] coins) {
        int[][]dp = new int[coins.length+1][amount+1];
        for(int[]num : dp){
            Arrays.fill(num, -1);
        }
        
        return totalcount(0, amount, coins, dp);
    }
    public int totalcount(int idx, int amount, int[]coins, int[][]dp){
        //base case
        if(amount==0)return 1;
        if(amount<0 || idx>=coins.length)return 0;
        //checking cache
        if(dp[idx][amount]!=-1)return dp[idx][amount];
        //take
        int take = totalcount(idx, amount-coins[idx], coins, dp);

        //not take
        int notTake = totalcount(idx+1, amount, coins, dp);
        
        return dp[idx][amount] = take + notTake;
    }
}