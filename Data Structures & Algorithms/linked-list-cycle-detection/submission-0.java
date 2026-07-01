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
public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode tortoise = head;
        ListNode hare = head;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare =  hare.next.next;
            if (tortoise == hare) {
                return true;
            }
        }
        return false;
    }
}
