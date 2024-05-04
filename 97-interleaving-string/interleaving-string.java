class Solution {
    boolean helper(String s1, String s2, String s3, int ind1, int ind2, int ind3, Boolean[][][] dp){
        //base case
        if(ind1==-1 && ind2==-1 && ind3==-1) return true;
        if(ind1>=0 && ind2>=0 && dp[ind1][ind2][ind3]!=null)return dp[ind1][ind2][ind3];
        //recursive case
        boolean ans = false;
        if(ind1>=0 && s1.charAt(ind1)==s3.charAt(ind3)) ans |= helper(s1, s2, s3, ind1-1, ind2, ind3-1, dp);
        if(ind2>=0 && s2.charAt(ind2)==s3.charAt(ind3)) ans |= helper(s1, s2, s3, ind1, ind2-1, ind3-1, dp);
        if(ind1>=0 && ind2>=0){
            dp[ind1][ind2][ind3] = ans;
        } 
        return ans;
    }


    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        Boolean[][][] dp = new Boolean[s1.length() + 1][s2.length() + 1][s3.length()+1];
        for(Boolean [][]nums : dp){
            for(Boolean[]num : nums){
                Arrays.fill(num, null);
            }
        }
        return helper(s1, s2, s3, s1.length()-1, s2.length()-1, s3.length()-1, dp);
    }
}