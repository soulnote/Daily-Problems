class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] q : queries) {
            diff[q[0]]++;
            diff[q[1] + 1]--;
        }

        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += diff[i];
            if (nums[i] > prefixSum) {
                return false;
            } 
        }

        return true;
    }
}