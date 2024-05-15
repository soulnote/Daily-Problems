class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] newGrid = new int[m][n];
        for (int[] num : newGrid) {
            Arrays.fill(num, -1);
        }
        Queue<int[]> q = new LinkedList<>();
        
        // Initialize BFS from all 1s (bad cells)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new int[]{i, j, 0});
                    newGrid[i][j] = 0;
                }
            }
        }

        int[] rows = new int[]{1, -1, 0, 0};
        int[] cols = new int[]{0, 0, 1, -1};
        
        // BFS to calculate distance from nearest 1 for each cell
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int d = current[2];
            for (int i = 0; i < 4; i++) {
                int row = x + rows[i];
                int col = y + cols[i];
                int newD = d + 1;
                if (row >= 0 && row < m && col >= 0 && col < n && (newGrid[row][col] == -1 || newGrid[row][col] > newD)) {
                    newGrid[row][col] = newD;
                    q.add(new int[]{row, col, newD});
                }
            }
        }
        
        if (newGrid[0][0] == 0 || newGrid[m-1][n-1] == 0) return 0;
        int maxSafeValue = Math.min(newGrid[0][0], newGrid[m-1][n-1]);
        int left = 0, right = maxSafeValue;
        int max = 0;
        
        // Binary search on the safeness factor
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPathExist(newGrid, mid, m, n)) {
                max = Math.max(max, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return max;
    }

    // BFS to check if a path exists with safeness factor >= minValue
    public boolean isPathExist(int[][] grid, int minValue, int m, int n) {
        if (grid[0][0] < minValue || grid[m-1][n-1] < minValue) return false;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        int[] rows = new int[]{1, -1, 0, 0};
        int[] cols = new int[]{0, 0, 1, -1};
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            if (x == m - 1 && y == n - 1) return true;
            for (int i = 0; i < 4; i++) {
                int row = x + rows[i];
                int col = y + cols[i];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col] && grid[row][col] >= minValue) {
                    visited[row][col] = true;
                    q.add(new int[]{row, col});
                }
            }
        }
        
        return false;
    }
}
