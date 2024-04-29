class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int  begenning = 0;
        int length = 0;
        for(int current = 0 ; current <n; current++){
            // handling odd length case
            int left = current, right = current;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                if(right-left+1>length){
                    length = right-left+1;
                    begenning =left;
                    
                }
                left--;
                right++;
            }
            left = current;
            right = current+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                if(right-left+1>length){
                    length = right-left+1;
                    begenning = left;
                   
                }
                left--;
                right++;
            }
        }
        return s.substring(begenning, begenning+length);
    }
}