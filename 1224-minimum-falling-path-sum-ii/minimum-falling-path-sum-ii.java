class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][]dp = new int[n+1][n+1];
        for(int[] num  : dp){
            Arrays.fill(num, -1);
        }
        return helper(0, n, grid, grid.length, dp);
    }

    public int helper(int row, int col, int[][]grid,int n, int[][] dp){
        //base case
        if(row==n)return 0;

        //special case
        if(dp[row][col]!=-1) return dp[row][col];

        //recursive case
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            if(j==col)continue;
            ans = Math.min(ans, grid[row][j]+helper(row+1, j, grid, n, dp));
        }
        return dp[row][col] = ans;
    }
}