class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int p= 1;
        int s =1;
        for(int i=0;i<nums.length;i++){
            p*=nums[i];
            prefix[i] = p;
            s*=nums[nums.length-1-i];
            suffix[nums.length-i-1] = s;
        }
        for(int i=0;i<nums.length;i++){
            if(i==0){
                ans[i] = suffix[i+1];
            }else if(i==nums.length-1){
                ans[i] = prefix[i-1];
            }
            else{
                ans[i] = prefix[i-1]*suffix[i+1];
            }
        }
        return ans;
    }
}