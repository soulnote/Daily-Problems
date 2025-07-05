class Solution {
    public int findLucky(int[] arr) {
        int[] fqArr = new int[501];
        for(int i=0;i<arr.length;i++){
            fqArr[arr[i]]++;
        }
        int ans  =-1;
        for(int i=1;i<501;i++){
            if(fqArr[i]==i){
                ans = i;
            }
        }
        return ans;
    }
}