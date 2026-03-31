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
    public ListNode reverseList(ListNode head) {
        ListNode ans = solve(head);
        return ans;
    }
    public ListNode solve(ListNode head){
        if(head ==null || head.next == null) return head;
        ListNode next = head.next;
        ListNode revnodes = solve(next);
        next.next = head;
        head.next = null;
        return revnodes;
    }
}