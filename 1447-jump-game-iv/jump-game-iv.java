class Solution {

    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1)
            return 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int idx = q.poll();

                if (idx == n - 1) {
                    return steps;
                }

                // idx - 1
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // idx + 1
                if (idx + 1 < n && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }

                // same value jumps

                List<Integer> list = map.get(arr[idx]);

                if (list != null) {

                    for (int next : list) {

                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }

                    map.remove(arr[idx]);
                }

                // VERY IMPORTANT OPTIMIZATION
                map.remove(arr[idx]);
            }

            steps++;
        }

        return -1;
    }
}