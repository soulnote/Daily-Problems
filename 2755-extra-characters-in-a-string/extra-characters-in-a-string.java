
class Solution {
    public int minExtraChar(String s, String[] dictionary) {

        int n = s.length();

        Set<String> dict = new HashSet<>();

        for (String word : dictionary) {
            dict.add(word);
        }

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {

            dp[i] = dict.contains(s.substring(0, i + 1)) ? 0 : i + 1;

            for (int j = 0; j < i; j++) {

                String partition = s.substring(j + 1, i + 1);

                if (dict.contains(partition)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                } else {
                    dp[i] = Math.min(dp[i], dp[j] + i - j); // i - j = partition.length()
                }
            }
        }

        return dp[n - 1];
    }
}
