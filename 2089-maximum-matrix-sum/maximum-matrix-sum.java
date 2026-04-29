class Solution {
    public long maxMatrixSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        long negCount = 0;
        long minAbs = Integer.MAX_VALUE;
        long absSum = 0;

        for (int[] row : matrix) {
            for (int val : row) {
                if (val < 0)
                    negCount++;
                long absVal = Math.abs(val);
                absSum += absVal;
                if (absVal < minAbs)
                    minAbs = absVal;
            }
        }
        return (negCount % 2 == 0) ? absSum : absSum - 2 * minAbs;

    }
}