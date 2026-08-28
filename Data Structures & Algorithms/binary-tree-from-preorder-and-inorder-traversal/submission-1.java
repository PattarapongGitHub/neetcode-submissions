
class Solution {
    public TreeNode helper(int[] preorder, int[] inorder, int preLow, int preHigh, int inLow,
        int inHigh, Map<Integer, Integer> inMap) {
        if (inLow > inHigh || preLow > preHigh) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preLow]);
        int inIndex = inMap.get(preorder[preLow]);

        int leftIndex = inIndex - inLow;
        int NewPreLow = preLow + 1;
        int NewPreHigh = preLow + leftIndex;
        int NewInLow = inLow;
        int NewInHigh = inIndex - 1;
        node.left = helper(preorder, inorder, NewPreLow, NewPreHigh, NewInLow, NewInHigh, inMap);
        int NewPreLow2 = NewPreHigh + 1;
        int NewPreHigh2 = preHigh;
        int NewInLow2 = inIndex + 1;
        int NewInHigh2 = inHigh;
        node.right =
            helper(preorder, inorder, NewPreLow2, NewPreHigh2, NewInLow2, NewInHigh2, inMap);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, inMap);
    }
}