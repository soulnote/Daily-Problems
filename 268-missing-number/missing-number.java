class Solution {
    public int missingNumber(int[] nums) {
        int xorTillN = 0;
        for(int i=0;i<=nums.length;i++){
            xorTillN^=i;
        }
        for(int i=0;i<nums.length;i++){
            xorTillN^=nums[i];
        }
        return xorTillN;
    }
}