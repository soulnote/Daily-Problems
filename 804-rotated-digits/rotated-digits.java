class Solution {

public int rotatedDigits(int n) {
    int[] rotates = { 0, 1, 5, -1, -1, 2, 9, -1, 8, 6 };
    int[] dp = new int[n + 1];
    dp[0] = dp[1] = 0;
    return helper(n, dp, rotates);
}

private int helper(int num, int[] dp, int[] rotates) {
    if (num < 2) {
        return dp[num];
    }
    return dp[num] = helper(num - 1, dp, rotates) + rotateNum(num, rotates);
}

private int rotateNum(int num, int[] rotates) {
    char[] chars = String.valueOf(num).toCharArray();
    int newNum = 0;
    for (int i = 0; i < chars.length; i++) {
        int n = chars[i] - 0 - '0';
        if (rotates[n] == -1) {
            return 0;
        }
        newNum = newNum * 10 + rotates[n];
    }
    return newNum == num ? 0 : 1;
}

}