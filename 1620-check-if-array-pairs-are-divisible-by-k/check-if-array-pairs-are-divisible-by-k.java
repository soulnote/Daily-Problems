class Solution {
    public boolean canArrange(int[] arr, int k) {
        if(arr.length<=1)return false;
        int[]frqArr = new int[k];
        for(int i=0;i<arr.length;i++){
            int frqElement = ((arr[i] % k)+k)%k;
            frqArr[frqElement]++;
        }
        if(frqArr[0]%2 != 0)return false;
        for(int i=1;i<=k/2;i++){
            int fq1 = frqArr[i];
            int fq2 = frqArr[k-i];
            if(fq1!=fq2)return false;
        }
        return true;

    }
}