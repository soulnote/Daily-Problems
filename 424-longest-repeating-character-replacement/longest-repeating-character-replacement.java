class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int maxCount = 0;
        int start = 0;
        int[] charCounts = new int[26]; // Assuming only uppercase English letters
        
        for (int end = 0; end < s.length(); end++) {
            int charIndex = s.charAt(end) - 'A';
            charCounts[charIndex]++;
            maxCount = Math.max(maxCount, charCounts[charIndex]);
            
            int width = end-start+1;
            if (width - maxCount > k) {//if window have more number of non repeating characters than k 
                // Shrink the window from the left side
                charCounts[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}
