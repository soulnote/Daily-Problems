import java.util.Arrays;

class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(0, nums, dp);
    }

    private int helper(int idx, int[] nums, int[] dp) {
        if (idx >= nums.length - 1) return 0; // If we've reached or passed the last index, no more jumps needed
        if (dp[idx] != -1) return dp[idx]; // Return the memoized result

        int min = Integer.MAX_VALUE-1;
        for (int i = idx+1; i <= idx+nums[idx]; i++) {
            min = Math.min(min, 1 + helper(i, nums, dp));
        }

        dp[idx] = min;
        return dp[idx];
    }
}
