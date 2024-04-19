class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return ""; // If s is shorter than t, there can't be a valid window
        
        // Initialize a hashmap to store the frequency of characters in t
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0;
        int minWindowLength = Integer.MAX_VALUE;
        int minWindowStart = 0;
        int requiredChars = targetMap.size(); // Number of unique characters in t
        int formedChars = 0; // Number of characters in s that match those in t
        Map<Character, Integer> windowMap = new HashMap<>(); // Map to store the frequency of characters in the current window
        
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);
            // If the current character matches one in t and its frequency in the window equals its frequency in t, increment formedChars
            if (targetMap.containsKey(currentChar) && windowMap.get(currentChar).intValue() == targetMap.get(currentChar).intValue()) {
                formedChars++;
            }
            
            // If all characters in t are found in the current window, try shrinking the window from the left
            while (left <= right && formedChars == requiredChars) {
                // Update the minimum window length and start index if the current window is smaller
                if (right - left + 1 < minWindowLength) {
                    minWindowLength = right - left + 1;
                    minWindowStart = left;
                }
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                // If the frequency of leftChar becomes less than required, decrement formedChars
                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
                    formedChars--;
                }
                left++; // Shrink the window from the left
            }
            
            right++; // Expand the window to the right
        }
        
        return minWindowLength == Integer.MAX_VALUE ? "" : s.substring(minWindowStart, minWindowStart + minWindowLength);
    }
}