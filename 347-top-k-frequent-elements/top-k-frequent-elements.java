class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int  i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for(int a : map.keySet()){
            int[] elm = new int[]{a, map.get(a)};
            pq.offer(elm);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            int[] temp = pq.poll();
            ans[i] = temp[0];
        }
        return ans;

    }
}