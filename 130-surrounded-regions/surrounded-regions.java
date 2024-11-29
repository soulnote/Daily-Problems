class Solution {
    public void solve(char[][] grid) {
        for(int j=0;j<grid[0].length;j++){
            if(grid[0][j]=='O')dfs(0,j,grid);
            if(grid[grid.length-1][j]=='O')dfs(grid.length-1,j,grid);
        }
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]=='O')dfs(i,0,grid);
            if(grid[i][grid[0].length-1]=='O')dfs(i,grid[0].length-1,grid);
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='O') grid[i][j] = 'X';
                if(grid[i][j]=='V') grid[i][j] = 'O';
            }
        }
    }

    
    int[] dRow = new int[]{0,0,1,-1};
    int[] dCol = new int[]{1,-1,0,0};
    public void dfs(int row,int col, char[][]grid){
        if(row<0||row>=grid.length||col<0||col>=grid[0].length||grid[row][col]!='O')return;
        grid[row][col] = 'V';
        for(int i=0;i<4;i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            dfs(nRow,nCol,grid);
        }
    }
}