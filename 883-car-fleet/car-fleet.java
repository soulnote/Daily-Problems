class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][]posTime = new double[n][2];
        for(int i =0;i<n;i++){
            double time = (double)(target - position[i]) / speed[i];
            posTime[i] = new double[]{position[i], time};
        }
        Arrays.sort(posTime,(a, b) -> Double.compare(a[0], b[0]));
        Stack<Double> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(st.size()==0 || posTime[i][1]>st.peek()){
                st.push(posTime[i][1]);
                System.out.println(posTime[i][1]);
            }
           
        }
        return st.size();
    }
}