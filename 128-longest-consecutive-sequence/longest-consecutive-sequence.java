class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0 || nums.length==1) return nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        int val = pq.poll();
        int ans =1, count =1;
        while(pq.size()>0){
            int a = pq.poll();
            if(a==val)continue;
            else if(val+1 == a){
                count++;
                ans = Math.max(count, ans);
            }
            else{
                count =1;
            }
            val = a;
        }
        return ans;
    }
}