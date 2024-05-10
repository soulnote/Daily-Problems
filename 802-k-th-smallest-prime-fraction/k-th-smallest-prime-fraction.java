class Solution {
    class tuple{
        double fractionValue;
        int first;
        int second;
        tuple(double a, int b , int c){
            this.fractionValue = a;
            this.first = b;
            this.second = c;
        }
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<tuple> pq = new PriorityQueue<>((tuple a, tuple b)->Double.compare(a.fractionValue, b.fractionValue));
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                double first = arr[i];
                double sec = arr[j];
                double frac = first/sec;
                pq.add(new tuple(frac, arr[i], arr[j]));
            }
        }   

        for(int i=0;i<k-1;i++){
            pq.poll();
        }
        int[] ans = new int[]{pq.peek().first, pq.peek().second}; 

        return ans;
    }
}