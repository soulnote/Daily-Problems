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
        if(head==null || head.next==null || head.next.next ==null)return ;
        ListNode slow =head,fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow= slow.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode head2 = reverse(fast);
        ListNode headnew = head;
        while(head2!=null){
            ListNode nextofhead = head.next;
            ListNode nextofhead2 = head2.next;
            head.next= head2;
            head2.next = nextofhead;
            head = nextofhead;
            head2= nextofhead2;
        }
        head = headnew;
    }
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}