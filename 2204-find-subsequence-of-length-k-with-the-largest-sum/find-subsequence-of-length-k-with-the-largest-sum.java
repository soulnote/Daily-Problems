class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            return b[0]-a[0];
        });
        for(int i=0;i<n;i++){
            int[] num = new int[]{nums[i],i};
            pq.add(num);
        }
        int []ans = new int[k];
        for(int i=0;i<k;i++){
            int[]num = pq.poll();
            // System.out.print(num[1]+",");
            ans[i] = num[1];
        }
        Arrays.sort(ans);
        for(int i=0;i<k;i++){
            ans[i] = nums[ans[i]];
         }
        return ans;
    }
}