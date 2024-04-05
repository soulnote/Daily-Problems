class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] maxleft = new int[n];
        int[] maxright = new int[n];
        maxleft[0] = 0;
        int max=0;
        for(int i=1;i<n;i++){
            max = Math.max(max,height[i-1]);
            maxleft[i] = max;
        }
        maxright[n-1]=0;
        max=0;
        for(int i=n-2;i>=0;i--){
            max = Math.max(max,height[i+1]);
            maxright[i] = max;
        }
        int totalWater =0;
        for(int i=0;i<n;i++){
            int minHeight = Math.min(maxleft[i],maxright[i]);
            if(minHeight>height[i]){
                totalWater+=minHeight-height[i];
            }
        }
        return totalWater;
    }
}