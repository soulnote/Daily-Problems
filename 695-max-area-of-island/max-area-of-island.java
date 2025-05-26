class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(maxArea, bfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }
    public int bfs(int[][]grid, int i , int j){
        int[]dr = {1, -1, 0, 0};
        int[]dc = {0, 0, 1, -1};
        grid[i][j]=0;
        int area = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        while(q.size()>0){
            int[]temp = q.poll();
            for(int k=0;k<4;k++){
                int nr = temp[0]+dr[k];
                int nc = temp[1]+dc[k];
                if(nr>=0 && nc>=0 && nr<grid.length 
                && nc<grid[0].length && grid[nr][nc]==1){
                    area++;
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = 0;
                }
            }
        }
        return area;
    }
}