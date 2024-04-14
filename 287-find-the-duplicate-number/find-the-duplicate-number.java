class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if((i+1)==nums[i])continue;
            else{
                if(nums[nums[i]-1]==nums[i])return nums[i];
                else {
                    int temp=nums[i];
                    nums[i] = nums[temp-1];
                    nums[temp-1]= temp;
                    i--;
                }
            }
        }
        return -1;
    }
}