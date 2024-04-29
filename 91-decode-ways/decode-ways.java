class Solution {
    public int numDecodings(String s) {
        int []dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(0, s, dp);
    }
    public int helper(int idx , String s, int[]dp){
        if(idx >= s.length())return 1;

        if(dp[idx]!=-1)return dp[idx];
        
        if(s.charAt(idx)=='0')return 0;
        int ans1 = helper(idx+1, s, dp);
        int ans2 = 0;

        if(idx<s.length()-1 && Integer.parseInt(s.substring(idx, idx+2))<=26){
            ans2 = helper(idx+2, s, dp);
        }
    
        return dp[idx] = ans1+ans2;
        
    }
}