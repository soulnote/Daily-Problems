class Solution {
    public String getSmallestString(String s, int k) {
        int idx = 0;
        int n = s.length();
        StringBuilder res = new StringBuilder();
        
        while (idx < n && k > 0) {
            char ch = s.charAt(idx);
            
            if (k - (26 - (ch - 'a')) >= 0 && ch-'a' > 26 - (ch - 'a')) {
                res.append('a');
                k-=(26-(ch-'a'));
            } else if (k >= (ch - 'a')) {
                res.append('a');
                k -= (ch - 'a');
            } else {
                res.append((char) (ch - k));
                k -= (ch - k);
            }
            
            idx++;
        }
        
        while (idx < n) {
            res.append(s.charAt(idx));
            idx++;
        }
        
        return res.toString();
    }
}