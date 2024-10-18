class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];
        if(n==1 || n==2) return 0;
        int max = height[0];
        leftmax[0] = 0;
        for(int i=1;i<n;i++){
            max = Math.max(max, height[i]);
            leftmax[i] = max;
        }

        max = height[n-1];
        rightmax[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            max = Math.max(max, height[i]);
            rightmax[i] = max;
        }

        int totalWater = 0;
        for(int i=0;i<n;i++){
            int water = Math.min(leftmax[i],rightmax[i]) - height[i];
            // System.out.println(water);
            if(water>0) totalWater += water;
        }
        return totalWater;
    }
}