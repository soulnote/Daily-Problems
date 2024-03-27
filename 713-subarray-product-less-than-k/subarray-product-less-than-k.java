class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0) return 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int sum=1;
            for(int j=i;j<nums.length;j++){
                sum*=nums[j];
                if(sum<k)count++;
                else break;
            }
        }
        return count;
    }
}