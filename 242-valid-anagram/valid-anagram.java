class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        int [] charray = new int [26];
        for(int i=0;i<s.length();i++){
            charray[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            int ch = t.charAt(i)-'a';
            if(charray[ch]>0){
                charray[ch]--;
            }
            else return false;
        }
        return true;
    }
}