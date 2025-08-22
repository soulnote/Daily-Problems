class Solution {
    public int minimumArea(int[][] grid) {
        int r1=0,c1=0,r2=0,c2=0;
        int m = grid.length, n = grid[0].length;
        for(int i=0;i< m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    r1= r1==0?i+1:Math.min(i+1, r1);
                    c1= c1==0?j+1:Math.min(j+1, c1);
                    r2 = Math.max(i+1, r2);
                    c2 = Math.max(j+1, c2);
                }
            }
        }
        int length = r2-r1+1, width = c2-c1+1;
        return length*width;
    }
}