class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][]dp = new int[nums.length+1][nums.length];
        for(int[]num : dp){
            Arrays.fill(num, -1);
        }
        return helper(-1, 0, nums, dp);
    }
    public int helper(int pre, int idx, int[] nums, int[][] dp){
        if(idx == nums.length)return 0;
        if(dp[pre+1][idx]!=-1)return dp[pre+1][idx];
        int take = 0;
        if(pre ==-1 || nums[idx]>nums[pre]){
            take = 1 + helper(idx, idx+1, nums, dp);
        }
        int notTake = helper(pre , idx+1, nums, dp);
        int ans = Math.max(take, notTake);
        return dp[pre+1][idx] = ans;
        
    }
}