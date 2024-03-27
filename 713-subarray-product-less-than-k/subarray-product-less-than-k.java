class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0)return 0;
        int left =0,right=0;
        int count=0;
        int prod = 1;
        while(right<nums.length){
            prod *= nums[right];
            while(left<=right && prod>=k){
                prod/=nums[left];
                left++;
            }
            count+=right-left+1;
            right++;
        }
        return count;
    }
}