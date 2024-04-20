class Solution {
    boolean isPresent = false;
    
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    solve(i, j, 0, board, visited, m, n, word);
                    if (isPresent) return true;
                }
            }
        }
        return false;  
    }
    
    public void solve(int i, int j, int idx, char[][] board, int[][] visited, int m, int n, String word) {
        if (i < 0 || i >= m || j < 0 || j >= n || idx == word.length()) return;
        if (visited[i][j] == 1) return;
        
        if (idx == word.length() - 1 && word.charAt(idx) == board[i][j]) {
            isPresent = true;
            return;
        }
        
        if (word.charAt(idx) != board[i][j]) return;
        
        visited[i][j] = 1;
        solve(i + 1, j, idx + 1, board, visited, m, n, word);
        solve(i - 1, j, idx + 1, board, visited, m, n, word);
        solve(i, j + 1, idx + 1, board, visited, m, n, word);
        solve(i, j - 1, idx + 1, board, visited, m, n, word);
        visited[i][j] = 0;
    }
}
