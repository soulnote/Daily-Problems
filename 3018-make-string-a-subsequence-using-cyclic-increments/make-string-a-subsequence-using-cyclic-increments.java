class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int srcLen = str1.length(), tgtLen = str2.length();
        char targetChar = str2.charAt(0);
        
        int srcIdx = 0, tgtIdx = 0;
        while (srcIdx < srcLen && tgtIdx < tgtLen) {
            char srcChar = str1.charAt(srcIdx);
            
            if (srcChar == targetChar || (char)(srcChar + 1) == targetChar || (srcChar == 'z' && targetChar == 'a')) {
                tgtIdx++;
                if (tgtIdx < tgtLen) {
                    targetChar = str2.charAt(tgtIdx);
                }
            }
            
            srcIdx++;
        }
        
        return tgtIdx == tgtLen;
    }
}