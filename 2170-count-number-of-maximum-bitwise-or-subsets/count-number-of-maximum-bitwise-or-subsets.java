class Solution {
    int orMax = 0;
    public int countMaxOrSubsets(int[] nums) {
        
        for(int i=0;i<nums.length;i++){
            orMax= orMax | nums[i];
        }
        return solve(nums, 0, 0);
    }
    public int solve(int[]nums, int idx, int or){
        if(idx==nums.length){
            if(or == orMax)return 1;
            return 0;
        }
        int pick = solve(nums, idx+1, or|nums[idx]);
        int dontPick = solve(nums, idx+1, or);
        return pick+dontPick;

    }
}