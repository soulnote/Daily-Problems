class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Since the 2D matrix is viewed as a 1D sorted array,
            // mid / n gives the row index
            int r = mid / n;

            // mid % n gives the column index
            int c = mid % n;

            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] < target) left = mid + 1; //  advance left to mid+1
            else right = mid - 1; //  move right to mid-1
        }

        return false;
    }
}
