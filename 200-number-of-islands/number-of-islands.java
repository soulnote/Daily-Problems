class Solution {
    public int numIslands(char[][] grid) {
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
    int[]dRow = new int[]{0,0,1,-1};
    int[]dCol = new int[]{1,-1,0,0};
    public void bfs(int row,int col, char[][]grid){
         
        
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{row,col});
        grid[row][col]='0';
        
        while(!q.isEmpty()){
            int[]t= q.poll();
            for(int i=0;i<4;i++){
                int nRow = t[0]+dRow[i];
                int nCol = t[1]+dCol[i];
                if(nRow>=0 && nRow<grid.length && nCol>=0 && nCol<grid[0].length && grid[nRow][nCol]=='1'){
                    grid[nRow][nCol]='0';
                    q.offer(new int[] {nRow, nCol});
                }
            }
        }
    }
}