class Solution {
    private Boolean[][] memo; // Memoization table
    private String longestPalindrome;

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        memo = new Boolean[n][n]; // Initialize memoization table
        longestPalindrome = "";
        
        // Check all substrings and find the longest palindromic one
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j) && (j - i + 1) > longestPalindrome.length()) {
                    longestPalindrome = s.substring(i, j + 1);
                }
            }
        }
        return longestPalindrome;
    }

    // Memoized function to check if s[i:j] is a palindrome
    private boolean isPalindrome(String s, int left, int right) {
        // Base cases
        if (left >= right) return true; // Single character or empty string is a palindrome
        if (memo[left][right] != null) return memo[left][right]; // Return cached result

        // Check if current characters are equal and the substring between them is a palindrome
        if (s.charAt(left) == s.charAt(right)) {
            memo[left][right] = isPalindrome(s, left + 1, right - 1);
        } else {
            memo[left][right] = false;
        }

        return memo[left][right];
    }
}
