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
 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode output = new ListNode(0);
        ListNode curr = output;

        while (l1 != null || l2 != null || carry > 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;
            int remainder = sum % 10;
            //LinkList constructing....
            ListNode dummy = new ListNode(remainder);
            curr.next = dummy;
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return output.next ;
    }
}
