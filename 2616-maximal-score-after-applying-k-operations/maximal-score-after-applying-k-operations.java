class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for(int num:nums){
            pq.offer(num);
        }
        long sum =0;
        while(k>0){
            int a = pq.poll();
            if(a==1){
                sum += k;
                break;
            }
            int aCeil = (int)Math.ceil(a/3.0);
            pq.offer(aCeil);
            sum+=a;
            k--;
        }
        return sum;
    }
}