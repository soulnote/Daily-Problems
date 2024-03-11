class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int v = isConnected.length;
  
        int[] visited = new int[v];
        int count=0;
        for(int i=0;i<v;i++){
            if(visited[i]==0){
                dfs(i,isConnected,visited);
                count++;
            }
        }
        return count;
    }
    public void dfs(int v, int[][]isConnected, int[] visited){
        visited[v]=1;
        for(int i=0;i<isConnected[v].length;i++){
            if(isConnected[v][i] ==1 && visited[i]==0){
                dfs(i,isConnected,visited);
            }
        }
    }
}