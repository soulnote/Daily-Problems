class Solution {
    public int searchInsert(int[] nums, int target) {
        int idx =0;
        int left = 0,right=nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target){
                idx = mid+1;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return idx;
    }
}