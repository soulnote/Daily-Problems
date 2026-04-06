class Solution {

    // 🔹 Left pointer (global / class level)
    // Yeh hamesha list ke start se move karega
    ListNode left;

    public void reorderList(ListNode head) {
        left = head;          // left ko head pe initialize kiya
        reorder(head);        // recursion start (right pointer)
    }

    private void reorder(ListNode right) {

        // 🔹 Base Case: jab list end ho jaye
        if (right == null) return;

        // 🔹 Step 1: recursion se last node tak jao
        reorder(right.next);

        // 🔹 Agar already kaam complete ho gaya ho
        if (left == null) return;

        // 🔹 Stop Condition:
        // Case 1: left == right → odd length, middle node
        // Case 2: left.next == right → even length, pointers cross ho gaye
        if (left == right || left.next == right) {
            right.next = null;   // list ko yahin terminate kar do
            left = null;         // mark done (baaki recursion skip ho jayega)
            return;
        }

        // 🔹 Step 2: links reorder karo
        ListNode nextLeft = left.next;  // left ka next save kar lo

        left.next = right;              // left → right
        right.next = nextLeft;          // right → nextLeft

        // 🔹 Step 3: left pointer ko aage badhao
        left = nextLeft;
    }
}