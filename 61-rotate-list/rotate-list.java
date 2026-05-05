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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode node = new ListNode(0);
        if(head==null || head.next == null)return head;
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            len++;
        }
        k = k%len;
        // System.out.println(k);
        node = head;
        while(k>0){
            node = node.next;
            k--;
        }
        ListNode fast = node;
        // System.out.println("fast" + fast.val);
        ListNode slow = head;
        // System.out.println("slow" + slow.val);
        while(fast.next!=null ){
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}