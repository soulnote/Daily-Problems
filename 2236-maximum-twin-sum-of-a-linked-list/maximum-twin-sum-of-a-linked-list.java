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
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        int maxSum = 0;
        int n = list.size();
        for(int i=0;i<list.size();i++){
            int sum = list.get(i)+list.get(n-i-1);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}