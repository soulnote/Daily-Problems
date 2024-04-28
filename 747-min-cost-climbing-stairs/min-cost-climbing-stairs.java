class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n= cost.length;
        int []dp = new int[n+1];
        return Math.min(helper(0, cost, n, dp), helper(1, cost, n, dp));
    }
    int helper(int stair, int[]cost, int n, int[]dp){
        if(stair>=n){
            return 0;
        }
        if(dp[stair]!=0)return dp[stair];
        return dp[stair]= cost[stair]+Math.min(helper(stair+1, cost, n, dp),helper(stair+2, cost, n, dp));
    }
}