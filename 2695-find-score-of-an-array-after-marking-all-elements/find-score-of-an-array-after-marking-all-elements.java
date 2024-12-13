class Solution {
    public long findScore(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[][]arr = new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        boolean[] marked = new boolean[nums.length];
        Arrays.fill(marked , false);

        long score = 0;
        for(int[]num : arr){
            int val = num[0];
            int idx = num[1];
            if(marked[idx]==false){
                marked[idx] = true;
                score+=val;
                if(idx+1<nums.length){
                    marked[idx+1]=true;
                }
                if(idx-1>=0){
                    marked[idx-1]=true;
                }
            }
        }
        return score;
    }
}