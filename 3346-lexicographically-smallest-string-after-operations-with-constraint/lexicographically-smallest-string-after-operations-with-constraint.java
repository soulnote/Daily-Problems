class Solution {
    public String getSmallestString(String s, int k) {
        String result = "";
        for (char c : s.toCharArray()) {
            for (char d = 'a'; d <= 'z'; d++) {
                if (Math.min(Math.abs(c - d), 26 - Math.abs(c - d)) <= k) {
                    k -= Math.min(Math.abs(c - d), 26 - Math.abs(c - d));
                    result += d;
                    break;
                } 
            }
        }
        return result;
    }
}