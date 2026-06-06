class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[]diff = new int[nums.length];
        int pre = 0;
        diff[0] = 0;
        for(int i=0;i<nums.length;i++){
            diff[i] = pre;
            pre+=nums[i];
            System.out.print(pre+",");
        }
        pre = 0;
        for(int i=nums.length-1;i>=0;i--){
            diff[i] =(int) Math.abs(pre - diff[i]);
            pre+=nums[i];
        }
        return diff;
    }
}