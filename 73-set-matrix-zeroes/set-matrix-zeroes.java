class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    list.add(new int[]{i,j});
                }
            }
        }
        for(int idx=0;idx<list.size();idx++){
            int row = list.get(idx)[0];
            int col = list.get(idx)[1];
            for(int j=0;j<n;j++){
                matrix[row][j] = 0;
            }
            for(int i=0;i<m;i++){
                matrix[i][col] = 0;
            }
        }
        return ;
    }
}