class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i] = hammingWeight(i);
        }
        return ans;
    }
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