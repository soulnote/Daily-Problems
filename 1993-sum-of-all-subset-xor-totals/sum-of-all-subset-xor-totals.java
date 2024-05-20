class Solution {
    public int subsetXORSum(int[] nums) {
        
        return helper(0, nums,0);
    }
    public int helper(int idx , int[]nums, int xorSum){
        if(idx ==nums.length)return xorSum;

        int pick = helper(idx+1, nums, xorSum^nums[idx]);
        int dontPick = helper(idx+1, nums, xorSum);
        return pick + dontPick;
    }
}