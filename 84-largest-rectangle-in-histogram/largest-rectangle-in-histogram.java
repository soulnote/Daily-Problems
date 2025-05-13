import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nextsmallerLeft = new int[n];
        int[] nextsmallerRight = new int[n];

        Stack<Integer> st = new Stack<>();

        // Compute next smaller to left
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nextsmallerLeft[i] = -1;  // No smaller element on the left
            } else {
                nextsmallerLeft[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();  // Clear stack for next computation

        // Compute next smaller to right
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nextsmallerRight[i] = n;  // No smaller element on the right
            } else {
                nextsmallerRight[i] = st.peek();
            }
            st.push(i);
        }

        // Calculate the largest rectangle
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = nextsmallerRight[i] - nextsmallerLeft[i] - 1;  // Calculate the width
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
