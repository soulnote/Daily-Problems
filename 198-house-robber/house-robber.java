class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        // if(n==1)return nums[0];
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(nums,n-1, dp);
    }
    public int helper(int[]nums, int n, int[]dp){
        if(n==0 )return nums[n];
        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        int rob1 = helper(nums, n-1, dp);
        int rob2 = nums[n] + helper(nums, n-2, dp);
        return dp[n] = Math.max(rob1, rob2);
    }
}