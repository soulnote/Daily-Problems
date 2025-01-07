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
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode reversedHead = reverse(mid);
        while(reversedHead!=null){
            if(head.val!=reversedHead.val){
                return false;
            }
            head = head.next;
            reversedHead= reversedHead.next;
        }
        return true;
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