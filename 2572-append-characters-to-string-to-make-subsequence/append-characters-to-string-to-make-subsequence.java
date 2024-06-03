class Solution {
    public int appendCharacters(String s, String t) {
        int minToAppend = t.length();
       
        int count = 0;
        int sPointer = 0, tPointer = 0;
        while(tPointer<t.length() && sPointer<s.length()){
            if(s.charAt(sPointer)==t.charAt(tPointer)){
                sPointer++;
                tPointer++;
                count++;
            }
            else sPointer++;
        }
        minToAppend = Math.min(t.length()-count, minToAppend);
         
        return minToAppend;
    }
}