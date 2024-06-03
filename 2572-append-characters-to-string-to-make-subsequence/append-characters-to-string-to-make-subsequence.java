class Solution {
    public int appendCharacters(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
       
        int count = 0;
        int sPointer = 0, tPointer = 0;
        while(tPointer<tLen && sPointer<sLen){
            if(s.charAt(sPointer)==t.charAt(tPointer)){
                sPointer++;
                tPointer++;
                count++;
            }
            else sPointer++;
        }
         
        return tLen - count;
    }
}