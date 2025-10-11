class Solution {
    int[][] result = null;
    int[][] count = null;
    public int[][] resultGrid(int[][] image, int threshold) {
        int m = image.length;
        int n = image[0].length;
        result = new int[m][n];
        count = new int[m][n];

        for(int i=0;i<m-2;i++){
            for(int j=0;j<n-2;j++){
                int currentAvg = calculateAvg(image, i, j, threshold);
                if(currentAvg != Integer.MIN_VALUE){
                    updateAvg(image, i, j , currentAvg, threshold);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(count[i][j] != 0){
                    result[i][j] = (result[i][j] / count[i][j]);
                }
                else{
                    result[i][j] = image[i][j];
                }
            }
        }
        return result;
    }
    public void updateAvg(int[][] image, int row, int col, int currentAvg, int threshold){
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                result[i][j] += currentAvg;
                count[i][j]++;
            }
        }
    }
    public int calculateAvg(int[][] image, int row, int col, int threshold){
        int tempSum = 0;
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(!isCurrentPositionValid(image, i, j, threshold, row, col)){
                    return Integer.MIN_VALUE;
                }
                tempSum+=image[i][j];
            }
        }
        return tempSum/9;
    }
    public boolean isCurrentPositionValid(int[][] image, int row, int col, int threshold, int startRow, int startCol){
        if(row-1>=startRow && Math.abs(image[row-1][col] - image[row][col])>threshold)
            return false;
        if(row+1<=startRow+2 && Math.abs(image[row+1][col] - image[row][col])>threshold)
            return false;
        if(col-1>=startCol && Math.abs(image[row][col-1] - image[row][col])>threshold)
            return false;
        if(col+1<=startCol+2 && Math.abs(image[row][col+1] - image[row][col])>threshold)
            return false;
        return true;

    }
}