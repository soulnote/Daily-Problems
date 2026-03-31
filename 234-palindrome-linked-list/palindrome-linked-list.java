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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next == null)return true;
        ListNode temp = head;
        ListNode fast = head, slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow= slow.next;
        }
        ListNode reversed = solve(slow);
        while(temp!=null && reversed!=null){
            if(temp.val !=reversed.val)return false;
            temp = temp.next;
            reversed = reversed.next;
        }
        return true;

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