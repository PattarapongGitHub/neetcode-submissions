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
    public int helper(TreeNode root, int max_so_far) {
        int goodNode = 0;

        if (root == null) {
            return 0;
        }
        if (root.val >= max_so_far) {
            goodNode++;
        }

        int mathMax = Math.max(max_so_far, root.val);
        int left = helper(root.left, mathMax);
        int right = helper(root.right, mathMax);

        return goodNode + left + right;
    }
    public int goodNodes(TreeNode root) {
        return helper(root, root.val);
    }
}
