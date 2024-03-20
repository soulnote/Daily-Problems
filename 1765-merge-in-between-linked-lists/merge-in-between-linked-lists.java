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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp1 = new ListNode(0);
        temp1.next = list1;
        for(int i=0;i<a;i++){
            temp1 = temp1.next;
        }
        ListNode temp1next = temp1.next;
        temp1.next = list2;
        for(int i=0;i<b-a;i++){
            temp1next = temp1next.next;
        }
        ListNode temp2 = list2;
        while(temp2.next!=null){
            temp2=temp2.next;
        }
        temp2.next = temp1next.next;
        return list1;
        
    }
}