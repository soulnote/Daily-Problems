class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int num:nums){
            max = Math.max(num,max);
        }
        int countMax=0;
        for(int i=0;i<nums.length;i++){
            int count = 0;
            while(i<nums.length && nums[i]==max){
                count++;
                i++;
            }
            countMax = Math.max(countMax,count);
        }
        return countMax;
    }
}