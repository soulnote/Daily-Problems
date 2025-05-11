class Solution {
    public void bfs(List<List<Integer>> adjacencyList, int node, boolean[] visited, List<Integer> cycles, List<Integer> non_cycles) {
        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        boolean flag = true;
        while(!q.isEmpty()) {
            int x = q.poll();
            flag = flag && adjacencyList.get(x).size() == 2;
            for(int neighbour: adjacencyList.get(x)) {
                if(!visited[neighbour]) {
                    q.add(neighbour);
                    count++;
                    visited[neighbour] = true;
                }
            }
        }

        if(count <= 1) return;
        
        if(flag) {
            cycles.add(count);
        } else {
            non_cycles.add(count);
        }
    }
    
    public long maxScore(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n]; 
        List<Integer> cycles = new ArrayList<>();
        List<Integer> non_cycles = new ArrayList<>();

        for(int node = 0; node < n; node++) {
            if(!visited[node]) {
                bfs(adjacencyList, node, visited, cycles, non_cycles);
            }
        } 

        Collections.sort(cycles, (a, b) -> b - a);
        Collections.sort(non_cycles, (a, b) -> b - a);

        int last = n;
        long ans = 0;

        for(int comp: cycles) {
            long[] l = new long[comp];
            int i = 0, j = comp - 1;
            boolean turn = true;
            
            while(i <= j) {
                if(turn) {
                    l[i] = last;
                    last--;
                    i++;
                } else {
                    l[j] = last;
                    last--;
                    j--;
                }
                turn = !turn;
            }

            for(int idx = 0; idx < comp; idx++) {
                ans = ans + l[idx] * l[(idx + 1) % comp];
            }

        }

        for(int comp: non_cycles) {
            long[] l = new long[comp];
            int i = comp / 2;
            int j = i - 1;

            int tmp1 = last, tmp2 = last - 1;
            while(i < comp) {
                l[i] = tmp1;
                last--;
                tmp1 -= 2;
                i++;
            }

            while(j >= 0) {
                l[j] = tmp2;
                last--;
                tmp2 -= 2;
                j--;
            }

            for(int idx = 0; idx < comp - 1; idx++) {
                ans = ans + l[idx] * l[idx + 1];
            }

        }
        
        return ans;
        
    }
}