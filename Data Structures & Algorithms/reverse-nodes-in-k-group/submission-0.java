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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode test = head;
        for (int i = 0; i < k; i++) {
            if (test == null) {
                return head;
            }
            test = test.next;
        }

        // Reverse Link list logic
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = null;

        for (int i = 0; i < k; i++) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head.next = reverseKGroup(curr, k);

        return prev;
    }
}
