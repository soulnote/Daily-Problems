class Solution {
    class Pair{
        int diff,val;
        public Pair(int diff,int val){
            this.diff=diff;
            this.val=val;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result=new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1,Pair p2){
                if(p2.diff == p1.diff) return p2.val-p1.val;
                return p2.diff-p1.diff;
            }
        });
        
        for(int num:arr){
            pq.add(new Pair(Math.abs(x-num),num));
            if(pq.size()>k) pq.poll();
        }
        while(pq.isEmpty()==false) result.add(pq.poll().val);
        Collections.sort(result);
        return result;
    }
}