class Solution {
    public int hammingWeight(int n) {
        int setBitCount = 0;
        int setbit = 1;
        while(n>0){
            if((n & setbit)==1)setBitCount++;
            n>>=1;
        }
        return setBitCount;
    }
}