class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // adding paths in sequence
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(i + 1);
        }
        int[] ans = new int[queries.length];
        int idx = 0;
        // adding queries paths and generating ans array
        for (int[] path : queries) {
            int u = path[0];
            int v = path[1];
            graph.get(u).add(v);
            int length = shortestPath(n, graph);
            ans[idx] = length;
            idx++;
        }
        return ans;
    }

    public int shortestPath(int n, List<List<Integer>> graph) {
        // Use BFS to find the shortest path
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        boolean[] visited = new boolean[n];

        queue.add(0);
        distance[0] = 0;
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);

                    // If we reach the destination, return the distance
                    if (neighbor == n - 1) {
                        return distance[neighbor];
                    }
                }
            }
        }

        // If no path is found, return -1
        return -1;
    }
}
