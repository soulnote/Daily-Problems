class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        if(sum%2!=0)return false;
        sum = sum/2;
        Boolean[][] dp = new Boolean[nums.length+1][sum+1];
        for(Boolean[] num : dp){
            Arrays.fill(num, null);
        } 
        return helper(0, sum, nums, dp);
    }
    public boolean helper(int idx, int sum, int[] nums, Boolean[][]dp){
        if(idx == nums.length && sum!=0)return false;
        if(sum<0)return false;
        if(sum== 0)return true;

        if(dp[idx][sum]!=null)return dp[idx][sum];
        boolean take = helper(idx+1, sum-nums[idx], nums, dp);
        boolean nottake = helper(idx+1, sum, nums, dp);
        return dp[idx][sum] = take|nottake;
    }
}