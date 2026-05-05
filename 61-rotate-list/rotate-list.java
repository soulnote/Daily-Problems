class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find length
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        k = k % len;
        if (k == 0) return head;

        // Step 2: Find new tail (len - k - 1)
        int steps = len - k - 1;
        ListNode newTail = head;
        while (steps-- > 0) {
            newTail = newTail.next;
        }

        // Step 3: Set new head
        ListNode newHead = newTail.next;

        // Step 4: Find old tail
        ListNode oldTail = newHead;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
        }

        // Step 5: Reconnect
        oldTail.next = head;
        newTail.next = null;

        return newHead;
    }
}