import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int idx = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                // Update idx to the index after the last occurrence of ch
                idx = Math.max(map.get(ch) + 1, idx);
            }
            map.put(ch, i);
            max = Math.max(i - idx + 1, max);
        }
        return max;
    }
}
