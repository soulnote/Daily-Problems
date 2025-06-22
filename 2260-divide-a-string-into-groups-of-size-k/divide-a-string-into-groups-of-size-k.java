class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int totalPartitions = (n + k - 1) / k;
        String[] ans = new String[totalPartitions];
        
        for (int i = 0; i < totalPartitions; i++) {
            int start = i * k;
            int end = Math.min(start + k, n); 
            StringBuilder group = new StringBuilder(s.substring(start, end));
            
            while (group.length() < k) {
                group.append(fill);
            }
            
            ans[i] = group.toString();
        }
        
        return ans;
    }
}