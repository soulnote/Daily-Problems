class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for (int[] num : memo) {
            Arrays.fill(num, -1);
        }
        int ops = solve(word1, word2, 0, 0, memo);
        return ops;
    }

    public int solve(String word1, String word2, int i, int j, int[][] memo) {
        if (i >= word1.length())
            return word2.length() - j;
        if (j >= word2.length())
            return word1.length() - i;
        if (memo[i][j] != -1)
            return memo[i][j];
        int ans = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = solve(word1, word2, i + 1, j + 1, memo);
        } else {
            int insert = solve(word1, word2, i, j + 1, memo);
            int replace = solve(word1, word2, i + 1, j, memo);
            int delete = solve(word1, word2, i + 1, j + 1, memo);
            ans = 1 + Math.min(insert, Math.min(replace, delete));
        }

        memo[i][j] = ans;
        return ans;
    }
}