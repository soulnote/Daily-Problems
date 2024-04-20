class Solution {
    int Imax=0,Jmax=0;
    public int[][] findFarmland(int[][] land) {
        int m = land.length,n=land[0].length;
        int [][] vis = new int[m][n];
        for(int[]num:vis){
            Arrays.fill(num,0);
        }
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int landtype = land[i][j];
                if(landtype==1 && vis[i][j]==0){
                    Imax=i;
                    Jmax=j;
                    solve(i,j,vis,land);
                    list.add(new int[]{i,j,Imax,Jmax});
                }
            }
        }
        int[][]ans = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) 
            ans[i] = list.get(i); 
        return ans;
    }
    public void solve(int i,int j, int[][]vis, int [][]land){
        if(i<0||i>=land.length||j<0||j>=land[0].length||land[i][j]==0||vis[i][j]==1)return;
        vis[i][j]=1;
        Imax = Math.max(i,Imax);
        Jmax = Math.max(j,Jmax);
        int[]r = new int[]{0,0,1,-1};
        int[]c = new int[]{1,-1,0,0};
        for(int k=0;k<4;k++){
            int row = i+r[k];
            int col = j+c[k];
            solve(row,col,vis,land);
        }
    }
}