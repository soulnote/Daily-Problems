class Solution {
    public int uniquePaths(int m, int n) {
        int[][]dp = new int[m][n];
        for(int[]num : dp){
            Arrays.fill(num,-1);
        }
        return solve(m-1,n-1,dp);
        
    }
    public int solve(int i, int j, int[][]dp){
        //base case
        if(i==0 && j==0)return 1;
        if(i<0 || j<0)return 0;
        // memoization
        if(dp[i][j]!=-1)return dp[i][j];
        //recursive case
        return dp[i][j]= solve(i-1,j,dp)+solve(i,j-1,dp);
    }
}