class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int mArea = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int area = dfs(i,j,grid);
                    mArea = Math.max(mArea,area);
                }
            }
        }
        return mArea;
    }
    
    int[] dRow = new int[] {0,0,1,-1};
    int[] dCol = new int[] {1,-1,0,0};

    public int dfs(int r, int c, int[][]grid){
        // base case 
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]==0) return 0;
        grid[r][c] = 0;
        // recursive case
        int ans = 1;
        for(int i = 0 ; i < 4; i++){
            int newRow = r+dRow[i];
            int newCol = c+dCol[i];
            ans+=dfs(newRow, newCol, grid);
        }
        return ans;
     }
}