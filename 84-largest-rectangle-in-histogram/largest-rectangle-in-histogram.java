import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        // Arrays to store the indices of the next greater elements to the left and right
        int[] nextGreaterLeft = new int[n];
        int[] nextGreaterRight = new int[n];
        
        // Stack to store indices of elements
        Stack<Integer> stack = new Stack<>();
        
        // Find the indices of the next smaller elements to the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            nextGreaterLeft[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        // Clear the stack for reuse
        stack.clear();
        
        // Find the indices of the next smaller elements to the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            nextGreaterRight[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        // Calculate the maximum area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nextGreaterRight[i] - nextGreaterLeft[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}
