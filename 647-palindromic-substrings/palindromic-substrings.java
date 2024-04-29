class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int length = 0;
        for(int current = 0 ; current <n; current++){
            // handling odd length case
            int left = current, right = current;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                length++;
                left--;
                right++;
            }
            left = current;
            right = current+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                length++;
                left--;
                right++;
            }
        }
        return length;
    }
}