class Solution {
    public int minOperations(int[][] grid, int x) {
        int mod = grid[0][0]%x;
        int mn = grid.length*grid[0].length;
        int[]arr = new int[mn];
        int idx = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]%x != mod)return -1;
                arr[idx++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int left = 0, right = mn-1;
        int ops = 0;
        int median = arr[mn/2];
        for(int num : arr){
            ops+= Math.abs(num - median)/x;
        }
        return ops;

    }
}