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
     
    
    
    Map<Integer, Integer> inOrderPosition = new HashMap<>();
    int preOderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // FIX 1: Reset the class variables so fresh test cases don't crash!
        preOderIndex = 0;
        inOrderPosition.clear();
        for (int i = 0; i < inorder.length; i++) {
            inOrderPosition.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);

    }

    public TreeNode build(int[] preorder, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        int rootValue = preorder[preOderIndex++];
        int rootIndex = inOrderPosition.get(rootValue);
        TreeNode lt = build(preorder, inLeft, rootIndex-1);
        TreeNode rt = build(preorder, rootIndex + 1, inRight);
        return new TreeNode(rootValue, lt, rt);

    }

}
