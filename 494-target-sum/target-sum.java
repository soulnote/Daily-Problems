class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return totalWays(0, nums, target, 0);
    }
    public int totalWays(int idx, int[]nums, int target, int amount){
        if(target==amount && idx == nums.length)return 1;
        if(idx>=nums.length)return 0;

        int plus = totalWays(idx+1, nums, target, amount+nums[idx]);
        int minus = totalWays(idx+1, nums, target, amount-nums[idx]);

        return plus+minus;
    }
}