class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String common = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            int j = 0;
            while (j < common.length() && j < s.length() && common.charAt(j) == s.charAt(j)) {
                j++;
            }
            common = common.substring(0, j);
            if (common.isEmpty()) return ""; // optimization
        }

        return common;
    }
}
