class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int n: stones){
            pq.add(n);
        }

        while(pq.size()>=0){
            if(pq.size()==0)return 0;
            if(pq.size()==1)break;
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if(stone1!=stone2){
                pq.add((int)Math.abs(stone1-stone2));
            }
        }
        return pq.poll();
    }
}