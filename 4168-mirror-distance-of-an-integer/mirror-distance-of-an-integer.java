class Solution {
    public int mirrorDistance(int n) {
        int newn = n;
        int reverseN = 0;
        while(newn>0){
            reverseN = reverseN*10 + (newn%10);
            newn = newn/10;
        }
        int ans = Math.abs(n - reverseN);
        return ans;
    }
}