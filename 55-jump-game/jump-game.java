class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length;
        int right = n-1;
        boolean[]possible = new boolean[n];
        Arrays.fill(possible, false);
        possible[n-1] = true;
        for(int i=n-2;i>=0;i--){
            int canGoto = nums[i];
            boolean canGo= false;
            for(int j=i;j<n && j<i+canGoto+1;j++){
                if(possible[j]==true){
                    canGo = true;
                    break;
                }
            }
            if(canGo)possible[i] = true;
        }
        return possible[0];
    }
}