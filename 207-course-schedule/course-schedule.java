import java.util.*;

class Solution {
    boolean isCycle = false;

    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean ans = true;
        int[] vis = new int[n]; 
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                isCycle = false;
                vis[i] = 1;
                dfs(i, adj, vis);
                if (isCycle) {
                    ans = false;
                    break;
                }
            }
        }

        return ans;
    }

    public void dfs(int src, List<List<Integer>> adj, int[] vis) {
        vis[src] = 1; // Mark current node as visiting

        for (Integer nbr : adj.get(src)) {
            if (vis[nbr] == 1) {
                isCycle = true; // Detected a cycle
                return;
            } 
            else if (vis[nbr] == 0) {
                dfs(nbr, adj, vis);
            }
        }

        vis[src] = 2; 
    }
}
