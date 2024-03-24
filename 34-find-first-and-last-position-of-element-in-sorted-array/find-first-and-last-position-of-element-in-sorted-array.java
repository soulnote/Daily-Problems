class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0,high=nums.length-1;
        int[] ans = {-1, -1};
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>=target){
                high = mid-1;
            }
            else low = mid+1;
        }
        if(low<nums.length && nums[low]==target){
            ans[0] = low;
            while(low<nums.length && nums[low]==target){
                low++;
            }
            ans[1]=low-1;
        }
        return ans;

    }
}