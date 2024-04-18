class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] p1,int[] p2){
                int area1 = p1[0]*p1[0] + p1[1]*p1[1];
                int area2 = p2[0]*p2[0] + p2[1]*p2[1];
                
                return area1-area2;
            }
        });
        for(int[]point:points){
            pq.offer(point);
        }
        int[][]ans = new int[k][2];
        for(int i=0;i<k;i++){
            int[] p = pq.poll();
            ans[i][0]= p[0];
            ans[i][1]= p[1];
        }
        return ans;
    }
}