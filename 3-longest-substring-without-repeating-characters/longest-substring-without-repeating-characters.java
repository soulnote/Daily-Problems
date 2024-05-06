class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128]; // Assuming ASCII characters
        
        for (int left = 0, right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            left = Math.max(charIndex[currentChar], left);
           
            maxLength = Math.max(maxLength, right - left + 1);
          
            charIndex[currentChar] = right + 1;
        }
        
        return maxLength;
    }
}
