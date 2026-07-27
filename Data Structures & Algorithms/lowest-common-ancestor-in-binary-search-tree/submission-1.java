/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while (current != null) {
            // 1. ถ้าทั้ง p และ q ค่าน้อยกว่า current -> เลี้ยวซ้าย 👈
            if (p.val < current.val && q.val < current.val) {
                current = current.left;
            }
            // 2. ถ้าทั้ง p และ q ค่ามากกว่า current -> เลี้ยวขวา 👉
            else if (p.val > current.val && q.val > current.val) {
                current = current.right;
            }
            // 3. ถ้าแยกฝั่ง หรือเจอตัวใดตัวหนึ่งพอดี -> เจอ LCA แล้ว! 🎯
            else {
                return current;
            }
        }
        return null;
    }
}