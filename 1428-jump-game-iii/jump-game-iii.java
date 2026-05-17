class Solution {
    public boolean canReach(int[] arr, int start) {
        int []visited = new int[arr.length];
        boolean ans = solve(arr, start, visited);
        return ans;
    }
    public boolean solve(int[] arr, int i, int[]visited){
        if(i>=arr.length || i<0 || visited[i]==1)return false;
   
        if(arr[i]==0)return true;
        visited[i] = 1;
        boolean left = solve(arr, i-arr[i], visited);
        boolean right = solve(arr, i+arr[i], visited);
        return left||right;
    }
}