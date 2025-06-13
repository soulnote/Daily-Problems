class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        // dp[j] represents min cost to paint j walls
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2); // Initialize to large value
        dp[0] = 0; // Base case: no walls painted, cost = 0

        // Iterate over each wall
        for (int i = 0; i < n; i++) {
            int[] next = new int[n + 1];
            Arrays.fill(next, Integer.MAX_VALUE / 2);
            next[0] = dp[0]; // Not using wall i for paid painter

            // For each number of walls painted so far
            for (int j = 0; j <= n; j++) {
                if (dp[j] == Integer.MAX_VALUE / 2) continue; // Skip invalid states

                // Option 1: Don't use paid painter for wall i
                next[j] = Math.min(next[j], dp[j]);

                // Option 2: Use paid painter for wall i
                // Paid painter paints 1 wall, free painter can paint up to time[i] walls
                int wallsPainted = 1 + time[i]; // Total walls painted by both
                for (int k = 1; k <= wallsPainted && j + k <= n; k++) {
                    next[j + k] = Math.min(next[j + k], dp[j] + cost[i]);
                }
            }
            dp = next; // Update dp for next iteration
        }

        return dp[n]; // Min cost to paint all n walls
    }
}