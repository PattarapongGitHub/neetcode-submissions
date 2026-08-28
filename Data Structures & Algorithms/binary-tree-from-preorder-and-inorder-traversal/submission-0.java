
class Solution {
     public TreeNode helper(
            int[] preorder, int[] inorder, int preLow, int preHigh, int inLow, int inHigh) {
        if (inLow > inHigh || preLow > preHigh) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preLow]);
        int inIndex = inLow;
        for (int i = inLow; i <= inHigh; i++) {
            if (inorder[i] == preorder[preLow]) {
                inIndex = i;
                break;
            }
        }
        int leftIndex = inIndex - inLow;
        int NewPreLow = preLow + 1;
        int NewPreHigh = preLow + leftIndex;
        int NewInLow = inLow;
        int NewInHigh = inIndex - 1;
        node.left = helper(preorder, inorder, NewPreLow, NewPreHigh, NewInLow, NewInHigh);
        int NewPreLow2 = NewPreHigh + 1;
        int NewPreHigh2 = preHigh;
        int NewInLow2 = inIndex + 1;
        int NewInHigh2 = inHigh;
        node.right = helper(preorder, inorder, NewPreLow2, NewPreHigh2, NewInLow2, NewInHigh2);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
}