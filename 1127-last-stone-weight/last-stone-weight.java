class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int n: stones){
            pq.add(n);
        }

        while(pq.size()>=2){
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if(stone1!=stone2){
                pq.add(stone1-stone2);
            }
        }
        if(pq.size()==0)return 0;
        return pq.poll();
    }
}