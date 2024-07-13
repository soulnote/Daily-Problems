class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n  = nums.length;
        int[]prefixProduct = new int[n];
        int[]postfixProduct = new int[n];

        prefixProduct[0] = nums[0];
        for(int i=1;i<n;i++){
            prefixProduct[i] = prefixProduct[i-1]*nums[i];
        }
        postfixProduct[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            postfixProduct[i] = postfixProduct[i+1]*nums[i];
        }
        int[]ans = new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                ans[i] = postfixProduct[i+1];
            }
            else if(i==n-1){
                ans[i] = prefixProduct[i-1];
            }
            else{
                ans[i] = prefixProduct[i-1]*postfixProduct[i+1];
            }
        }
        return ans;
    }
}