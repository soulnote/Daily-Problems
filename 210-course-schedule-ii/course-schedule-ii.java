class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[]vis = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,adj,vis,st);
            }
        }
        if(isCycle)return new int[]{};
        int []ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = st.peek();
            st.pop();
        }
        return ans;
    }
    boolean isCycle = false;
    public void dfs(int src, List<List<Integer>>adj, int[]vis, Stack<Integer>st){
        vis[src] =1;
        for(Integer nbr : adj.get(src)){
            if(vis[nbr]==0){
                dfs(nbr, adj, vis, st);
                if(isCycle)return;
            }
            else if(vis[nbr]==1){
                isCycle = true;
                return;
            }
        }
        vis[src] = 2;
        st.push(src);
    }
}