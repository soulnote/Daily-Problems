class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            int ch = s.charAt(i)-'a';
            arr[ch]++;
        }
        for(int i=0;i<t.length();i++){
            int ch = t.charAt(i)-'a';
            arr[ch]--;
            if(arr[ch]<0)return false;
        }
        return true;
    }
}