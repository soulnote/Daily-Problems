/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int [][] grid = new int[m][n];
        for(int[] arr : grid){
            Arrays.fill(arr,-1);
        }

        int top = 0, bottom = m - 1, left = 0,
            right = n - 1;

        // Iterate until all elements are printed
        while (top <= bottom && left <= right) {
            // Print top row from left to right
            for (int i = left; i <= right; ++i) {
                if(head!=null){
                    grid[top][i] = head.val;
                    head= head.next;
                }
            }
            top++;

            // Print right column from top to bottom
            for (int i = top; i <= bottom; ++i) {
             
                if(head!=null){
                    grid[i][right] = head.val;
                    head= head.next;
                }
            }
            right--;

            // Print bottom row from right to left (if
            // exists)
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                   
                    if(head!=null){
                        grid[bottom][i] = head.val;
                        head= head.next;
                    }
                }
                bottom--;
            }

            // Print left column from bottom to top (if
            // exists)
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    if(head!=null){
                        grid[i][left] = head.val;
                        head= head.next;
                    }
                }
                left++;
            }
        }
        return grid;
    }
}