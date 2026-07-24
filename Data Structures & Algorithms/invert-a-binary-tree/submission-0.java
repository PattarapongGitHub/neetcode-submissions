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
public TreeNode invertTree(TreeNode root) {
        // Base case: ถ้าเจอ Node ว่างให้หยุด
        if (root == null) {
            return null;
        }
        
        // 1. ลงไปจัดการฝั่งซ้ายและขวาก่อน (Post-order)
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        // 2. สลับ pointer ที่ Node แม่
        root.left = right;
        root.right = left;
        
        return root;
    }
}
