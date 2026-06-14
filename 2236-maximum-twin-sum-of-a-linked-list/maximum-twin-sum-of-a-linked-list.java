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
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null)
            return 0;
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        int half = len / 2;
        temp = head;
        while (half > 0) {
            half--;
            temp = temp.next;
        }
        ListNode reversed = reverse(temp);
        // System.out.print(len);
        int maxSum = 0;
        while(reversed!=null){
            int sum = reversed.val+head.val;
            maxSum = Math.max(sum, maxSum);
            reversed = reversed.next;
            head = head.next;
        }
        return maxSum;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next; //step1
            curr.next = prev; //step2
            prev = curr; //step3
            curr = temp; //step4
        }
        return prev;
    }
}