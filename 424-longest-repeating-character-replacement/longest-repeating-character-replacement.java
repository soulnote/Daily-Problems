class Solution {
    public int characterReplacement(String s, int k) {
        int [] fqArr = new int[26];
        int left=0,right=0;
        int longest = 0,maxFq=0;
        while(right<s.length()){
            int ch = s.charAt(right)-'A';
            fqArr[ch]++;
            int len = right-left+1;
            maxFq = Math.max(maxFq,fqArr[ch]);
            while(left<right && right-left+1-maxFq>k){
                fqArr[s.charAt(left)-'A']--;
                left++;
                maxFq = 0;
                for(int i=0;i<26;i++){
                    maxFq = Math.max(maxFq,fqArr[i]);
                }
            }
            longest = Math.max(right-left+1,longest);
            right++;
        }
        return longest;
    }
}