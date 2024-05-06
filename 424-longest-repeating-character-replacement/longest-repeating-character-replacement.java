class Solution {
    public int characterReplacement(String s, int k) {
        int start =0;
        int max = 0;
        int maxFq =0;
        int []charArr = new int[26];
        for(int i=0;i<s.length();i++){
            int ch = s.charAt(i)-'A';
            charArr[ch]++;
            maxFq = Math.max(maxFq, charArr[ch]);

            int nonRepeatings = (i-start+1) - maxFq;
            if(nonRepeatings>k){
                // decrease the frequency of the character from the array which we are eleminating
                charArr[s.charAt(start)-'A']--;
                //shrink the window size from left
                start++;

            }
            max = Math.max(max, i-start+1);
        }
        return max;
    }
}