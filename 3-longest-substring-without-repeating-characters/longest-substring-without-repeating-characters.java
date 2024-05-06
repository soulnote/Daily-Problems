class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest =0;
        HashMap<Character,Integer> map = new HashMap<>();
        int left =0, right=0;
        while(right<s.length()){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                left = Math.max(left, map.get(ch)+1);
            }
            map.put(ch,right);
            longest= Math.max(right-left+1,longest);
            right++;
        }
        return longest;
    }
}