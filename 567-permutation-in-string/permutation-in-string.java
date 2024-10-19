class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        // Character frequency arrays for both s1 and the current window of s2
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];
        
        // Fill the frequency array for s1
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }
        
        // Sliding window approach, start comparing after the first window
        for (int i = s1.length(); i < s2.length(); i++) {
            // If the current window matches the frequency of s1, return true
            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }
            
            // Slide the window:
            // 1. Add the new character in the window
            windowFreq[s2.charAt(i) - 'a']++;
            // 2. Remove the old character from the start of the window
            windowFreq[s2.charAt(i - s1.length()) - 'a']--;
        }
        
        // Check the last window
        return Arrays.equals(s1Freq, windowFreq);
    }
}