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
   int output = 0;
    int count = 0;

    public void helper (TreeNode root) {

        if (root == null || count <= 0){
            return ;
        }

        helper(root.left);
        count -- ;

        if (count == 0){
            output = root.val;
        } else {
            helper(root.right);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper (root);
        return output;
    }
}
