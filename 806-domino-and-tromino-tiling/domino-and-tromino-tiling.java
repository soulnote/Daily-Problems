class Solution {
    Integer[][] dp;
    int MOD = 1000000007;
    private int stateOne(int n) {
        if(n < 0) return 0;
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;
        
        if(dp[0][n] != null) return dp[0][n];

        int a = stateOne(n-1);
        int b = stateOne(n-2);
        int c = stateTwo(n-1);
        int d = stateThree(n-1);

        return dp[0][n] = (((((a % MOD) + (b % MOD)) % MOD) + ((c % MOD) + (d % MOD)) % MOD) % MOD);
    }
    private int stateTwo(int n) {
        if(n <= 1) return 0; 
        if(n == 2) return 1;

        if(dp[1][n] != null) return dp[1][n];

        int a = stateThree(n-1);
        int b = stateOne(n-2);

        return dp[1][n] = (((a % MOD) + (b % MOD)) % MOD);

    }
    private int stateThree(int n) {
        if(n <= 1) return 0;
        if(n == 2) return 1;

        if(dp[2][n] != null) return dp[2][n];

        int a = stateTwo(n-1);
        int b = stateOne(n-2);

        return dp[2][n] = (((a % MOD) + (b % MOD)) % MOD);
    }
    public int numTilings(int n) {
        this.dp = new Integer[3][n+1];
        return stateOne(n);
    }
}