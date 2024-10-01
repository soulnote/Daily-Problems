class Solution {
    public int minCut(String s) {
        int ans = s.length();
        int[]dp = new int[s.length()];
        Arrays.fill(dp, -1);
        ans = solve(0, s, dp);
        return ans-1;
    }
    public int solve(int idx, String s, int[]dp){
        if(idx==s.length()){
            return 0;//no more cuts needed
        }
        if(dp[idx]!=-1)return dp[idx];
        int minCuts = Integer.MAX_VALUE;
        for(int i=idx;i<s.length();i++){
            String sub = s.substring(idx, i+1);
            if(isPalindrome(sub)){
                int cuts = 1 + solve(i+1, s, dp);
                minCuts = Math.min(cuts, minCuts);
            }
        }
        return dp[idx] = minCuts;
    }
    public boolean isPalindrome(String s){
        int left =0, right = s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right))return false;
            left++;
            right--;
        }
        return true;
    }
}