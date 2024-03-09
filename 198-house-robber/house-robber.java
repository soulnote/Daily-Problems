class Solution {
    public int rob(int[] nums) {
        int []dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int robbedmoney = solve(0,nums,dp);
        return robbedmoney;
    }
    public int solve(int idx, int []nums, int[] dp){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx]>=0) return dp[idx];
        int a =solve(idx+1,nums,dp);
        int b= nums[idx] + solve(idx+2,nums,dp);

        return dp[idx]=Math.max(a,b);
    }
}