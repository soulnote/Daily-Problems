class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        long[] prefix = new long[n]; // 1D prefix
        int count = 0;

        for (int i = 0; i < m; i++) {
            long rowSum = 0; // current row cumulative sum

            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];

                // prefix[j] = top + current row sum
                prefix[j] += rowSum;

                if (prefix[j] <= k) {
                    count++;
                }
            }
        }
        return count;
    }
}