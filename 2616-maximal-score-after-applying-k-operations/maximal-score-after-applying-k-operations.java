class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long score = 0;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        while(k-->0){
            int curr = pq.poll();
            System.out.println(curr);
            score+=curr;
            pq.add((int)Math.ceil(curr/3.0));
        }
        return score;
    }
}