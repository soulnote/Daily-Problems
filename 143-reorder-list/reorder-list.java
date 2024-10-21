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
    public void reorderList(ListNode head) {
        if(head==null || head.next == null || head.next.next==null)return ;
        ListNode fast = head, slow = head;
        
        while(fast.next!=null && fast.next.next!=null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow. next;
        slow.next = null;
        fast = reverse(fast);
        
        ListNode ans = new ListNode(0);
        ListNode start = head;
        while(start!=null && fast!=null){
            ans.next = start;
            ans = ans.next;
            start = start.next;
            ans.next = fast;
            ans = ans.next;
            fast = fast.next;
        }
        while(fast!=null){
            ans.next = fast;
            fast = fast.next;
        }
        while(start!=null){
            ans.next = start;
            start = start.next;
        }
        return;
    }
    public ListNode reverse(ListNode head){
            ListNode pre = null;
            ListNode curr = head;
            while(curr!=null){
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
        }
}