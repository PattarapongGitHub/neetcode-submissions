/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node newHead = head.next;
        Node copy = newHead;
        curr = head;
        while (curr != null) {
            Node nextOriginal = curr.next.next; // ตอนนี้ nextOriginal คือ B
            curr.next = nextOriginal;

            Node nextCopy ; // ตอนนี้ nextOriginal คือ B
            if (copy.next != null) {
                nextCopy = copy.next.next;
            } else {
                nextCopy = null;
            }
            copy.next = nextCopy;
            copy = nextCopy ;
            curr = nextOriginal;
        }
        return newHead;
    }
}
