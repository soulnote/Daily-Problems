class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[]fqArr = new int[26];
        int maxfq = 0;
        int ans = 0;
        int left =0,right=0;
        while(right<n){
            int ch = s.charAt(right)-'A';
            fqArr[ch]++;
            maxfq = Math.max(maxfq, fqArr[ch]);
            while(left<=right && right-left+1-maxfq>k){
                fqArr[s.charAt(left)-'A']--;
                left++;
                maxfq = 0;
                for(int i=0;i<26;i++){
                    maxfq = Math.max(maxfq, fqArr[i]);
                }
            }
            ans = Math.max(ans, right-left+1);
            right++;
        } 
        return ans;
    }
}