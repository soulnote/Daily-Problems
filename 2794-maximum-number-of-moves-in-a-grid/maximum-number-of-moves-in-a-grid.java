class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, solve(i, 0, grid, memo));
        }

        return ans;
    }

    public int solve(int row, int col, int[][] grid, int[][] memo) {
        if (row < 0 || row >= grid.length || col >= grid[0].length) return 0;
        if (memo[row][col] != -1) return memo[row][col];

        int currValue = grid[row][col];
        int maxMoves = 0;

        if (row > 0 && col + 1 < grid[0].length && grid[row - 1][col + 1] > currValue) {
            maxMoves = Math.max(maxMoves, solve(row - 1, col + 1, grid, memo) + 1);
        }
        if (col + 1 < grid[0].length && grid[row][col + 1] > currValue) {
            maxMoves = Math.max(maxMoves, solve(row, col + 1, grid, memo) + 1);
        }
        if (row + 1 < grid.length && col + 1 < grid[0].length && grid[row + 1][col + 1] > currValue) {
            maxMoves = Math.max(maxMoves, solve(row + 1, col + 1, grid, memo) + 1);
        }

        memo[row][col] = maxMoves;
        return maxMoves;
    }
}
