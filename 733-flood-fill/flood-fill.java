class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null || image.length==0|| image[sr][sc] == color) return image;
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        int precolor = image[sr][sc];
        image[sr][sc] = color;

        int[] dx =new int[] {0,0,1,-1};
        int[] dy = new int[] {1,-1,0,0};
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                int []arr = q.poll();
                for(int i=0;i<4;i++){
                    int x = dx[i] + arr[0];
                    int y = dy[i] + arr[1];
                    if(x>=0 && y>=0 && x<m && y<n && image[x][y]== precolor){
                        image[x][y] = color;
                        q.add(new int[]{x,y});
                    }
                }
                size--;
            }
        }
        return image;
    }
}