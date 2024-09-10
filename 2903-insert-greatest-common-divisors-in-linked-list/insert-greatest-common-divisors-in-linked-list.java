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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        if(temp.next == null)return head;
        while(temp.next!=null){
            ListNode first = temp;
            ListNode second = temp.next;
            int gcdOfTwo = gcd(first.val, second.val);
            ListNode newNode = new ListNode(gcdOfTwo);
            temp.next = newNode;
            newNode.next = second;
            temp = second;
        }
        return head;
    }
    public int gcd(int a , int b){
        
        while(a%b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return b;
    }
}