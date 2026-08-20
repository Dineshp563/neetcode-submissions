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
     
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = inorder.length;
        if (length == 0) {
            return null;
        }
        int rootValue = preorder[0];
        int leftIndex = 0;
        for (int i = 0; i < length; i++) {
            if (rootValue == inorder[i]) {
                leftIndex = i;
                break;
            }
        }

        TreeNode left = buildTree(Arrays.copyOfRange(preorder, 1, leftIndex+1), Arrays.copyOfRange(inorder, 0, leftIndex));
                TreeNode right = buildTree(Arrays.copyOfRange(preorder, leftIndex + 1, length), Arrays.copyOfRange(inorder, leftIndex + 1, length));

        return new TreeNode(rootValue, left, right);
    }
}
