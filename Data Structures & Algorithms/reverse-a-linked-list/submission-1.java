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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // เซฟไว้ก่อนเพราะจะ modify ของเก่า
            ListNode next = curr.next;
            // Reverse it
            curr.next = prev;
            // For next iteration เซฟไว้เดี๋ยวหาย
            // prev จะกลายเป็น current ของรอบหน้า while current จะเป็น next ซึ่ง loop สุดท้าย
            // มีแนวโน้มว่าจะเป็น null
            prev = curr;
            curr = next;
        }
        // Return prev เพราะ เป็น current curr
        return prev;
    }
}
