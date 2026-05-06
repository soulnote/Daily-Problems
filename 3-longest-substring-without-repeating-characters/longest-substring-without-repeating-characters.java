class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int max = 0;
        while(right<s.length()){
            char ch = s.charAt(right);
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            int curr = right-left+1;
            max = Math.max(curr, max);
            set.add(ch);
            right++;
        }
        return max;
    }
}