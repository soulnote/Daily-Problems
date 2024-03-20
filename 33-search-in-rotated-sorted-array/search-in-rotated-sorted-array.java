class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(nums[0]==target) return 0;
        if(nums[n-1]==target) return n-1;
        int left = 1;
        int right = n-2;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid]==target) return mid;
            if( nums[left]<=nums[mid] ){
                if(nums[mid]>target && nums[left]<=target){
                    right= mid-1;
                }
                else{
                    left = mid+1;
                }
                
            }
            if( nums[right]>=nums[mid]){
                if(nums[mid]<target && nums[right]>=target){
                    left= mid+1;
                }
                else{
                    right = mid-1;
                }
                
            }
            
        }
        return -1;
    }
}