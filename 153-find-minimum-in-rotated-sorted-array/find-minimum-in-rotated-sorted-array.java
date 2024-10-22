class Solution {
    public int findMin(int[] nums) {
        // [0,1,2,4,5,6,7] -> [4,5,6,7,0,1,2] if it was rotated 4 times.
        // [7,0,1,2,4,5,6] if it was rotated 1 times.

        int left = 0, right = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]>=nums[left]){
                min = Math.min(nums[left],min);
                left = mid+1;
            }
            else{
                min = Math.min(nums[mid],min);
                right = mid -1;
            }

        }
        return min;
        
    }
}