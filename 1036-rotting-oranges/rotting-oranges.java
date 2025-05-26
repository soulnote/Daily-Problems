class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) q.offer(new int[]{i, j});
            }
        }

        if (fresh == 0) return 0;
        if (q.isEmpty()) return -1;

        int time = 0;
        int[] dRow = {0, 0, 1, -1};
        int[] dCol = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            int size = q.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] top = q.poll();
                int row = top[0];
                int col = top[1];

                for (int k = 0; k < 4; k++) {
                    int nRow = row + dRow[k];
                    int nCol = col + dCol[k];

                    if (nRow >= 0 && nCol >= 0 && nRow < grid.length && nCol < grid[0].length
                        && grid[nRow][nCol] == 1) {
                        grid[nRow][nCol] = 2;
                        fresh--;
                        q.offer(new int[]{nRow, nCol});
                        rottedThisMinute = true;
                    }
                }
            }

            if (rottedThisMinute) time++; // Only increase time if something got rotted
        }

        return fresh == 0 ? time : -1;
    }
}
