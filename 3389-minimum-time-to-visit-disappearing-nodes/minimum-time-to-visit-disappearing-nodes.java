class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        
        ArrayList<int[]>graph[]=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
        for(int e[]:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            graph[u].add(new int[]{v,w});
            graph[v].add(new int[]{u,w});
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});
        boolean visited[]=new boolean[n];
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int v=curr[0],w=curr[1];
            if(dist[v]<=w) continue;
            visited[v]=true;
            dist[v]=w;
            for(int next[]:graph[v]){
                int u=next[0];
                int c=next[1];
                if(visited[u]||w+c>=disappear[u]) continue;
                pq.add(new int[]{u,w+c});
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE) dist[i]=-1;
        }
        return dist;
    }
}