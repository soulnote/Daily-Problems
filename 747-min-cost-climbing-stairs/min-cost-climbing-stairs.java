class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int  n = cost.length;
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(cost,n,dp);
    }
    public int helper(int []cost, int n, int[]dp){
        if(n==1 || n==0)return 0;
        if(dp[n]!=-1)return dp[n];
        int j1 = helper(cost, n-1, dp) + cost[n-1];
        int j2 = helper(cost, n-2, dp) + cost[n-2];
        return dp[n] = Math.min(j1,j2);
    }
}