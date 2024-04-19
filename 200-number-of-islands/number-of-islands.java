class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length,n=grid[0].length;
        boolean [][]visited = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==false && grid[i][j]=='1'){
                    solve(i,j,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public void solve(int i, int j, char[][]grid, boolean[][]visited){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length)return;
        if(grid[i][j]=='0')return;
        if(visited[i][j]==true)return;
        int[]r = new int[]{0,0,1,-1};
        int[]c = new int[]{1,-1,0,0};
        visited[i][j]=true;
        for(int k=0;k<4;k++){
            int row = i+r[k];
            int col = j+c[k];
            solve(row,col,grid,visited);
        }
    }
}