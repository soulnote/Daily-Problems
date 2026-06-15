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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next ==null)return null;
        ListNode fast = head, slow = head;
        while(fast!=null&& fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // System.out.print(slow.val);
        ListNode temp = new ListNode();
        temp.next = head;
        while(temp.next!=slow){
            temp= temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}