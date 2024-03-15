class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[]ans = new int[n];

        //prefix product allocations
        int p =1;
        ans[0]=1;
        for(int i=1;i<n;i++){
            p*=nums[i-1];
            ans[i]= p;
        }

        // suffix product allocations
        int s = 1;
        for(int i=n-2;i>=0;i--){
            s*=nums[i+1];
            ans[i]= ans[i]*s;
        }
        return ans;
    }
}