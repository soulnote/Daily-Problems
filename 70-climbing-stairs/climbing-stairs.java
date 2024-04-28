class Solution {
    public int climbStairs(int n) {
        int []dp = new int[n+1];
        return helper(n,dp);
    }
    public int helper(int stair,int []dp){
        if(stair==0)return 1;
        if(stair<0) return 0;

        if(dp[stair]!=0)return dp[stair];
        int jump1 = helper(stair-1, dp);
        int jump2 = helper(stair-2, dp);
        return  dp[stair] = jump1+jump2;
    }
}