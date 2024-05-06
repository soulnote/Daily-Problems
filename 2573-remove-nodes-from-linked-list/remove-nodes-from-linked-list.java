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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack();
        ListNode temp = head;
        while(temp!=null){
            while(st.size()>0 && st.peek().val<temp.val){
                st.pop();
            }
            st.push(temp);
            temp = temp.next;
        }
        ListNode lastNode = null;
        // ListNode newHead = new ListNode(0);
        while(!st.isEmpty()){
            ListNode newNode = st.pop();
            newNode.next = lastNode;
            lastNode = newNode;
        }
        return lastNode;
    }
}