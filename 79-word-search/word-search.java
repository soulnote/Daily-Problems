class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length;
        if(word.length()>m*n) return false;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (board[i][j] == word.charAt(0)){
                    if(cellcheck(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean cellcheck(char [][]board,String word ,int row ,int col,int idx){
        if(idx==word.length())return true;
        if(row>=board.length || row<0 || col<0 || col>=board[0].length || board[row][col]!=word.charAt(idx)){
            return false;
        }
        if(board[row][col]=='1')return false;

        board[row][col] = '1';
        int[] r = {-1, 1, 0, 0};
        int[] c = {0, 0, -1, 1};

        for(int i=0;i<4;i++){
            boolean ans = cellcheck(board, word, row+r[i], col+c[i], idx+1);
            if(ans == true)
                return ans;
        }
        board[row][col] = word.charAt(idx);
        return false;
    }
}