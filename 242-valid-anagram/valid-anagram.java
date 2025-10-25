class Solution {
    public boolean isAnagram(String s, String t) {
        int sn = s.length(), tn = t.length();
        if(sn!=tn)return false;
        int[]tArr = new int[26];
        for(int i=0;i<tn;i++){
            tArr[t.charAt(i)-'a']++;
        }
        for(int i=0;i<sn;i++){
            tArr[s.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(tArr[i]!=0)return false;
        }
        return true;
    }
}