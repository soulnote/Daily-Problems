class Solution {

    private static final int MOD = 1000000000 + 7;

    public int checkRecord(int n) {
        int[][][] temp = new int[n + 1][2][3];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    temp[i][j][k] = -1;
                }
            }
        }
        return numPossibleRecords(n, 1, 2, temp);
    }

    private int numPossibleRecords(int n, int numAbsencesRemaining, int numLatesRemaining, int[][][] temp) {
        if (n == 0) {
            return 1;
        }

        if (temp[n][numAbsencesRemaining][numLatesRemaining] != -1) {
            return temp[n][numAbsencesRemaining][numLatesRemaining];
        }

        int total = 0;

        // Pick P
        total += numPossibleRecords(n - 1, numAbsencesRemaining, 2, temp);
        total %= MOD;

        if (numAbsencesRemaining > 0) {
            // Pick A
            total += numPossibleRecords(n - 1, numAbsencesRemaining - 1, 2, temp);
            total %= MOD;
        }

        if (numLatesRemaining > 0) {
            // Pick L
            total += numPossibleRecords(n - 1, numAbsencesRemaining, numLatesRemaining - 1, temp);
            total %= MOD;
        }

        temp[n][numAbsencesRemaining][numLatesRemaining] = total;
        return total;
    }
}
