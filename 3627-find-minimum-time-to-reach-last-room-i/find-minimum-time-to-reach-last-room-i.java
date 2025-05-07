import java.util.*;

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[]{0, 0, 0});

        boolean[][] vis = new boolean[n][m];
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int time = curr[2];
            if (r == n - 1 && c == m - 1) {
                return time;
            }
            if (vis[r][c]) {
                continue;
            }
            vis[r][c] = true;
            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]) {
                    int waitTime = Math.max(time , moveTime[nr][nc]) + 1;
                    if (waitTime < dist[nr][nc]) {
                        dist[nr][nc] = waitTime;
                        pq.add(new int[] {nr, nc, waitTime});
                    } 
                }
            }
        }
        return dist[n-1][m-1];
    }
}
