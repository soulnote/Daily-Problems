class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length==0 || grid==null) return 0;
        int fresh=0,rotten = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                    rotten++;
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int count=0;
        int[] dx =new int[] {0,0,1,-1};
        int[] dy = new int[] {1,-1,0,0};
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] rotpoint = q.poll();
                for(int j=0;j<4;j++){
                    int x = rotpoint[0]+dx[j];
                    int y = rotpoint[1]+dy[j];
                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1){
                        grid[x][y]=2;
                        q.add(new int[]{x,y});
                        fresh--;
                    }
                }
            }
            if(q.size()!=0)count++;
        }
        if(fresh!=0) return -1;
        return count;

    }
}