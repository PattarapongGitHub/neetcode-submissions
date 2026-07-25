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
    int MAX = 0;

    public int treeHight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = treeHight(root.left);
        int right = treeHight(root.right);

        if (left + right > MAX) {
            MAX = left + right;
        }

        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        treeHight(root);
        return MAX;
    }
}
