class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int maxDiff = 0;
        for(int  i=0;i<nums.length;i++){
            int curr = nums[i];
            int next = i==nums.length-1?nums[0]:nums[i+1];
            int absDiff = (int)Math.abs(curr-next);
            if(absDiff>maxDiff)maxDiff= absDiff;
        }
        return maxDiff;

    }
}