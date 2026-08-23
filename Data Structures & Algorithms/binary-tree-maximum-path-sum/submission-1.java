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
    
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxPathSum;
    }

    private int maxPath(TreeNode root) {
        if (root == null)
            return 0;
        int leftBest = Math.max(0, maxPath(root.left));
        int rightBest = Math.max(0, maxPath(root.right));

        int curSubTreeSum = root.val + leftBest + rightBest;
        maxPathSum = Math.max(curSubTreeSum, maxPathSum);
        return root.val + Math.max(leftBest, rightBest);
    }

}
