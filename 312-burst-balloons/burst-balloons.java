class Solution {
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length+2];
        balloons[0] = balloons[balloons.length - 1] = 1;
        for(int i=0; i<nums.length; ++i)
            balloons[i+1] = nums[i];
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        return maxScore(balloons, dp, 1, nums.length);
    }
    
    public int maxScore(int[] balloons, int[][] dp, int i, int j){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int maxCoins = Integer.MIN_VALUE;
        for(int k=i; k<=j; ++k){
            int coins = balloons[i-1]*balloons[k]*balloons[j+1] + maxScore(balloons, dp, i, k-1) + maxScore(balloons, dp, k+1, j);
            maxCoins = Math.max(maxCoins, coins);
        }
        
        return dp[i][j] = maxCoins;
        
    }
}