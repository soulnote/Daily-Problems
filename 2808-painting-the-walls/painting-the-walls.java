class Solution {
    private long[][] memo;
    private int n;
    
    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        memo = new long[n + 1][n + 1];
        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }
        return (int) dp(0, n, cost, time);
    }
    
    private long dp(int i, int w, int[] cost, int[] time) {
        if (w <= 0) return 0;
        if (i == n) return w == 0 ? 0 : Long.MAX_VALUE / 2;
        
        if (memo[i][w] != -1) return memo[i][w];
        
        long skip = dp(i + 1, w, cost, time);
        long use = Long.MAX_VALUE / 2;
        // No need for explicit w >= wallsPainted check, handled by base case
        int wallsPainted = 1 + time[i];
        use = cost[i] + dp(i + 1, w - wallsPainted, cost, time);
        
        return memo[i][w] = Math.min(skip, use);
    }
}