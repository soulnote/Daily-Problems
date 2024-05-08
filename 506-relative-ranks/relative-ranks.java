class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a,int[] b)->b[0]-a[0]);
        
        for(int i=0;i<n;i++){
            pq.add(new int[]{score[i],i});
            
        }
        
        String[]ans = new String[n];
        int i =1;
        while(!pq.isEmpty() && i<=3 ){
            int val = pq.peek()[0];
            int idx = pq.peek()[1];
            if(i==1)ans[idx] = "Gold Medal";
            if(i==2)ans[idx] = "Silver Medal";
            if(i==3)ans[idx] = "Bronze Medal";
            pq.poll();
            i++;
        }
        while(!pq.isEmpty()){
            int[]a = pq.poll();
            ans[a[1]] = ""+ i;
            i++;
        }
        return ans;
    }
}