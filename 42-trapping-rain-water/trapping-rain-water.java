class Solution {
    public int trap(int[] height) {
        int totalWater = 0, n = height.length;
        int[]left = new int[n];
        int[]right = new int[n];
        int leftMax = 0, rightMax = 0;
        for(int i=0;i<n;i++){
            left[i] = Math.max(leftMax, height[i]);
            leftMax = Math.max(leftMax, left[i]);
        }
        for(int i=n-1;i>=0;i--){
            right[i] = Math.max(rightMax, height[i]);
            rightMax = Math.max(rightMax, right[i]);
        }
        for(int i=0;i<n;i++){
            int water = Math.min(left[i], right[i]) - height[i];
            totalWater += water;
        }
        return totalWater;
    }
}