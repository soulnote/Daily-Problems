class Solution {
    public int longestPalindrome(String s) {
        int charFq[] = new int[128];
        for(int i=0;i<s.length();i++){
            charFq[s.charAt(i)]++;
        }
        int count = 0;
        int oddCount= 0;
        for(int i=0;i<128;i++){
            int fq = charFq[i];
            if(fq==0)continue;
            if(fq%2==0){
                count+=fq;
            }
            else{
                count+= fq-1;
                oddCount++;
            }
        }
        if(oddCount>=1) return count+1;
        return count;
    }
}