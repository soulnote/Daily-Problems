class Solution {
    public int heightChecker(int[] heights) {
        int[]newStanding = heights.clone();
        Arrays.sort(newStanding);
        int count=0;
        for(int i=0;i<heights.length;i++){
            if(newStanding[i]!=heights[i]){
                
                count++;
            }
        }
        return count;
    }
}