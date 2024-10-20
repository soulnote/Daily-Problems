class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            int disA = a[0]*a[0] + a[1]*a[1];
            int disB = b[0]*b[0] + b[1]*b[1];
            return disA-disB;
        });
        for(int i=0;i<points.length;i++){
            int []point = points[i];
            pq.add(point);
        }
        int[][] ans = new int [k][2];
        int idx  = 0;
        while(k-->0){
            int[] nearest = pq.poll();
            ans[idx][0] = nearest[0];
            ans[idx][1] = nearest[1];
            idx++;
        }
        return ans;
    }
}