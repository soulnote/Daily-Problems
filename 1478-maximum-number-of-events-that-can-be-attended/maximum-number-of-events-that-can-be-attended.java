class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            else return a[0]-b[0];
        });
        int res = 0, day =1, n = events.length;
        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(i<n || pq.size()>0){
            if(pq.isEmpty()){
                day = events[i][0];
            }
            //add all events which starts on same day
            while(i<n && events[i][0]==day){
                pq.add(events[i][1]);
                i++;
            }
            while(!pq.isEmpty() && pq.peek()<day){
                pq.poll();
            }
            if(!pq.isEmpty()){
                pq.poll();
                res++;
            }
            day++;
        }
        return res;
    }
}