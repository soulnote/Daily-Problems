class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(long num : gifts){
            pq.add(num);
        }
        for(int i=0;i<k && pq.peek()>1;i++){
            double sq = Math.sqrt(pq.poll());
            long floor = (long)Math.floor(sq);
            pq.add(floor);
        }
        long sum = 0;
        while(pq.size()>0){
            sum+=pq.poll();
        }
        return sum;
    }
}