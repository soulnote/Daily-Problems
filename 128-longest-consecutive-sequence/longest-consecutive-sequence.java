class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0 || nums.length==1) return nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        int count =0;
        int pre = pq.poll();
        count++;
        int ans = count;
        while(pq.size()>0){
            int a = pq.poll();
            if(pre+1==a){
                count++;
                ans = Math.max(count,ans);
            }
            else if(pre == a)continue;
            else{
                count=1;
            }
            pre = a;
        }
        return ans;
    }
}