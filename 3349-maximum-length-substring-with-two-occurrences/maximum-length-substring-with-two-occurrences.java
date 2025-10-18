class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int begin = 0;
        int end = 0;
        
        int[] freq = new int[26];
        
        while (end < n) {
            char current = s.charAt(end);
            int index = current - 'a';
            
            freq[index]++;
            
            while (freq[index] == 3) {
                char charToRemove = s.charAt(begin);
                freq[charToRemove - 'a']--;
                
                begin++;
            }
            
            maxLength = Math.max(maxLength, end - begin + 1);
            
            end++;
        }
        
        return maxLength;
    }
}