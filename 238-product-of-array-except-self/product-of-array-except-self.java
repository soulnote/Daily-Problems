class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] postProduct = new int[n], preProduct =new int[n];
        preProduct[0]=nums[0];
        for(int i=1;i<n;i++){
            preProduct[i]= preProduct[i-1]*nums[i];
        }
        postProduct[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            postProduct[i]=postProduct[i+1]*nums[i];
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            if(i==0)ans[0]=postProduct[1];
            else if(i==n-1)ans[n-1]= preProduct[n-2];
            else ans[i] = preProduct[i-1]*postProduct[i+1];
        }
        return ans;
    }
}