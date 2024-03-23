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
        if (head==null || head.next==null || head.next.next==null) return;
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast= slow.next;
        slow.next = null;
        fast = reverse(fast);
        slow = head;
        
        while(fast!=null){
            ListNode node1 = slow.next;
            ListNode node2 = fast.next;

            slow.next = fast;
            fast.next = node1;
            slow = node1;
            fast = node2;
        }
       

    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}