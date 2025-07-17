class Solution {
    public int maximumLength(int[] nums, int k) {
        Integer[][] dp = new Integer[nums.length][k];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                res = Math.max(res, 1 + go(dp, nums, j, k, (nums[i] + nums[j]) % k));
            }
        }
        return res;
    }
    
    static int go(Integer[][] dp, int[] nums, int i, int k, int rem) {
        if (dp[i][rem] != null) {
            return dp[i][rem];
        }
        
        int res = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if ((nums[j] + nums[i]) % k == rem) {
                res += go(dp, nums, j, k, rem);
                break;
            }
        }
        return dp[i][rem] = res;
    }
}