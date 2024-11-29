class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length,n=heights[0].length;
        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];
        Queue<int[]> q = new LinkedList<>(); 
        //checking those cells which will flow in pacific
        for(int i=0;i<m;i++){
            pacific[i][0] = 1;
            q.add(new int[]{i,0});
        }
        for(int j=0;j<n;j++){
            pacific[0][j] = 1;
            q.add(new int[]{0,j});
        }
        bfs(q,'P',heights,pacific,atlantic);

        q.clear();

        //checking those cells which will flow in Atlantic
        for(int j=0;j<n;j++){
            atlantic[m-1][j] = 2;
            q.add(new int[]{m-1,j});
        }
        for(int i=0;i<m;i++){
            atlantic[i][n-1] = 2;
            q.add(new int[]{i,n-1});
        }
       bfs(q,'A',heights,pacific,atlantic);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j]==1 && atlantic[i][j]==2){
                    ans.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        return ans;
    }
    int[]dR = new int[]{1,-1,0,0};
    int[]dC = new int[]{0,0,1,-1};
    public void bfs(Queue<int[]>q,char ocean,int[][]grid,int[][]pacific,int[][]atlantic){
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] present = q.poll();
                int row = present[0];
                int col = present[1];


                for(int k=0;k<4;k++){
                    int nRow = row+dR[k];
                    int nCol = col+dC[k];

                    if(nRow<grid.length && nRow>=0 && nCol>=0 && nCol<grid[0].length && grid[nRow][nCol]>=grid[row][col]){
                        if (ocean == 'P' && pacific[nRow][nCol]==0) {
                            pacific[nRow][nCol] = 1;
                            q.offer(new int[]{nRow, nCol});
                        }
                        if (ocean == 'A' && atlantic[nRow][nCol]==0) {
                            atlantic[nRow][nCol] = 2;
                            q.offer(new int[]{nRow, nCol});
                        }
                    }
                }
            }
        }
    }
}