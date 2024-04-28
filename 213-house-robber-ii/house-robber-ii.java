class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        if(n==1)return nums[0];
        int []h2 = new int[n-1]; 
        int[]h1 = new int[n-1];
        for(int i=0;i<n-1;i++){
            h1[i] = nums[i];
        }
        int idx=0;
        for(int i=1;i<n;i++){
            h2[idx++] = nums[i];
        }
        int []dp = new int[n];
        Arrays.fill(dp,-1);
        int m1 = helper(h1, n-2, dp);
        Arrays.fill(dp,-1);
        int m2 = helper(h2, n-2, dp);
        return Math.max(m1,m2);
    }
    public int helper(int[]h, int n, int[]dp){
        // if(n==0)return 
        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        int a =  h[n] + helper(h, n-2, dp);
        int b = helper(h, n-1, dp);
        return dp[n] = Math.max(a,b);
    }
}