class Solution {
    
    boolean bfs(int n, ArrayList<ArrayList<Integer>> list, int source, int dest){
        int[] vis = new int[n];
        Queue<Integer>q = new LinkedList<>();
        q.offer(source);
        vis[source] = 1;
        

        while(!q.isEmpty()){
            int node = q.poll();
            if(node==dest) return true; 
            for(int nbr  : list.get(node)){
                if(vis[nbr]==0) {
                    vis[nbr]=1;
                    q.offer(nbr);
                }
            }
        }

        return false;
    }


    public boolean validPath(int n, int[][] edges, int source, int dest) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        } 
        for(int i=0;i<edges.length;i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }

        return bfs(n, list, source, dest);
    }
}