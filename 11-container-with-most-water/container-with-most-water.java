class Solution {
    public int maxArea(int[] height) {
        int left=0 ,right=height.length-1;
        int mArea= 0;
        while(left<right){
            int area = Math.min(height[left],height[right])*(right-left);
            mArea = Math.max(mArea,area);
            if(height[left]<=height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return mArea;
    }
}