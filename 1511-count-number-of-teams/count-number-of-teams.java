class Solution {
    private int increasing(int n, int prevIdx, int currIdx, int cnt, int[] rating, int[][][] memo) {
        if(cnt == 3) return 1;
        if(currIdx == n) return 0;

        if(memo[prevIdx+1][currIdx][cnt] != -1) return memo[prevIdx+1][currIdx][cnt];

        int take = 0;
        if(prevIdx == -1 || rating[currIdx] > rating[prevIdx]) {
            take = increasing(n, currIdx, currIdx+1, cnt+1, rating, memo);
        }
        int notTake = increasing(n, prevIdx, currIdx+1, cnt, rating, memo);
        return memo[prevIdx+1][currIdx][cnt] = take + notTake;
    }

    private int decreasing(int n, int prevIdx, int currIdx, int cnt, int[] rating, int[][][] memo) {
        if(cnt == 3) return 1;
        if(currIdx == n) return 0;

        if(memo[prevIdx+1][currIdx][cnt] != -1) return memo[prevIdx+1][currIdx][cnt];

        int take = 0;
        if(prevIdx == -1 || rating[currIdx] < rating[prevIdx]) {
            take = decreasing(n, currIdx, currIdx+1, cnt+1, rating, memo);
        }
        int notTake = decreasing(n, prevIdx, currIdx+1, cnt, rating, memo);
        return memo[prevIdx+1][currIdx][cnt] = take + notTake;
    }

    public int numTeams(int[] rating) {
        // dp: inc subseq + dec subseq
        int n = rating.length;
        int[][][] memo = new int[n+1][n+1][4];
        for(int[][] plane: memo) {
            for(int[] row: plane) {
                Arrays.fill(row, -1);
            }
        }
        int res = increasing(n, -1, 0, 0, rating, memo);
        for(int[][] plane: memo) {
            for(int[] row: plane) {
                Arrays.fill(row, -1);
            }
        }
        res += decreasing(n, -1, 0, 0, rating, memo);
        return res;
    }
}