class Solution {
    public int maxSum(int[] nums) {
        int max = -101;
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0 && !set.contains(nums[i])){
                sum+=nums[i];
                set.add(nums[i]);
            }
            if(nums[i]>max)max = nums[i];
        }
        if(max<=0)return max;
        return sum;
    }
}