class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            int xorValue = 0;
            for(int j=left;j<=right;j++){
                xorValue ^= arr[j];
            }
            ans[i] = xorValue;
        }
        return ans;
    }
}