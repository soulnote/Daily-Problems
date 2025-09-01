class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double avg1 = (double) a[0] / a[1];
            double avg2 = (double) b[0] / b[1];

            double gain1 = (double) (a[0]+1) / (a[1]+1) - avg1;
            double gain2 = (double) (b[0]+1) / (b[1]+1) - avg2;
            return Double.compare(gain2, gain1); 
        });

        for(int i=0;i<classes.length;i++){
            pq.add(new int[]{classes[i][0],classes[i][1]});
        }

        while(extraStudents>0){
            int[] element = pq.poll();
            int pass = element[0]+1;
            int total = element[1]+1;
            int[] newElement = new int[]{pass, total};
            pq.add(newElement);
            extraStudents--;
        }
        double sumAvg = 0;
        while(pq.size()>0){
            int[]a = pq.poll();
            double avg = (double) a[0]/a[1];
            sumAvg += avg;
        }
        sumAvg = sumAvg/classes.length;
        return sumAvg;
    }
}