class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[]ans = new int[nums.length-k+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int idx = 0;
        for(int i=0;i<nums.length;i++){
            while(q.size()>0 && nums[q.peekLast()]<=nums[i]){
                q.pollLast();
            }
            q.addLast(i);
            
            if(i-q.peekFirst()>=k){
                q.pollFirst();
            }
            if(i>=k-1){
                ans[idx++] = nums[q.peekFirst()];
            }
            
        }
        return ans;
    }
}