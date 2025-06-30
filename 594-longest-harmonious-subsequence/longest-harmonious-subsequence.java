class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int min = nums[0], max = nums[0];
        int left = 0, right = 0;
        while(right<nums.length){
            if(nums[right]-nums[left]==0){
                right++;
                continue;
            }
            else if(nums[right]-nums[left]==1){
                ans = Math.max(ans, right-left+1);
            }
            else{
                while(nums[right]-nums[left]>1){
                    left++;
                }
            }
            right++;
        }
        return ans;
    }
}