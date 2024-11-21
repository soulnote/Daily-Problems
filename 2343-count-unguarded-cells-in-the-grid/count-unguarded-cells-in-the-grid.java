import java.util.*;

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        // 0 -> unguarded, 1 -> guard, 2 -> wall, 3 -> guarded

        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }

        // Directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Function to mark the cells in a direction
        for (int[] guard : guards) {
            int r = guard[0], c = guard[1];

            for (int[] dir : directions) {
                int nr = r, nc = c;
                while (true) {
                    nr += dir[0];
                    nc += dir[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == 1 || grid[nr][nc] == 2) {
                        break;
                    }
                    if (grid[nr][nc] == 0) {
                        grid[nr][nc] = 3;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
