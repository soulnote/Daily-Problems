class Solution {
    public int findDuplicate(int[] nums) {
        int i =0;
        while(i<nums.length){
            if((i+1)==nums[i]){
                i++;
            }
            else{
                if(nums[nums[i]-1]==nums[i])return nums[i];
                else {
                    int temp=nums[i];
                    nums[i] = nums[temp-1];
                    nums[temp-1]= temp;
                }
            }
        }
        return -1;
    }
}