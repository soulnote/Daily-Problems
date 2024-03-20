class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n==1)return n;
        if(nums[0]!=nums[1])return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];
        int left = 1, right = n-2;
        int ans =0;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]){
                ans = nums[mid];
                break;
            }
            if(mid%2==0){
                //left half
                if(nums[mid]==nums[mid+1]){
                    left = mid+1;
                }
                //right half
                if(nums[mid]==nums[mid-1]){
                    right = mid-1;
                }
            }
            if(mid%2!=0){
                //right half
                if(nums[mid]==nums[mid+1]){
                    right = mid-1;
                }
                //left half
                if(nums[mid]==nums[mid-1]){
                    left = mid+1;
                }
            }
        }
        return ans;
    }
}