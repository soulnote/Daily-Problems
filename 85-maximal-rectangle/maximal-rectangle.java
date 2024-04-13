class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int maxArea =0;
        int []histogramArr = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0')histogramArr[j]=0;
                else histogramArr[j] += 1;
            }
            maxArea = Math.max(histogramArea(histogramArr,n),maxArea);
        }
        return maxArea;
    }
    public int histogramArea(int []arr,int n){
        int[] nextRight = new int [n];
        int[] nextLeft = new int [n];
        Stack<Integer> st = new Stack<>();

        //left
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nextLeft[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();
        
        //right
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nextRight[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }

        //area
        int max =0;
        for(int i=0;i<n;i++){
            int width = nextRight[i]-nextLeft[i]-1;
            max = Math.max(max, width*arr[i]);
        }
        return max;
    }
}