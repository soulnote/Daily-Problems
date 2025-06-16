class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0],diff = 0;
        for(int i=1;i<nums.length;i++){
            int currDiff = nums[i]-min;
            if(currDiff<0){
                min = nums[i];
            }
            else diff = Math.max(diff, currDiff);
        }
        return diff==0?-1:diff;
    }
}