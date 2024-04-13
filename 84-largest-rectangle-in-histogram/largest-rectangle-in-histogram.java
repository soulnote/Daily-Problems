import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nextSmallerLeft = new int[n];
        int[] nextSmallerRight = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Find the next smaller element to the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            nextSmallerLeft[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear the stack for the next iteration
        stack.clear();

        // Find the next smaller element to the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            nextSmallerRight[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate the maximum area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nextSmallerRight[i] - nextSmallerLeft[i] - 1;
            int area = width * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}
