class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n+2][300];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        return 1+helper('*', 0, s, k, dp);
    }

    int helper(char prevChar, int currIdx, String s, int k, int[][] dp){
        //base case
        if(currIdx==s.length()) return 0;
        
        if(dp[currIdx][prevChar]!=-1) return dp[currIdx][prevChar];

        //special case
        if(prevChar=='*') return dp[currIdx][prevChar] =  Math.max(helper(prevChar, currIdx+1, s, k, dp), helper(s.charAt(currIdx), currIdx+1, s, k, dp));


        //recursive
        int ans = 0;
        // consider curr index
        if(Math.abs(prevChar-s.charAt(currIdx))<=k ) ans = 1+ helper(s.charAt(currIdx), currIdx+1, s, k, dp);
        // not consider current idx 
        ans = Math.max(ans, helper(prevChar, currIdx+1, s, k, dp));

        return dp[currIdx][prevChar] = ans;
    }
}