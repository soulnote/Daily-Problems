class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if( k == nums.length)
            return nums;

        int res[] = new int[k];
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int n: nums)
            hm.put(n, hm.getOrDefault(n, 0)+1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> hm.get(b) - hm.get(a));

        for(int i: hm.keySet())
            pq.offer(i);

        for(int i=0; i< k;i++)
            res[i] = pq.poll();
        return res;
    }
}