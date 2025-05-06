class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int longest = 0;
        while(right<s.length() && left<=right){
            char ch = s.charAt(right);
            if(!map.containsKey(ch)){
                map.put(ch, right);
                right++;
            }
            else{
                left = Math.max(left, map.get(ch)+1);
                map.remove(ch);
            }
            int count = right-left;
            longest = Math.max(longest, count);
        }
        return longest;
    }
}