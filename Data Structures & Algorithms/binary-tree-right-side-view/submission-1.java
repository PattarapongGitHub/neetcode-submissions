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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // เรียกใช้ helper method เริ่มต้นที่ depth = 0
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int depth, List<Integer> result) {
        // 1. Base Case: ถ้าเข้าสู่ Node ว่าง ให้หยุด
        if (node == null) {
            return;
        }

        // 2. Logic เช็กการลงมาถึงชั้นใหม่ครั้งแรก
        // (ลองใส่ condition ที่เราคุยกันตรงนี้)
        if (depth == result.size()) {
            result.add(node.val);
        }

        // 3. Recursive Steps: สำรวจฝั่งขวาก่อนฝั่งซ้าย
        // (อย่าลืมเพิ่มค่า depth สำหรับชั้นถัดไป)
        dfs(node.right, depth + 1, result); // ไปทางขวา
        dfs(node.left, depth + 1, result); // ไปทางซ้าย
    }
}
