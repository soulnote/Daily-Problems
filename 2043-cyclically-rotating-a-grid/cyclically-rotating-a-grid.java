class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int cycles = Math.min(n / 2, m / 2);
        Queue<int[]> q = new LinkedList<>();
        int toprow = 0, topcol = 0;
        int bottomrow = m - 1, bottomcol = n - 1;

        while (cycles > 0) {
            rotate(toprow, topcol, bottomrow, bottomcol, grid, k);
            toprow++;
            topcol++;
            bottomrow--;
            bottomcol--;
            cycles--;
        }
        return grid;
    }

    public void rotate(int toprow, int topcol, int bottomrow, int bottomcol, int[][] grid, int k) {
        // top 
        List<Integer> list = new ArrayList<>();
        for (int i = toprow, j = topcol; j <= bottomcol; j++) {
            list.add(grid[i][j]);
            // System.out.println(grid[i][j] + ",");
        }
        for (int i = toprow + 1, j = bottomcol; i <= bottomrow; i++) {
            list.add(grid[i][j]);
        }
        for (int i = bottomrow, j = bottomcol - 1; j >= topcol; j--) {
            list.add(grid[i][j]);
        }
        for (int i = bottomrow - 1, j = topcol; i > toprow; i--) {
            list.add(grid[i][j]);
        }
        
        int count = list.size();
        int effectiveK = k % count;
        int idx = effectiveK;

        for (int j = topcol; j <= bottomcol; j++){
            grid[toprow][j] = list.get(idx++ % count);
        }
        for (int i = toprow + 1; i <= bottomrow; i++){
            grid[i][bottomcol] = list.get(idx++ % count);
        }
        for (int j = bottomcol - 1; j >= topcol; j--){
            grid[bottomrow][j] = list.get(idx++ % count);
        }
        for (int i = bottomrow - 1; i > toprow; i--){
            grid[i][topcol] = list.get(idx++ % count);
        }
        return;

    }
}